package com.rtbhouse.custom.logical.types;

import org.apache.avro.LogicalType;
import org.apache.avro.LogicalTypes;
import org.apache.avro.Schema;

public class CustomDurationLogicalTypeFactory implements LogicalTypes.LogicalTypeFactory {

    public static final String LOGICAL_TYPE_NAME = "custom-duration";

    public static final LogicalType TYPE = new LogicalType(LOGICAL_TYPE_NAME) {
        @Override
        public void validate(Schema schema) {
            super.validate(schema);
            if (schema.getType() != Schema.Type.FIXED) {
                throw new IllegalArgumentException("CustomDuration can only be used with an underlying FIXED type");
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

