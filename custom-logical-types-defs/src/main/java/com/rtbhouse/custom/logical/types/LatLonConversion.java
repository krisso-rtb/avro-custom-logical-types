package com.rtbhouse.custom.logical.types;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import org.apache.avro.Conversion;
import org.apache.avro.LogicalType;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericFixed;

public class LatLonConversion extends Conversion<LatLon> {

    @Override
    public Class<LatLon> getConvertedType() {
        return LatLon.class;
    }

    @Override
    public String getLogicalTypeName() {
        return LatLonLogicalTypeFactory.LOGICAL_TYPE_NAME;
    }

    @Override
    public GenericFixed toFixed(LatLon value, Schema schema, LogicalType type) {
        byte[] bytes = ByteBuffer.wrap(new byte[8 * 2])
                .order(ByteOrder.LITTLE_ENDIAN)
                .putDouble(value.latitude())
                .putDouble(value.longitude())
                .array();

        return new GenericData.Fixed(schema, bytes);
    }

    @Override
    public LatLon fromFixed(GenericFixed value, Schema schema, LogicalType type) {
        final ByteBuffer littleEndianBuffer = ByteBuffer.wrap(value.bytes())
                .order(ByteOrder.LITTLE_ENDIAN);
        return new LatLon(littleEndianBuffer.getDouble(), littleEndianBuffer.getDouble());
    }
}
