package com.rtbhouse.custom.logical.types;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.avro.specific.SpecificRecordBase;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.linkedin.avro.fastserde.FastDeserializer;
import com.linkedin.avro.fastserde.FastGenericDeserializerGenerator;
import com.linkedin.avro.fastserde.FastGenericSerializerGenerator;
import com.linkedin.avro.fastserde.FastSerializer;
import com.linkedin.avro.fastserde.FastSpecificDeserializerGenerator;
import com.linkedin.avro.fastserde.FastSpecificSerializerGenerator;
import com.linkedin.avroutil1.compatibility.SchemaNormalization;
import com.rtbhouse.avro.InMemoryEncoder;
import com.rtbhouse.generated.avro.RecordWithCustomLogicalTypes;
import com.rtbhouse.generated.avro.RecordWithoutCustomLogicalTypes;

public class CustomLogicalTypesTest {

    private final File classesDir;
    private final ClassLoader classLoader;

    CustomLogicalTypesTest() {
        try {
            classesDir = getCodeGenDirectory();
            classLoader = URLClassLoader.newInstance(
                    new URL[]{classesDir.toURI().toURL()}, getClass().getClassLoader());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void shouldSerializeRecordWithCustomConversions() throws IOException {
        // given
        Map<String, CustomDuration> mapOfNullableCustomDurations = new HashMap<>();
        mapOfNullableCustomDurations.put("fiveDays", new CustomDuration(0, 5, 0));
        mapOfNullableCustomDurations.put("aNull", null);

        RecordWithCustomLogicalTypes data = RecordWithCustomLogicalTypes.newBuilder()
                .setCustomDurationField(new CustomDuration(1, 2, 3))
                .setMapOfCustomDurations(Map.of("aMonth", new CustomDuration(1, 0, 0)))
                .setMapOfNullableCustomDurations(mapOfNullableCustomDurations)
                .setDaysSince2000Field(new DaysSince2000(10))
                .setArrayOfUnionOfNullableCustomTypes(Arrays.asList(null, null,
                        new CustomDuration(3, 5, 7),
                        new DaysSince2000(40),
                        new DaysSince2000(4000),
                        new CustomDuration(9, 9, 7)))
                .build();

        // expect serializing RecordWithCustomLogicalTypes to byte[] is fine
        byte[] bytes = data.toByteBuffer().array();
        assertOtherSerializersAreEquivalent(data, bytes);

        // and deserializing byte[] to RecordWithCustomLogicalTypes is fine
        assertOtherDeserializersAreEquivalent(data, bytes);

        // and deserializing byte[] to RecordWithoutCustomLogicalTypes is fine
        byte[] bytesWithNoLogicalTypes = replaceV1Header(bytes, RecordWithoutCustomLogicalTypes.SCHEMA$);
        RecordWithoutCustomLogicalTypes noLogicalTypesData = RecordWithoutCustomLogicalTypes.fromByteBuffer(
                ByteBuffer.wrap(bytesWithNoLogicalTypes));
        assertOtherDeserializersAreEquivalent(noLogicalTypesData, bytesWithNoLogicalTypes);

        // and serializing RecordWithoutCustomLogicalTypes to byte[] is fine
        assertOtherSerializersAreEquivalent(noLogicalTypesData, bytes);
    }

    private <T extends SpecificRecordBase> void assertOtherSerializersAreEquivalent(T data, byte[] defaultBytes) throws IOException {
        defaultBytes = ArrayUtils.subarray(defaultBytes, 10, defaultBytes.length); // drop V1-header
        Schema schema = data.getSchema();
        SpecificData specificData = data.getSpecificData();
        GenericData genericData = new GenericData();
        specificData.getConversions().forEach(genericData::addLogicalTypeConversion);

        FastSpecificSerializerGenerator<T> specificSerializerGenerator =
                new FastSpecificSerializerGenerator<>(schema, classesDir, classLoader, null, specificData);

        FastGenericSerializerGenerator<T> genericSerializerGenerator =
                new FastGenericSerializerGenerator<>(schema, classesDir, classLoader, null, genericData);

        FastSerializer<T> fastSpecificSerializer = specificSerializerGenerator.generateSerializer();
        FastSerializer<T> fastGenericSerializer = genericSerializerGenerator.generateSerializer();

        SpecificDatumWriter<T> specificDatumWriter = new SpecificDatumWriter<>(schema, specificData);
        GenericDatumWriter<T> genericDatumWriter = new GenericDatumWriter<>(schema, genericData);

        // when
        InMemoryEncoder inMemoryEncoder1 = new InMemoryEncoder();
        fastSpecificSerializer.serialize(data, inMemoryEncoder1);
        byte[] bytes1 = inMemoryEncoder1.toByteArray();

        InMemoryEncoder inMemoryEncoder2 = new InMemoryEncoder();
        fastGenericSerializer.serialize(data, inMemoryEncoder2);
        byte[] bytes2 = inMemoryEncoder2.toByteArray();

        InMemoryEncoder inMemoryEncoder3 = new InMemoryEncoder();
        specificDatumWriter.write(data, inMemoryEncoder3);
        byte[] bytes3 = inMemoryEncoder3.toByteArray();

        InMemoryEncoder inMemoryEncoder4 = new InMemoryEncoder();
        genericDatumWriter.write(data, inMemoryEncoder4);
        byte[] bytes4 = inMemoryEncoder4.toByteArray();

        // then
        Assertions.assertArrayEquals(defaultBytes, bytes1);
        Assertions.assertArrayEquals(defaultBytes, bytes2);
        Assertions.assertArrayEquals(defaultBytes, bytes3);
        Assertions.assertArrayEquals(defaultBytes, bytes4);
    }

    private <T extends SpecificRecordBase> void assertOtherDeserializersAreEquivalent(T originalData, byte[] defaultBytes) throws IOException {
        byte[] bytesWithoutHeader = ArrayUtils.subarray(defaultBytes, 10, defaultBytes.length); // drop V1-header
        Schema schema = originalData.getSchema();
        SpecificData specificData = originalData.getSpecificData();
        GenericData genericData = new GenericData();
        specificData.getConversions().forEach(genericData::addLogicalTypeConversion);
        Supplier<Decoder> decoderFactory = () -> DecoderFactory.get().binaryDecoder(bytesWithoutHeader, null);

        FastSpecificDeserializerGenerator<T> specificDeserializerGenerator =
                new FastSpecificDeserializerGenerator<>(schema, schema, classesDir, classLoader, null, specificData);

        FastGenericDeserializerGenerator<GenericData.Record> genericDeserializerGenerator =
                new FastGenericDeserializerGenerator<>(schema, schema, classesDir, classLoader, null, genericData);

        FastDeserializer<T> fastSpecificDeserializer = specificDeserializerGenerator.generateDeserializer();
        FastDeserializer<GenericData.Record> fastGenericDeserializer = genericDeserializerGenerator.generateDeserializer();

        SpecificDatumReader<T> specificDatumReader = new SpecificDatumReader<>(schema, schema, specificData);
        GenericDatumReader<GenericData.Record> genericDatumReader = new GenericDatumReader<>(schema, schema, genericData);

        // when
        T deserialized1 = fastSpecificDeserializer.deserialize(null, decoderFactory.get());
        T deserialized2 = specificDatumReader.read(null, decoderFactory.get());
        GenericData.Record deserialized3 = fastGenericDeserializer.deserialize(null, decoderFactory.get());
        GenericData.Record deserialized4 = genericDatumReader.read(null, decoderFactory.get());

        // then
        Assertions.assertEquals(originalData, deserialized1);
        Assertions.assertEquals(originalData, deserialized2);
        assertEquals(originalData, deserialized3);
        assertEquals(originalData, deserialized4);
    }

    private <T extends SpecificRecordBase> void assertEquals(T expected, GenericData.Record actual) throws IOException {
        Assertions.assertEquals(actual.toString(), expected.toString());

        GenericDatumWriter<GenericData.Record> genericDatumWriter = new GenericDatumWriter<>(
                actual.getSchema(), copyConversions(expected.getSpecificData(), new GenericData()));

        SpecificDatumWriter<T> specificDatumWriter = new SpecificDatumWriter<>(
                expected.getSchema(), copyConversions(expected.getSpecificData(), new SpecificData()));

        byte[] genericBytes = serialize(genericDatumWriter, actual);
        byte[] expectedBytes = serialize(specificDatumWriter, expected);

        Assertions.assertArrayEquals(genericBytes, expectedBytes);
    }

    private <T extends GenericRecord> byte[] serialize(DatumWriter<T> datumWriter, T data) throws IOException {
        InMemoryEncoder encoder = new InMemoryEncoder();
        datumWriter.write(data, encoder);

        return encoder.toByteArray();
    }

    private <T extends GenericData> T copyConversions(SpecificData fromSpecificData, T toModelData) {
        Optional.ofNullable(fromSpecificData.getConversions())
                .orElse(Collections.emptyList())
                .forEach(toModelData::addLogicalTypeConversion);

        return toModelData;
    }

    private byte[] replaceV1Header(byte[] bytesWithHeader, Schema schema) {
        final int v1HeaderLength = 10;
        byte[] v1Header = ByteBuffer.wrap(new byte[v1HeaderLength])
                .order(ByteOrder.LITTLE_ENDIAN)
                .put(new byte[]{(byte) 0xC3, (byte) 0x01}) // BinaryMessageEncoder.V1_HEADER
                .putLong(SchemaNormalization.parsingFingerprint64(schema))
                .array();

        byte[] copy = Arrays.copyOf(bytesWithHeader, bytesWithHeader.length);
        System.arraycopy(v1Header, 0, copy, 0, v1HeaderLength);

        return copy;
    }

    private static File getCodeGenDirectory() throws IOException {
        Path codeGenOutput = Paths.get("./target/generated-fast-avro/java/");
        File dir;
        if (Files.notExists(codeGenOutput)) {
            dir = Files.createDirectories(codeGenOutput).toFile();
        } else {
            dir = codeGenOutput.toFile();
        }
        return dir;
    }
}
