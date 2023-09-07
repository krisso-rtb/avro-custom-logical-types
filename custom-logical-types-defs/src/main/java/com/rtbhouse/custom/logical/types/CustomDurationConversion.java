package com.rtbhouse.custom.logical.types;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import org.apache.avro.Conversion;
import org.apache.avro.LogicalType;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericFixed;

public class CustomDurationConversion extends Conversion<CustomDuration> {

    @Override
    public Class<CustomDuration> getConvertedType() {
        return CustomDuration.class;
    }

    @Override
    public String getLogicalTypeName() {
        return CustomDurationLogicalTypeFactory.LOGICAL_TYPE_NAME;
    }

    @Override
    public GenericFixed toFixed(CustomDuration value, Schema schema, LogicalType type) {
        byte[] bytes = ByteBuffer.wrap(new byte[12])
                .order(ByteOrder.LITTLE_ENDIAN)
                .putInt(value.months())
                .putInt(value.days())
                .putInt(value.millis())
                .array();

        // TwelveBytes class is not generated yet
//        try {
//            return (GenericFixed) Class.forName(schema.getFullName())
//                    .getConstructor(byte[].class)
//                    .newInstance(bytes);
//        } catch (InstantiationException | IllegalAccessException | InvocationTargetException
//                 | NoSuchMethodException | ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }

        return new GenericData.Fixed(schema, bytes);
    }

    @Override
    public CustomDuration fromFixed(GenericFixed value, Schema schema, LogicalType type) {
        ByteBuffer littleEndianBuffer = ByteBuffer.wrap(value.bytes())
                .order(ByteOrder.LITTLE_ENDIAN);
        return new CustomDuration(littleEndianBuffer.getInt(), littleEndianBuffer.getInt(), littleEndianBuffer.getInt());
    }
}
