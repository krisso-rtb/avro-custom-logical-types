
package com.linkedin.avro.fastserde.generated.serialization.AVRO_1_10;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import com.linkedin.avro.fastserde.FastSerializer;
import com.rtbhouse.custom.logical.types.CustomDuration;
import com.rtbhouse.custom.logical.types.CustomDurationConversion;
import com.rtbhouse.custom.logical.types.DaysSince2000;
import com.rtbhouse.custom.logical.types.DaysSince2000Conversion;
import org.apache.avro.Conversions;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericFixed;
import org.apache.avro.generic.IndexedRecord;
import org.apache.avro.io.Encoder;

public class RecordWithCustomLogicalTypes_GenericSerializer_211388675
    implements FastSerializer<IndexedRecord>
{

    private final GenericData modelData;
    private final DaysSince2000Conversion conversion_days_since_2000 = new DaysSince2000Conversion();
    private final CustomDurationConversion conversion_custom_duration = new CustomDurationConversion();
    private final Schema logicalTypeSchema__43761047 = Schema.parse("{\"type\":\"fixed\",\"name\":\"TwelveBytes\",\"namespace\":\"com.rtbhouse.generated.avro\",\"size\":12,\"logicalType\":\"custom-duration\"}");
    private final Schema logicalTypeSchema__1616559509 = Schema.parse("{\"type\":\"int\",\"logicalType\":\"days-since-2000\"}");

    public RecordWithCustomLogicalTypes_GenericSerializer_211388675(GenericData modelData) {
        this.modelData = modelData;
    }

    public void serialize(IndexedRecord data, Encoder encoder)
        throws IOException
    {
        serializeRecordWithCustomLogicalTypes0(data, (encoder));
    }

    @SuppressWarnings("unchecked")
    public void serializeRecordWithCustomLogicalTypes0(IndexedRecord data, Encoder encoder)
        throws IOException
    {
        Object convertedValue0 = data.get(0);
        convertedValue0 = Conversions.convertToRawType(convertedValue0, this.logicalTypeSchema__43761047, this.logicalTypeSchema__43761047 .getLogicalType(), this.conversion_custom_duration);
        (encoder).writeFixed(((GenericFixed) convertedValue0).bytes());
        Map<CharSequence, CustomDuration> mapOfCustomDurations0 = ((Map<CharSequence, CustomDuration> ) data.get(1));
        (encoder).writeMapStart();
        if ((mapOfCustomDurations0 == null)||mapOfCustomDurations0 .isEmpty()) {
            (encoder).setItemCount(0);
        } else {
            (encoder).setItemCount(mapOfCustomDurations0 .size());
            for (CharSequence key0 : ((Map<CharSequence, CustomDuration> ) mapOfCustomDurations0).keySet()) {
                (encoder).startItem();
                (encoder).writeString(key0);
                Object convertedValue1 = mapOfCustomDurations0 .get(key0);
                convertedValue1 = Conversions.convertToRawType(convertedValue1, this.logicalTypeSchema__43761047, this.logicalTypeSchema__43761047 .getLogicalType(), this.conversion_custom_duration);
                (encoder).writeFixed(((GenericFixed) convertedValue1).bytes());
            }
        }
        (encoder).writeMapEnd();
        Map<CharSequence, CustomDuration> mapOfNullableCustomDurations0 = ((Map<CharSequence, CustomDuration> ) data.get(2));
        (encoder).writeMapStart();
        if ((mapOfNullableCustomDurations0 == null)||mapOfNullableCustomDurations0 .isEmpty()) {
            (encoder).setItemCount(0);
        } else {
            (encoder).setItemCount(mapOfNullableCustomDurations0 .size());
            for (CharSequence key1 : ((Map<CharSequence, CustomDuration> ) mapOfNullableCustomDurations0).keySet()) {
                (encoder).startItem();
                (encoder).writeString(key1);
                CustomDuration union0 = null;
                union0 = ((Map<CharSequence, CustomDuration> ) mapOfNullableCustomDurations0).get(key1);
                if (union0 == null) {
                    (encoder).writeIndex(0);
                    (encoder).writeNull();
                } else {
                    if (union0 instanceof CustomDuration) {
                        (encoder).writeIndex(1);
                        Object convertedValue2 = union0;
                        convertedValue2 = Conversions.convertToRawType(convertedValue2, this.logicalTypeSchema__43761047, this.logicalTypeSchema__43761047 .getLogicalType(), this.conversion_custom_duration);
                        (encoder).writeFixed(((GenericFixed) convertedValue2).bytes());
                    }
                }
            }
        }
        (encoder).writeMapEnd();
        Object convertedValue3 = data.get(3);
        convertedValue3 = Conversions.convertToRawType(convertedValue3, this.logicalTypeSchema__1616559509, this.logicalTypeSchema__1616559509 .getLogicalType(), this.conversion_days_since_2000);
        (encoder).writeInt(((Integer) convertedValue3));
        List<Object> arrayOfUnionOfNullableCustomTypes0 = ((List<Object> ) data.get(4));
        (encoder).writeArrayStart();
        if ((arrayOfUnionOfNullableCustomTypes0 == null)||arrayOfUnionOfNullableCustomTypes0 .isEmpty()) {
            (encoder).setItemCount(0);
        } else {
            (encoder).setItemCount(arrayOfUnionOfNullableCustomTypes0 .size());
            for (int counter0 = 0; (counter0 <arrayOfUnionOfNullableCustomTypes0 .size()); counter0 ++) {
                (encoder).startItem();
                Object union1 = null;
                union1 = ((List<Object> ) arrayOfUnionOfNullableCustomTypes0).get(counter0);
                if (union1 == null) {
                    (encoder).writeIndex(1);
                    (encoder).writeNull();
                } else {
                    if (union1 instanceof CustomDuration) {
                        (encoder).writeIndex(0);
                        Object convertedValue4 = union1;
                        convertedValue4 = Conversions.convertToRawType(convertedValue4, this.logicalTypeSchema__43761047, this.logicalTypeSchema__43761047 .getLogicalType(), this.conversion_custom_duration);
                        (encoder).writeFixed(((GenericFixed) convertedValue4).bytes());
                    } else {
                        if (union1 instanceof DaysSince2000) {
                            (encoder).writeIndex(2);
                            Object convertedValue5 = union1;
                            convertedValue5 = Conversions.convertToRawType(convertedValue5, this.logicalTypeSchema__1616559509, this.logicalTypeSchema__1616559509 .getLogicalType(), this.conversion_days_since_2000);
                            (encoder).writeInt(((Integer) convertedValue5));
                        }
                    }
                }
            }
        }
        (encoder).writeArrayEnd();
    }

}
