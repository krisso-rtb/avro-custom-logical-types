
package com.linkedin.avro.fastserde.generated.serialization.AVRO_1_10;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import com.linkedin.avro.fastserde.FastSerializer;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericFixed;
import org.apache.avro.generic.IndexedRecord;
import org.apache.avro.io.Encoder;

public class RecordWithoutCustomLogicalTypes_GenericSerializer_444096306
    implements FastSerializer<IndexedRecord>
{

    private final GenericData modelData;

    public RecordWithoutCustomLogicalTypes_GenericSerializer_444096306(GenericData modelData) {
        this.modelData = modelData;
    }

    public void serialize(IndexedRecord data, Encoder encoder)
        throws IOException
    {
        serializeRecordWithoutCustomLogicalTypes0(data, (encoder));
    }

    @SuppressWarnings("unchecked")
    public void serializeRecordWithoutCustomLogicalTypes0(IndexedRecord data, Encoder encoder)
        throws IOException
    {
        (encoder).writeFixed(((GenericFixed) data.get(0)).bytes());
        Map<CharSequence, GenericFixed> mapOfCustomDurations0 = ((Map<CharSequence, GenericFixed> ) data.get(1));
        (encoder).writeMapStart();
        if ((mapOfCustomDurations0 == null)||mapOfCustomDurations0 .isEmpty()) {
            (encoder).setItemCount(0);
        } else {
            (encoder).setItemCount(mapOfCustomDurations0 .size());
            for (CharSequence key0 : ((Map<CharSequence, GenericFixed> ) mapOfCustomDurations0).keySet()) {
                (encoder).startItem();
                (encoder).writeString(key0);
                (encoder).writeFixed(((GenericFixed) mapOfCustomDurations0 .get(key0)).bytes());
            }
        }
        (encoder).writeMapEnd();
        Map<CharSequence, GenericFixed> mapOfNullableCustomDurations0 = ((Map<CharSequence, GenericFixed> ) data.get(2));
        (encoder).writeMapStart();
        if ((mapOfNullableCustomDurations0 == null)||mapOfNullableCustomDurations0 .isEmpty()) {
            (encoder).setItemCount(0);
        } else {
            (encoder).setItemCount(mapOfNullableCustomDurations0 .size());
            for (CharSequence key1 : ((Map<CharSequence, GenericFixed> ) mapOfNullableCustomDurations0).keySet()) {
                (encoder).startItem();
                (encoder).writeString(key1);
                GenericFixed union0 = null;
                union0 = ((Map<CharSequence, GenericFixed> ) mapOfNullableCustomDurations0).get(key1);
                if (union0 == null) {
                    (encoder).writeIndex(0);
                    (encoder).writeNull();
                } else {
                    if ((union0 instanceof GenericFixed)&&"com.rtbhouse.generated.avro.TwelveBytes".equals(((GenericFixed) union0).getSchema().getFullName())) {
                        (encoder).writeIndex(1);
                        (encoder).writeFixed(((GenericFixed) union0).bytes());
                    }
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
                    if ((union1 instanceof GenericFixed)&&"com.rtbhouse.generated.avro.TwelveBytes".equals(((GenericFixed) union1).getSchema().getFullName())) {
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
