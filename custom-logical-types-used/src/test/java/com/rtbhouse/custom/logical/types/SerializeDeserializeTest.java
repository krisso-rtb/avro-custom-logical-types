package com.rtbhouse.custom.logical.types;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.avro.Schema;
import org.apache.avro.io.BinaryDecoder;
import org.apache.avro.io.BinaryEncoder;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.rtbhouse.generated.avro.Location;
import com.rtbhouse.generated.avro.PointsOfInterest;

public class SerializeDeserializeTest {

    @Test
    void shouldSerializeAndDeserializeAvro() {
        PointsOfInterest originalPoi = PointsOfInterest.newBuilder()
                .setUsername("kris")
                .setLocations(List.of(Location.newBuilder()
                        .setDescription("Casino")
                        .setCoordinates(new LatLon(30.123, -90.98762))
                        .build()))
                .build();

        byte[] serializedAvro = serialize(originalPoi);

        PointsOfInterest deserializedPoi = deserialize(serializedAvro);

        // these lines go fine:
        boolean equalsOnWholeObject1 = deserializedPoi.equals(originalPoi);
        boolean equalsOnWholeObject2 = originalPoi.equals(deserializedPoi);
        boolean equalsOnLocations1 = originalPoi.getLocations().equals(deserializedPoi.getLocations());

        // but below line explodes with:
        // org.apache.avro.AvroRuntimeException:
        // Unknown datum type com.rtbhouse.custom.logical.types.LatLon: LatLon[latitude=30.123, longitude=-90.98762]
        boolean equalsOnLocations2 = deserializedPoi.getLocations().equals(originalPoi.getLocations());

        Assertions.assertTrue(equalsOnWholeObject1);
        Assertions.assertTrue(equalsOnWholeObject2);
        Assertions.assertTrue(equalsOnLocations1);
        Assertions.assertTrue(equalsOnLocations2);
    }

    private byte[] serialize(PointsOfInterest pointsOfInterest) {
        Schema schema = PointsOfInterest.getClassSchema();
        SpecificData specificData = SpecificData.getForSchema(schema);
        SpecificDatumWriter<PointsOfInterest> datumWriter = new SpecificDatumWriter<>(schema, specificData);

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream(4096)) {
            BinaryEncoder binaryEncoder = EncoderFactory.get().directBinaryEncoder(outputStream, null);
            datumWriter.write(pointsOfInterest, binaryEncoder);

            binaryEncoder.flush();
            return outputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private PointsOfInterest deserialize(byte[] bytes) {
        Schema schema = PointsOfInterest.getClassSchema();
        SpecificData specificData = SpecificData.getForSchema(schema);

        DatumReader<PointsOfInterest> datumReader = new SpecificDatumReader<>(schema, schema, specificData);
        BinaryDecoder binaryDecoder = DecoderFactory.get().binaryDecoder(bytes, null);

        try {
            return datumReader.read(null, binaryDecoder);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
