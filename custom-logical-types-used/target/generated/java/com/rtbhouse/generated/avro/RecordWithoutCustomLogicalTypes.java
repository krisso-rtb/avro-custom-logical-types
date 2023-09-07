/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.rtbhouse.generated.avro;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

/** Used to confirm equality of corresponding serialized bytes */
@org.apache.avro.specific.AvroGenerated
public class RecordWithoutCustomLogicalTypes extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -846573718191963520L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"RecordWithoutCustomLogicalTypes\",\"namespace\":\"com.rtbhouse.generated.avro\",\"doc\":\"Used to confirm equality of corresponding serialized bytes\",\"fields\":[{\"name\":\"customDurationField\",\"type\":{\"type\":\"fixed\",\"name\":\"TwelveBytes\",\"size\":12}},{\"name\":\"mapOfCustomDurations\",\"type\":{\"type\":\"map\",\"values\":\"TwelveBytes\",\"avro.java.string\":\"String\"}},{\"name\":\"mapOfNullableCustomDurations\",\"type\":{\"type\":\"map\",\"values\":[\"null\",\"TwelveBytes\"],\"avro.java.string\":\"String\"}},{\"name\":\"daysSince2000Field\",\"type\":\"int\"},{\"name\":\"arrayOfUnionOfNullableCustomTypes\",\"type\":{\"type\":\"array\",\"items\":[\"TwelveBytes\",\"null\",\"int\"]}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<RecordWithoutCustomLogicalTypes> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<RecordWithoutCustomLogicalTypes> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<RecordWithoutCustomLogicalTypes> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<RecordWithoutCustomLogicalTypes> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<RecordWithoutCustomLogicalTypes> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this RecordWithoutCustomLogicalTypes to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a RecordWithoutCustomLogicalTypes from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a RecordWithoutCustomLogicalTypes instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static RecordWithoutCustomLogicalTypes fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private com.rtbhouse.generated.avro.TwelveBytes customDurationField;
  private java.util.Map<java.lang.String,com.rtbhouse.generated.avro.TwelveBytes> mapOfCustomDurations;
  private java.util.Map<java.lang.String,com.rtbhouse.generated.avro.TwelveBytes> mapOfNullableCustomDurations;
  private int daysSince2000Field;
  private java.util.List<java.lang.Object> arrayOfUnionOfNullableCustomTypes;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public RecordWithoutCustomLogicalTypes() {}

  /**
   * All-args constructor.
   * @param customDurationField The new value for customDurationField
   * @param mapOfCustomDurations The new value for mapOfCustomDurations
   * @param mapOfNullableCustomDurations The new value for mapOfNullableCustomDurations
   * @param daysSince2000Field The new value for daysSince2000Field
   * @param arrayOfUnionOfNullableCustomTypes The new value for arrayOfUnionOfNullableCustomTypes
   */
  public RecordWithoutCustomLogicalTypes(com.rtbhouse.generated.avro.TwelveBytes customDurationField, java.util.Map<java.lang.String,com.rtbhouse.generated.avro.TwelveBytes> mapOfCustomDurations, java.util.Map<java.lang.String,com.rtbhouse.generated.avro.TwelveBytes> mapOfNullableCustomDurations, java.lang.Integer daysSince2000Field, java.util.List<java.lang.Object> arrayOfUnionOfNullableCustomTypes) {
    this.customDurationField = customDurationField;
    this.mapOfCustomDurations = mapOfCustomDurations;
    this.mapOfNullableCustomDurations = mapOfNullableCustomDurations;
    this.daysSince2000Field = daysSince2000Field;
    this.arrayOfUnionOfNullableCustomTypes = arrayOfUnionOfNullableCustomTypes;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return customDurationField;
    case 1: return mapOfCustomDurations;
    case 2: return mapOfNullableCustomDurations;
    case 3: return daysSince2000Field;
    case 4: return arrayOfUnionOfNullableCustomTypes;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: customDurationField = (com.rtbhouse.generated.avro.TwelveBytes)value$; break;
    case 1: mapOfCustomDurations = (java.util.Map<java.lang.String,com.rtbhouse.generated.avro.TwelveBytes>)value$; break;
    case 2: mapOfNullableCustomDurations = (java.util.Map<java.lang.String,com.rtbhouse.generated.avro.TwelveBytes>)value$; break;
    case 3: daysSince2000Field = (java.lang.Integer)value$; break;
    case 4: arrayOfUnionOfNullableCustomTypes = (java.util.List<java.lang.Object>)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'customDurationField' field.
   * @return The value of the 'customDurationField' field.
   */
  public com.rtbhouse.generated.avro.TwelveBytes getCustomDurationField() {
    return customDurationField;
  }


  /**
   * Sets the value of the 'customDurationField' field.
   * @param value the value to set.
   */
  public void setCustomDurationField(com.rtbhouse.generated.avro.TwelveBytes value) {
    this.customDurationField = value;
  }

  /**
   * Gets the value of the 'mapOfCustomDurations' field.
   * @return The value of the 'mapOfCustomDurations' field.
   */
  public java.util.Map<java.lang.String,com.rtbhouse.generated.avro.TwelveBytes> getMapOfCustomDurations() {
    return mapOfCustomDurations;
  }


  /**
   * Sets the value of the 'mapOfCustomDurations' field.
   * @param value the value to set.
   */
  public void setMapOfCustomDurations(java.util.Map<java.lang.String,com.rtbhouse.generated.avro.TwelveBytes> value) {
    this.mapOfCustomDurations = value;
  }

  /**
   * Gets the value of the 'mapOfNullableCustomDurations' field.
   * @return The value of the 'mapOfNullableCustomDurations' field.
   */
  public java.util.Map<java.lang.String,com.rtbhouse.generated.avro.TwelveBytes> getMapOfNullableCustomDurations() {
    return mapOfNullableCustomDurations;
  }


  /**
   * Sets the value of the 'mapOfNullableCustomDurations' field.
   * @param value the value to set.
   */
  public void setMapOfNullableCustomDurations(java.util.Map<java.lang.String,com.rtbhouse.generated.avro.TwelveBytes> value) {
    this.mapOfNullableCustomDurations = value;
  }

  /**
   * Gets the value of the 'daysSince2000Field' field.
   * @return The value of the 'daysSince2000Field' field.
   */
  public int getDaysSince2000Field() {
    return daysSince2000Field;
  }


  /**
   * Sets the value of the 'daysSince2000Field' field.
   * @param value the value to set.
   */
  public void setDaysSince2000Field(int value) {
    this.daysSince2000Field = value;
  }

  /**
   * Gets the value of the 'arrayOfUnionOfNullableCustomTypes' field.
   * @return The value of the 'arrayOfUnionOfNullableCustomTypes' field.
   */
  public java.util.List<java.lang.Object> getArrayOfUnionOfNullableCustomTypes() {
    return arrayOfUnionOfNullableCustomTypes;
  }


  /**
   * Sets the value of the 'arrayOfUnionOfNullableCustomTypes' field.
   * @param value the value to set.
   */
  public void setArrayOfUnionOfNullableCustomTypes(java.util.List<java.lang.Object> value) {
    this.arrayOfUnionOfNullableCustomTypes = value;
  }

  /**
   * Creates a new RecordWithoutCustomLogicalTypes RecordBuilder.
   * @return A new RecordWithoutCustomLogicalTypes RecordBuilder
   */
  public static com.rtbhouse.generated.avro.RecordWithoutCustomLogicalTypes.Builder newBuilder() {
    return new com.rtbhouse.generated.avro.RecordWithoutCustomLogicalTypes.Builder();
  }

  /**
   * Creates a new RecordWithoutCustomLogicalTypes RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new RecordWithoutCustomLogicalTypes RecordBuilder
   */
  public static com.rtbhouse.generated.avro.RecordWithoutCustomLogicalTypes.Builder newBuilder(com.rtbhouse.generated.avro.RecordWithoutCustomLogicalTypes.Builder other) {
    if (other == null) {
      return new com.rtbhouse.generated.avro.RecordWithoutCustomLogicalTypes.Builder();
    } else {
      return new com.rtbhouse.generated.avro.RecordWithoutCustomLogicalTypes.Builder(other);
    }
  }

  /**
   * Creates a new RecordWithoutCustomLogicalTypes RecordBuilder by copying an existing RecordWithoutCustomLogicalTypes instance.
   * @param other The existing instance to copy.
   * @return A new RecordWithoutCustomLogicalTypes RecordBuilder
   */
  public static com.rtbhouse.generated.avro.RecordWithoutCustomLogicalTypes.Builder newBuilder(com.rtbhouse.generated.avro.RecordWithoutCustomLogicalTypes other) {
    if (other == null) {
      return new com.rtbhouse.generated.avro.RecordWithoutCustomLogicalTypes.Builder();
    } else {
      return new com.rtbhouse.generated.avro.RecordWithoutCustomLogicalTypes.Builder(other);
    }
  }

  /**
   * RecordBuilder for RecordWithoutCustomLogicalTypes instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<RecordWithoutCustomLogicalTypes>
    implements org.apache.avro.data.RecordBuilder<RecordWithoutCustomLogicalTypes> {

    private com.rtbhouse.generated.avro.TwelveBytes customDurationField;
    private java.util.Map<java.lang.String,com.rtbhouse.generated.avro.TwelveBytes> mapOfCustomDurations;
    private java.util.Map<java.lang.String,com.rtbhouse.generated.avro.TwelveBytes> mapOfNullableCustomDurations;
    private int daysSince2000Field;
    private java.util.List<java.lang.Object> arrayOfUnionOfNullableCustomTypes;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.rtbhouse.generated.avro.RecordWithoutCustomLogicalTypes.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.customDurationField)) {
        this.customDurationField = data().deepCopy(fields()[0].schema(), other.customDurationField);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.mapOfCustomDurations)) {
        this.mapOfCustomDurations = data().deepCopy(fields()[1].schema(), other.mapOfCustomDurations);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.mapOfNullableCustomDurations)) {
        this.mapOfNullableCustomDurations = data().deepCopy(fields()[2].schema(), other.mapOfNullableCustomDurations);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.daysSince2000Field)) {
        this.daysSince2000Field = data().deepCopy(fields()[3].schema(), other.daysSince2000Field);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.arrayOfUnionOfNullableCustomTypes)) {
        this.arrayOfUnionOfNullableCustomTypes = data().deepCopy(fields()[4].schema(), other.arrayOfUnionOfNullableCustomTypes);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
    }

    /**
     * Creates a Builder by copying an existing RecordWithoutCustomLogicalTypes instance
     * @param other The existing instance to copy.
     */
    private Builder(com.rtbhouse.generated.avro.RecordWithoutCustomLogicalTypes other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.customDurationField)) {
        this.customDurationField = data().deepCopy(fields()[0].schema(), other.customDurationField);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.mapOfCustomDurations)) {
        this.mapOfCustomDurations = data().deepCopy(fields()[1].schema(), other.mapOfCustomDurations);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.mapOfNullableCustomDurations)) {
        this.mapOfNullableCustomDurations = data().deepCopy(fields()[2].schema(), other.mapOfNullableCustomDurations);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.daysSince2000Field)) {
        this.daysSince2000Field = data().deepCopy(fields()[3].schema(), other.daysSince2000Field);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.arrayOfUnionOfNullableCustomTypes)) {
        this.arrayOfUnionOfNullableCustomTypes = data().deepCopy(fields()[4].schema(), other.arrayOfUnionOfNullableCustomTypes);
        fieldSetFlags()[4] = true;
      }
    }

    /**
      * Gets the value of the 'customDurationField' field.
      * @return The value.
      */
    public com.rtbhouse.generated.avro.TwelveBytes getCustomDurationField() {
      return customDurationField;
    }


    /**
      * Sets the value of the 'customDurationField' field.
      * @param value The value of 'customDurationField'.
      * @return This builder.
      */
    public com.rtbhouse.generated.avro.RecordWithoutCustomLogicalTypes.Builder setCustomDurationField(com.rtbhouse.generated.avro.TwelveBytes value) {
      validate(fields()[0], value);
      this.customDurationField = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'customDurationField' field has been set.
      * @return True if the 'customDurationField' field has been set, false otherwise.
      */
    public boolean hasCustomDurationField() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'customDurationField' field.
      * @return This builder.
      */
    public com.rtbhouse.generated.avro.RecordWithoutCustomLogicalTypes.Builder clearCustomDurationField() {
      customDurationField = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'mapOfCustomDurations' field.
      * @return The value.
      */
    public java.util.Map<java.lang.String,com.rtbhouse.generated.avro.TwelveBytes> getMapOfCustomDurations() {
      return mapOfCustomDurations;
    }


    /**
      * Sets the value of the 'mapOfCustomDurations' field.
      * @param value The value of 'mapOfCustomDurations'.
      * @return This builder.
      */
    public com.rtbhouse.generated.avro.RecordWithoutCustomLogicalTypes.Builder setMapOfCustomDurations(java.util.Map<java.lang.String,com.rtbhouse.generated.avro.TwelveBytes> value) {
      validate(fields()[1], value);
      this.mapOfCustomDurations = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'mapOfCustomDurations' field has been set.
      * @return True if the 'mapOfCustomDurations' field has been set, false otherwise.
      */
    public boolean hasMapOfCustomDurations() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'mapOfCustomDurations' field.
      * @return This builder.
      */
    public com.rtbhouse.generated.avro.RecordWithoutCustomLogicalTypes.Builder clearMapOfCustomDurations() {
      mapOfCustomDurations = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'mapOfNullableCustomDurations' field.
      * @return The value.
      */
    public java.util.Map<java.lang.String,com.rtbhouse.generated.avro.TwelveBytes> getMapOfNullableCustomDurations() {
      return mapOfNullableCustomDurations;
    }


    /**
      * Sets the value of the 'mapOfNullableCustomDurations' field.
      * @param value The value of 'mapOfNullableCustomDurations'.
      * @return This builder.
      */
    public com.rtbhouse.generated.avro.RecordWithoutCustomLogicalTypes.Builder setMapOfNullableCustomDurations(java.util.Map<java.lang.String,com.rtbhouse.generated.avro.TwelveBytes> value) {
      validate(fields()[2], value);
      this.mapOfNullableCustomDurations = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'mapOfNullableCustomDurations' field has been set.
      * @return True if the 'mapOfNullableCustomDurations' field has been set, false otherwise.
      */
    public boolean hasMapOfNullableCustomDurations() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'mapOfNullableCustomDurations' field.
      * @return This builder.
      */
    public com.rtbhouse.generated.avro.RecordWithoutCustomLogicalTypes.Builder clearMapOfNullableCustomDurations() {
      mapOfNullableCustomDurations = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'daysSince2000Field' field.
      * @return The value.
      */
    public int getDaysSince2000Field() {
      return daysSince2000Field;
    }


    /**
      * Sets the value of the 'daysSince2000Field' field.
      * @param value The value of 'daysSince2000Field'.
      * @return This builder.
      */
    public com.rtbhouse.generated.avro.RecordWithoutCustomLogicalTypes.Builder setDaysSince2000Field(int value) {
      validate(fields()[3], value);
      this.daysSince2000Field = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'daysSince2000Field' field has been set.
      * @return True if the 'daysSince2000Field' field has been set, false otherwise.
      */
    public boolean hasDaysSince2000Field() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'daysSince2000Field' field.
      * @return This builder.
      */
    public com.rtbhouse.generated.avro.RecordWithoutCustomLogicalTypes.Builder clearDaysSince2000Field() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'arrayOfUnionOfNullableCustomTypes' field.
      * @return The value.
      */
    public java.util.List<java.lang.Object> getArrayOfUnionOfNullableCustomTypes() {
      return arrayOfUnionOfNullableCustomTypes;
    }


    /**
      * Sets the value of the 'arrayOfUnionOfNullableCustomTypes' field.
      * @param value The value of 'arrayOfUnionOfNullableCustomTypes'.
      * @return This builder.
      */
    public com.rtbhouse.generated.avro.RecordWithoutCustomLogicalTypes.Builder setArrayOfUnionOfNullableCustomTypes(java.util.List<java.lang.Object> value) {
      validate(fields()[4], value);
      this.arrayOfUnionOfNullableCustomTypes = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'arrayOfUnionOfNullableCustomTypes' field has been set.
      * @return True if the 'arrayOfUnionOfNullableCustomTypes' field has been set, false otherwise.
      */
    public boolean hasArrayOfUnionOfNullableCustomTypes() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'arrayOfUnionOfNullableCustomTypes' field.
      * @return This builder.
      */
    public com.rtbhouse.generated.avro.RecordWithoutCustomLogicalTypes.Builder clearArrayOfUnionOfNullableCustomTypes() {
      arrayOfUnionOfNullableCustomTypes = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public RecordWithoutCustomLogicalTypes build() {
      try {
        RecordWithoutCustomLogicalTypes record = new RecordWithoutCustomLogicalTypes();
        record.customDurationField = fieldSetFlags()[0] ? this.customDurationField : (com.rtbhouse.generated.avro.TwelveBytes) defaultValue(fields()[0]);
        record.mapOfCustomDurations = fieldSetFlags()[1] ? this.mapOfCustomDurations : (java.util.Map<java.lang.String,com.rtbhouse.generated.avro.TwelveBytes>) defaultValue(fields()[1]);
        record.mapOfNullableCustomDurations = fieldSetFlags()[2] ? this.mapOfNullableCustomDurations : (java.util.Map<java.lang.String,com.rtbhouse.generated.avro.TwelveBytes>) defaultValue(fields()[2]);
        record.daysSince2000Field = fieldSetFlags()[3] ? this.daysSince2000Field : (java.lang.Integer) defaultValue(fields()[3]);
        record.arrayOfUnionOfNullableCustomTypes = fieldSetFlags()[4] ? this.arrayOfUnionOfNullableCustomTypes : (java.util.List<java.lang.Object>) defaultValue(fields()[4]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<RecordWithoutCustomLogicalTypes>
    WRITER$ = (org.apache.avro.io.DatumWriter<RecordWithoutCustomLogicalTypes>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<RecordWithoutCustomLogicalTypes>
    READER$ = (org.apache.avro.io.DatumReader<RecordWithoutCustomLogicalTypes>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}









