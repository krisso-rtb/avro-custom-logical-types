
package com.linkedin.avro.fastserde.generated.deserialization.AVRO_1_11;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.linkedin.avro.fastserde.FastDeserializer;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericArray;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericFixed;
import org.apache.avro.generic.IndexedRecord;
import org.apache.avro.io.Decoder;

public class RecordWithoutCustomLogicalTypes_GenericDeserializer_444096306_444096306
    implements FastDeserializer<IndexedRecord>
{

    private final Schema readerSchema;
    private final GenericData modelData;
    private final Schema customDurationField0;
    private final Schema mapOfCustomDurations0;
    private final Schema mapOfNullableCustomDurations0;
    private final Schema mapOfNullableCustomDurationsMapValueSchema0;
    private final Schema arrayOfUnionOfNullableCustomTypes0;
    private final Schema arrayOfUnionOfNullableCustomTypesArrayElemSchema0;

    public RecordWithoutCustomLogicalTypes_GenericDeserializer_444096306_444096306(Schema readerSchema, GenericData modelData) {
        this.readerSchema = readerSchema;
        this.modelData = modelData;
        this.customDurationField0 = readerSchema.getField("customDurationField").schema();
        this.mapOfCustomDurations0 = readerSchema.getField("mapOfCustomDurations").schema();
        this.mapOfNullableCustomDurations0 = readerSchema.getField("mapOfNullableCustomDurations").schema();
        this.mapOfNullableCustomDurationsMapValueSchema0 = mapOfNullableCustomDurations0 .getValueType();
        this.arrayOfUnionOfNullableCustomTypes0 = readerSchema.getField("arrayOfUnionOfNullableCustomTypes").schema();
        this.arrayOfUnionOfNullableCustomTypesArrayElemSchema0 = arrayOfUnionOfNullableCustomTypes0 .getElementType();
    }

    public IndexedRecord deserialize(IndexedRecord reuse, Decoder decoder)
        throws IOException
    {
        return deserializeRecordWithoutCustomLogicalTypes0((reuse), (decoder));
    }

    public IndexedRecord deserializeRecordWithoutCustomLogicalTypes0(Object reuse, Decoder decoder)
        throws IOException
    {
        IndexedRecord RecordWithoutCustomLogicalTypes;
        if ((((reuse)!= null)&&((reuse) instanceof IndexedRecord))&&(((IndexedRecord)(reuse)).getSchema() == readerSchema)) {
            RecordWithoutCustomLogicalTypes = ((IndexedRecord)(reuse));
        } else {
            RecordWithoutCustomLogicalTypes = new GenericData.Record(readerSchema);
        }
        byte[] twelveBytes0;
        Object oldFixed0 = RecordWithoutCustomLogicalTypes.get(0);
        if ((oldFixed0 instanceof GenericFixed)&&(((GenericFixed) oldFixed0).bytes().length == (12))) {
            twelveBytes0 = ((GenericFixed) oldFixed0).bytes();
        } else {
            twelveBytes0 = ( new byte[12]);
        }
        decoder.readFixed(twelveBytes0);
        RecordWithoutCustomLogicalTypes.put(0, new GenericData.Fixed(customDurationField0, twelveBytes0));
        Map<String, GenericFixed> mapOfCustomDurations1 = null;
        long chunkLen0 = (decoder.readMapStart());
        if (chunkLen0 > 0) {
            Map<String, GenericFixed> mapOfCustomDurationsReuse0 = null;
            Object oldMap0 = RecordWithoutCustomLogicalTypes.get(1);
            if (oldMap0 instanceof Map) {
                mapOfCustomDurationsReuse0 = ((Map) oldMap0);
            }
            if (mapOfCustomDurationsReuse0 != (null)) {
                mapOfCustomDurationsReuse0 .clear();
                mapOfCustomDurations1 = mapOfCustomDurationsReuse0;
            } else {
                mapOfCustomDurations1 = new HashMap<String, GenericFixed>(((int)(((chunkLen0 * 4)+ 2)/ 3)));
            }
            do {
                for (int counter0 = 0; (counter0 <chunkLen0); counter0 ++) {
                    String key0 = (decoder.readString());
                    byte[] twelveBytes1;
                    twelveBytes1 = ( new byte[12]);
                    decoder.readFixed(twelveBytes1);
                    mapOfCustomDurations1 .put(key0, new GenericData.Fixed(customDurationField0, twelveBytes1));
                }
                chunkLen0 = (decoder.mapNext());
            } while (chunkLen0 > 0);
        } else {
            mapOfCustomDurations1 = new HashMap<String, GenericFixed>(0);
        }
        RecordWithoutCustomLogicalTypes.put(1, mapOfCustomDurations1);
        Map<String, GenericFixed> mapOfNullableCustomDurations1 = null;
        long chunkLen1 = (decoder.readMapStart());
        if (chunkLen1 > 0) {
            Map<String, GenericFixed> mapOfNullableCustomDurationsReuse0 = null;
            Object oldMap1 = RecordWithoutCustomLogicalTypes.get(2);
            if (oldMap1 instanceof Map) {
                mapOfNullableCustomDurationsReuse0 = ((Map) oldMap1);
            }
            if (mapOfNullableCustomDurationsReuse0 != (null)) {
                mapOfNullableCustomDurationsReuse0 .clear();
                mapOfNullableCustomDurations1 = mapOfNullableCustomDurationsReuse0;
            } else {
                mapOfNullableCustomDurations1 = new HashMap<String, GenericFixed>(((int)(((chunkLen1 * 4)+ 2)/ 3)));
            }
            do {
                for (int counter1 = 0; (counter1 <chunkLen1); counter1 ++) {
                    String key1 = (decoder.readString());
                    int unionIndex0 = (decoder.readIndex());
                    if (unionIndex0 == 0) {
                        decoder.readNull();
                        mapOfNullableCustomDurations1 .put(key1, null);
                    } else {
                        if (unionIndex0 == 1) {
                            byte[] twelveBytes2;
                            twelveBytes2 = ( new byte[12]);
                            decoder.readFixed(twelveBytes2);
                            mapOfNullableCustomDurations1 .put(key1, new GenericData.Fixed(customDurationField0, twelveBytes2));
                        } else {
                            throw new RuntimeException(("Illegal union index for 'mapOfNullableCustomDurationsValue': "+ unionIndex0));
                        }
                    }
                }
                chunkLen1 = (decoder.mapNext());
            } while (chunkLen1 > 0);
        } else {
            mapOfNullableCustomDurations1 = new HashMap<String, GenericFixed>(0);
        }
        RecordWithoutCustomLogicalTypes.put(2, mapOfNullableCustomDurations1);
        RecordWithoutCustomLogicalTypes.put(3, (decoder.readInt()));
        List<Object> arrayOfUnionOfNullableCustomTypes1 = null;
        long chunkLen2 = (decoder.readArrayStart());
        Object oldArray0 = RecordWithoutCustomLogicalTypes.get(4);
        if (oldArray0 instanceof List) {
            arrayOfUnionOfNullableCustomTypes1 = ((List) oldArray0);
            arrayOfUnionOfNullableCustomTypes1 .clear();
        } else {
            arrayOfUnionOfNullableCustomTypes1 = new GenericData.Array<Object>(((int) chunkLen2), arrayOfUnionOfNullableCustomTypes0);
        }
        while (chunkLen2 > 0) {
            for (int counter2 = 0; (counter2 <chunkLen2); counter2 ++) {
                Object arrayOfUnionOfNullableCustomTypesArrayElementReuseVar0 = null;
                if (oldArray0 instanceof GenericArray) {
                    arrayOfUnionOfNullableCustomTypesArrayElementReuseVar0 = ((GenericArray) oldArray0).peek();
                }
                int unionIndex1 = (decoder.readIndex());
                if (unionIndex1 == 0) {
                    byte[] twelveBytes3;
                    Object oldFixed1 = arrayOfUnionOfNullableCustomTypesArrayElementReuseVar0;
                    if ((oldFixed1 instanceof GenericFixed)&&(((GenericFixed) oldFixed1).bytes().length == (12))) {
                        twelveBytes3 = ((GenericFixed) oldFixed1).bytes();
                    } else {
                        twelveBytes3 = ( new byte[12]);
                    }
                    decoder.readFixed(twelveBytes3);
                    arrayOfUnionOfNullableCustomTypes1 .add(new GenericData.Fixed(customDurationField0, twelveBytes3));
                } else {
                    if (unionIndex1 == 1) {
                        decoder.readNull();
                        arrayOfUnionOfNullableCustomTypes1 .add(null);
                    } else {
                        if (unionIndex1 == 2) {
                            arrayOfUnionOfNullableCustomTypes1 .add((decoder.readInt()));
                        } else {
                            throw new RuntimeException(("Illegal union index for 'arrayOfUnionOfNullableCustomTypesElem': "+ unionIndex1));
                        }
                    }
                }
            }
            chunkLen2 = (decoder.arrayNext());
        }
        RecordWithoutCustomLogicalTypes.put(4, arrayOfUnionOfNullableCustomTypes1);
        return RecordWithoutCustomLogicalTypes;
    }

}
