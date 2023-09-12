
package com.linkedin.avro.fastserde.generated.deserialization.AVRO_1_10;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.linkedin.avro.fastserde.FastDeserializer;
import com.rtbhouse.generated.avro.TwelveBytes;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericArray;
import org.apache.avro.generic.GenericFixed;
import org.apache.avro.io.Decoder;
import org.apache.avro.specific.SpecificData;

public class RecordWithoutCustomLogicalTypes_SpecificDeserializer_444096306_444096306
    implements FastDeserializer<com.rtbhouse.generated.avro.RecordWithoutCustomLogicalTypes>
{

    private final Schema readerSchema;
    private final SpecificData modelData;

    public RecordWithoutCustomLogicalTypes_SpecificDeserializer_444096306_444096306(Schema readerSchema, SpecificData modelData) {
        this.readerSchema = readerSchema;
        this.modelData = modelData;
    }

    public com.rtbhouse.generated.avro.RecordWithoutCustomLogicalTypes deserialize(com.rtbhouse.generated.avro.RecordWithoutCustomLogicalTypes reuse, Decoder decoder)
        throws IOException
    {
        return deserializeRecordWithoutCustomLogicalTypes0((reuse), (decoder));
    }

    public com.rtbhouse.generated.avro.RecordWithoutCustomLogicalTypes deserializeRecordWithoutCustomLogicalTypes0(Object reuse, Decoder decoder)
        throws IOException
    {
        com.rtbhouse.generated.avro.RecordWithoutCustomLogicalTypes RecordWithoutCustomLogicalTypes;
        if ((reuse)!= null) {
            RecordWithoutCustomLogicalTypes = ((com.rtbhouse.generated.avro.RecordWithoutCustomLogicalTypes)(reuse));
        } else {
            RecordWithoutCustomLogicalTypes = new com.rtbhouse.generated.avro.RecordWithoutCustomLogicalTypes();
        }
        byte[] twelveBytes0;
        Object oldFixed0 = RecordWithoutCustomLogicalTypes.get(0);
        if ((oldFixed0 instanceof GenericFixed)&&(((GenericFixed) oldFixed0).bytes().length == (12))) {
            twelveBytes0 = ((GenericFixed) oldFixed0).bytes();
        } else {
            twelveBytes0 = ( new byte[12]);
        }
        decoder.readFixed(twelveBytes0);
        TwelveBytes twelveBytes1 = new TwelveBytes();
        twelveBytes1.bytes(twelveBytes0);
        RecordWithoutCustomLogicalTypes.put(0, twelveBytes1);
        Map<String, GenericFixed> mapOfCustomDurations0 = null;
        long chunkLen0 = (decoder.readMapStart());
        if (chunkLen0 > 0) {
            Map<String, GenericFixed> mapOfCustomDurationsReuse0 = null;
            Object oldMap0 = RecordWithoutCustomLogicalTypes.get(1);
            if (oldMap0 instanceof Map) {
                mapOfCustomDurationsReuse0 = ((Map) oldMap0);
            }
            if (mapOfCustomDurationsReuse0 != (null)) {
                mapOfCustomDurationsReuse0 .clear();
                mapOfCustomDurations0 = mapOfCustomDurationsReuse0;
            } else {
                mapOfCustomDurations0 = new HashMap<String, GenericFixed>(((int)(((chunkLen0 * 4)+ 2)/ 3)));
            }
            do {
                for (int counter0 = 0; (counter0 <chunkLen0); counter0 ++) {
                    String key0 = (decoder.readString());
                    byte[] twelveBytes2;
                    twelveBytes2 = ( new byte[12]);
                    decoder.readFixed(twelveBytes2);
                    TwelveBytes twelveBytes3 = new TwelveBytes();
                    twelveBytes3.bytes(twelveBytes2);
                    mapOfCustomDurations0 .put(key0, twelveBytes3);
                }
                chunkLen0 = (decoder.mapNext());
            } while (chunkLen0 > 0);
        } else {
            mapOfCustomDurations0 = new HashMap<String, GenericFixed>(0);
        }
        RecordWithoutCustomLogicalTypes.put(1, mapOfCustomDurations0);
        Map<String, GenericFixed> mapOfNullableCustomDurations0 = null;
        long chunkLen1 = (decoder.readMapStart());
        if (chunkLen1 > 0) {
            Map<String, GenericFixed> mapOfNullableCustomDurationsReuse0 = null;
            Object oldMap1 = RecordWithoutCustomLogicalTypes.get(2);
            if (oldMap1 instanceof Map) {
                mapOfNullableCustomDurationsReuse0 = ((Map) oldMap1);
            }
            if (mapOfNullableCustomDurationsReuse0 != (null)) {
                mapOfNullableCustomDurationsReuse0 .clear();
                mapOfNullableCustomDurations0 = mapOfNullableCustomDurationsReuse0;
            } else {
                mapOfNullableCustomDurations0 = new HashMap<String, GenericFixed>(((int)(((chunkLen1 * 4)+ 2)/ 3)));
            }
            do {
                for (int counter1 = 0; (counter1 <chunkLen1); counter1 ++) {
                    String key1 = (decoder.readString());
                    int unionIndex0 = (decoder.readIndex());
                    if (unionIndex0 == 0) {
                        decoder.readNull();
                        mapOfNullableCustomDurations0 .put(key1, null);
                    } else {
                        if (unionIndex0 == 1) {
                            byte[] twelveBytes4;
                            twelveBytes4 = ( new byte[12]);
                            decoder.readFixed(twelveBytes4);
                            TwelveBytes twelveBytes5 = new TwelveBytes();
                            twelveBytes5.bytes(twelveBytes4);
                            mapOfNullableCustomDurations0 .put(key1, twelveBytes5);
                        } else {
                            throw new RuntimeException(("Illegal union index for 'mapOfNullableCustomDurationsValue': "+ unionIndex0));
                        }
                    }
                }
                chunkLen1 = (decoder.mapNext());
            } while (chunkLen1 > 0);
        } else {
            mapOfNullableCustomDurations0 = new HashMap<String, GenericFixed>(0);
        }
        RecordWithoutCustomLogicalTypes.put(2, mapOfNullableCustomDurations0);
        RecordWithoutCustomLogicalTypes.put(3, (decoder.readInt()));
        List<Object> arrayOfUnionOfNullableCustomTypes0 = null;
        long chunkLen2 = (decoder.readArrayStart());
        Object oldArray0 = RecordWithoutCustomLogicalTypes.get(4);
        if (oldArray0 instanceof List) {
            arrayOfUnionOfNullableCustomTypes0 = ((List) oldArray0);
            arrayOfUnionOfNullableCustomTypes0 .clear();
        } else {
            arrayOfUnionOfNullableCustomTypes0 = new ArrayList<Object>(((int) chunkLen2));
        }
        while (chunkLen2 > 0) {
            for (int counter2 = 0; (counter2 <chunkLen2); counter2 ++) {
                Object arrayOfUnionOfNullableCustomTypesArrayElementReuseVar0 = null;
                if (oldArray0 instanceof GenericArray) {
                    arrayOfUnionOfNullableCustomTypesArrayElementReuseVar0 = ((GenericArray) oldArray0).peek();
                }
                int unionIndex1 = (decoder.readIndex());
                if (unionIndex1 == 0) {
                    byte[] twelveBytes6;
                    Object oldFixed1 = arrayOfUnionOfNullableCustomTypesArrayElementReuseVar0;
                    if ((oldFixed1 instanceof GenericFixed)&&(((GenericFixed) oldFixed1).bytes().length == (12))) {
                        twelveBytes6 = ((GenericFixed) oldFixed1).bytes();
                    } else {
                        twelveBytes6 = ( new byte[12]);
                    }
                    decoder.readFixed(twelveBytes6);
                    TwelveBytes twelveBytes7 = new TwelveBytes();
                    twelveBytes7.bytes(twelveBytes6);
                    arrayOfUnionOfNullableCustomTypes0 .add(twelveBytes7);
                } else {
                    if (unionIndex1 == 1) {
                        decoder.readNull();
                        arrayOfUnionOfNullableCustomTypes0 .add(null);
                    } else {
                        if (unionIndex1 == 2) {
                            arrayOfUnionOfNullableCustomTypes0 .add((decoder.readInt()));
                        } else {
                            throw new RuntimeException(("Illegal union index for 'arrayOfUnionOfNullableCustomTypesElem': "+ unionIndex1));
                        }
                    }
                }
            }
            chunkLen2 = (decoder.arrayNext());
        }
        RecordWithoutCustomLogicalTypes.put(4, arrayOfUnionOfNullableCustomTypes0);
        return RecordWithoutCustomLogicalTypes;
    }

}
