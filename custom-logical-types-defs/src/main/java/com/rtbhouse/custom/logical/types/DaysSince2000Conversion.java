package com.rtbhouse.custom.logical.types;

import org.apache.avro.Conversion;
import org.apache.avro.LogicalType;
import org.apache.avro.Schema;

public class DaysSince2000Conversion extends Conversion<DaysSince2000> {

    @Override
    public Class<DaysSince2000> getConvertedType() {
        return DaysSince2000.class;
    }

    @Override
    public String getLogicalTypeName() {
        return DaysSince2000LogicalTypeFactory.LOGICAL_TYPE_NAME;
    }

    @Override
    public Integer toInt(DaysSince2000 value, Schema schema, LogicalType type) {
        return value.daysSince2000();
    }

    @Override
    public DaysSince2000 fromInt(Integer value, Schema schema, LogicalType type) {
        return new DaysSince2000(value);
    }
}
