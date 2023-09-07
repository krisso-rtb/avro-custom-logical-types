
package com.linkedin.avro.fastserde.generated.serialization.AVRO_1_11;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import com.linkedin.avro.fastserde.FastSerializer;
import com.rtbhouse.generated.avro.RecordWithoutCustomLogicalTypes;
import org.apache.avro.generic.GenericFixed;
import org.apache.avro.io.Encoder;
import org.apache.avro.specific.SpecificData;

public class RecordWithoutCustomLogicalTypes_SpecificSerializer_444096306
    implements FastSerializer<RecordWithoutCustomLogicalTypes>
{

    private final SpecificData modelData;

    public RecordWithoutCustomLogicalTypes_SpecificSerializer_444096306(SpecificData modelData) {
        this.modelData = modelData;
    }

    public void serialize(RecordWithoutCustomLogicalTypes data, Encoder encoder)
        throws IOException
    {
        serializeRecordWithoutCustomLogicalTypes0(data, (encoder));
    }

    @SuppressWarnings("unchecked")
    public void serializeRecordWithoutCustomLogicalTypes0(RecordWithoutCustomLogicalTypes data, Encoder encoder)
        throws IOException
    {
        (encoder).writeFixed(((GenericFixed) data.get(0)).bytes());
        Map<String, GenericFixed> mapOfCustomDurations0 = ((Map<String, GenericFixed> ) data.get(1));
        (encoder).writeMapStart();
        if ((mapOfCustomDurations0 == null)||mapOfCustomDurations0 .isEmpty()) {
            (encoder).setItemCount(0);
        } else {
            (encoder).setItemCount(mapOfCustomDurations0 .size());
            for (String key0 : ((Map<String, GenericFixed> ) mapOfCustomDurations0).keySet()) {
                (encoder).startItem();
                (encoder).writeString(key0);
                (encoder).writeFixed(((GenericFixed) mapOfCustomDurations0 .get(key0)).bytes());
            }
        }
        (encoder).writeMapEnd();
        Map<String, GenericFixed> mapOfNullableCustomDurations0 = ((Map<String, GenericFixed> ) data.get(2));
        (encoder).writeMapStart();
        if ((mapOfNullableCustomDurations0 == null)||mapOfNullableCustomDurations0 .isEmpty()) {
            (encoder).setItemCount(0);
        } else {
            (encoder).setItemCount(mapOfNullableCustomDurations0 .size());
            for (String key1 : ((Map<String, GenericFixed> ) mapOfNullableCustomDurations0).keySet()) {
                (encoder).startItem();
                (encoder).writeString(key1);
                GenericFixed union0 = null;
                union0 = ((Map<String, GenericFixed> ) mapOfNullableCustomDurations0).get(key1);
                if (union0 == null) {
                    (encoder).writeIndex(0);
                    (encoder).writeNull();
                } else {
                    (encoder).writeIndex(1);
                    (encoder).writeFixed(((GenericFixed) union0).bytes());
                }
            }
        }
        (encoder).writeMapEnd();
        (encoder).writeInt(((Integer) data.get(3)));
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
                    if (union1 instanceof GenericFixed) {
                        (encoder).writeIndex(0);
                        (encoder).writeFixed(((GenericFixed) union1).bytes());
                    } else {
                        if (union1 instanceof Integer) {
                            (encoder).writeIndex(2);
                            (encoder).writeInt(((Integer) union1));
                        }
                    }
                }
            }
        }
        (encoder).writeArrayEnd();
    }

}
