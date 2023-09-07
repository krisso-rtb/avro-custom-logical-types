package com.rtbhouse.custom.logical.types;

import org.apache.avro.LogicalType;
import org.apache.avro.LogicalTypes;
import org.apache.avro.Schema;

public class DaysSince2000LogicalTypeFactory implements LogicalTypes.LogicalTypeFactory {

    public static final String LOGICAL_TYPE_NAME = "days-since-2000";

    public static final LogicalType TYPE = new LogicalType(LOGICAL_TYPE_NAME) {
        @Override
        public void validate(Schema schema) {
            super.validate(schema);
            if (schema.getType() != Schema.Type.INT) {
                throw new IllegalArgumentException("DaysSince2000 can only be used with an underlying INT type");
            }
        }
    };

    @Override
    public LogicalType fromSchema(Schema schema) {
        return TYPE;
    }

    // @Override - no annotation, method is undefined in LogicalTypeFactory in Avro 1.9
    @Override
    public String getTypeName() {
        return LOGICAL_TYPE_NAME;
    }
}

