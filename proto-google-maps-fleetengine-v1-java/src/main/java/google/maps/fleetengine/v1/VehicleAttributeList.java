/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/maps/fleetengine/v1/vehicle_api.proto

package google.maps.fleetengine.v1;

/**
 * <pre>
 * This messages allows a list-of-list datatype for VehicleAttribute.
 * </pre>
 *
 * Protobuf type {@code maps.fleetengine.v1.VehicleAttributeList}
 */
public final class VehicleAttributeList extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:maps.fleetengine.v1.VehicleAttributeList)
    VehicleAttributeListOrBuilder {
private static final long serialVersionUID = 0L;
  // Use VehicleAttributeList.newBuilder() to construct.
  private VehicleAttributeList(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private VehicleAttributeList() {
    attributes_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new VehicleAttributeList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private VehicleAttributeList(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              attributes_ = new java.util.ArrayList<google.maps.fleetengine.v1.VehicleAttribute>();
              mutable_bitField0_ |= 0x00000001;
            }
            attributes_.add(
                input.readMessage(google.maps.fleetengine.v1.VehicleAttribute.parser(), extensionRegistry));
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        attributes_ = java.util.Collections.unmodifiableList(attributes_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return google.maps.fleetengine.v1.VehicleApi.internal_static_maps_fleetengine_v1_VehicleAttributeList_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return google.maps.fleetengine.v1.VehicleApi.internal_static_maps_fleetengine_v1_VehicleAttributeList_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            google.maps.fleetengine.v1.VehicleAttributeList.class, google.maps.fleetengine.v1.VehicleAttributeList.Builder.class);
  }

  public static final int ATTRIBUTES_FIELD_NUMBER = 1;
  private java.util.List<google.maps.fleetengine.v1.VehicleAttribute> attributes_;
  /**
   * <pre>
   * A list of attributes in this collection.
   * </pre>
   *
   * <code>repeated .maps.fleetengine.v1.VehicleAttribute attributes = 1;</code>
   */
  @java.lang.Override
  public java.util.List<google.maps.fleetengine.v1.VehicleAttribute> getAttributesList() {
    return attributes_;
  }
  /**
   * <pre>
   * A list of attributes in this collection.
   * </pre>
   *
   * <code>repeated .maps.fleetengine.v1.VehicleAttribute attributes = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends google.maps.fleetengine.v1.VehicleAttributeOrBuilder> 
      getAttributesOrBuilderList() {
    return attributes_;
  }
  /**
   * <pre>
   * A list of attributes in this collection.
   * </pre>
   *
   * <code>repeated .maps.fleetengine.v1.VehicleAttribute attributes = 1;</code>
   */
  @java.lang.Override
  public int getAttributesCount() {
    return attributes_.size();
  }
  /**
   * <pre>
   * A list of attributes in this collection.
   * </pre>
   *
   * <code>repeated .maps.fleetengine.v1.VehicleAttribute attributes = 1;</code>
   */
  @java.lang.Override
  public google.maps.fleetengine.v1.VehicleAttribute getAttributes(int index) {
    return attributes_.get(index);
  }
  /**
   * <pre>
   * A list of attributes in this collection.
   * </pre>
   *
   * <code>repeated .maps.fleetengine.v1.VehicleAttribute attributes = 1;</code>
   */
  @java.lang.Override
  public google.maps.fleetengine.v1.VehicleAttributeOrBuilder getAttributesOrBuilder(
      int index) {
    return attributes_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < attributes_.size(); i++) {
      output.writeMessage(1, attributes_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < attributes_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, attributes_.get(i));
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof google.maps.fleetengine.v1.VehicleAttributeList)) {
      return super.equals(obj);
    }
    google.maps.fleetengine.v1.VehicleAttributeList other = (google.maps.fleetengine.v1.VehicleAttributeList) obj;

    if (!getAttributesList()
        .equals(other.getAttributesList())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getAttributesCount() > 0) {
      hash = (37 * hash) + ATTRIBUTES_FIELD_NUMBER;
      hash = (53 * hash) + getAttributesList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static google.maps.fleetengine.v1.VehicleAttributeList parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static google.maps.fleetengine.v1.VehicleAttributeList parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static google.maps.fleetengine.v1.VehicleAttributeList parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static google.maps.fleetengine.v1.VehicleAttributeList parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static google.maps.fleetengine.v1.VehicleAttributeList parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static google.maps.fleetengine.v1.VehicleAttributeList parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static google.maps.fleetengine.v1.VehicleAttributeList parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static google.maps.fleetengine.v1.VehicleAttributeList parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static google.maps.fleetengine.v1.VehicleAttributeList parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static google.maps.fleetengine.v1.VehicleAttributeList parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static google.maps.fleetengine.v1.VehicleAttributeList parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static google.maps.fleetengine.v1.VehicleAttributeList parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(google.maps.fleetengine.v1.VehicleAttributeList prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * This messages allows a list-of-list datatype for VehicleAttribute.
   * </pre>
   *
   * Protobuf type {@code maps.fleetengine.v1.VehicleAttributeList}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:maps.fleetengine.v1.VehicleAttributeList)
      google.maps.fleetengine.v1.VehicleAttributeListOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return google.maps.fleetengine.v1.VehicleApi.internal_static_maps_fleetengine_v1_VehicleAttributeList_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return google.maps.fleetengine.v1.VehicleApi.internal_static_maps_fleetengine_v1_VehicleAttributeList_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              google.maps.fleetengine.v1.VehicleAttributeList.class, google.maps.fleetengine.v1.VehicleAttributeList.Builder.class);
    }

    // Construct using google.maps.fleetengine.v1.VehicleAttributeList.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getAttributesFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (attributesBuilder_ == null) {
        attributes_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        attributesBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return google.maps.fleetengine.v1.VehicleApi.internal_static_maps_fleetengine_v1_VehicleAttributeList_descriptor;
    }

    @java.lang.Override
    public google.maps.fleetengine.v1.VehicleAttributeList getDefaultInstanceForType() {
      return google.maps.fleetengine.v1.VehicleAttributeList.getDefaultInstance();
    }

    @java.lang.Override
    public google.maps.fleetengine.v1.VehicleAttributeList build() {
      google.maps.fleetengine.v1.VehicleAttributeList result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public google.maps.fleetengine.v1.VehicleAttributeList buildPartial() {
      google.maps.fleetengine.v1.VehicleAttributeList result = new google.maps.fleetengine.v1.VehicleAttributeList(this);
      int from_bitField0_ = bitField0_;
      if (attributesBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          attributes_ = java.util.Collections.unmodifiableList(attributes_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.attributes_ = attributes_;
      } else {
        result.attributes_ = attributesBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof google.maps.fleetengine.v1.VehicleAttributeList) {
        return mergeFrom((google.maps.fleetengine.v1.VehicleAttributeList)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(google.maps.fleetengine.v1.VehicleAttributeList other) {
      if (other == google.maps.fleetengine.v1.VehicleAttributeList.getDefaultInstance()) return this;
      if (attributesBuilder_ == null) {
        if (!other.attributes_.isEmpty()) {
          if (attributes_.isEmpty()) {
            attributes_ = other.attributes_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureAttributesIsMutable();
            attributes_.addAll(other.attributes_);
          }
          onChanged();
        }
      } else {
        if (!other.attributes_.isEmpty()) {
          if (attributesBuilder_.isEmpty()) {
            attributesBuilder_.dispose();
            attributesBuilder_ = null;
            attributes_ = other.attributes_;
            bitField0_ = (bitField0_ & ~0x00000001);
            attributesBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getAttributesFieldBuilder() : null;
          } else {
            attributesBuilder_.addAllMessages(other.attributes_);
          }
        }
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      google.maps.fleetengine.v1.VehicleAttributeList parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (google.maps.fleetengine.v1.VehicleAttributeList) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<google.maps.fleetengine.v1.VehicleAttribute> attributes_ =
      java.util.Collections.emptyList();
    private void ensureAttributesIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        attributes_ = new java.util.ArrayList<google.maps.fleetengine.v1.VehicleAttribute>(attributes_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        google.maps.fleetengine.v1.VehicleAttribute, google.maps.fleetengine.v1.VehicleAttribute.Builder, google.maps.fleetengine.v1.VehicleAttributeOrBuilder> attributesBuilder_;

    /**
     * <pre>
     * A list of attributes in this collection.
     * </pre>
     *
     * <code>repeated .maps.fleetengine.v1.VehicleAttribute attributes = 1;</code>
     */
    public java.util.List<google.maps.fleetengine.v1.VehicleAttribute> getAttributesList() {
      if (attributesBuilder_ == null) {
        return java.util.Collections.unmodifiableList(attributes_);
      } else {
        return attributesBuilder_.getMessageList();
      }
    }
    /**
     * <pre>
     * A list of attributes in this collection.
     * </pre>
     *
     * <code>repeated .maps.fleetengine.v1.VehicleAttribute attributes = 1;</code>
     */
    public int getAttributesCount() {
      if (attributesBuilder_ == null) {
        return attributes_.size();
      } else {
        return attributesBuilder_.getCount();
      }
    }
    /**
     * <pre>
     * A list of attributes in this collection.
     * </pre>
     *
     * <code>repeated .maps.fleetengine.v1.VehicleAttribute attributes = 1;</code>
     */
    public google.maps.fleetengine.v1.VehicleAttribute getAttributes(int index) {
      if (attributesBuilder_ == null) {
        return attributes_.get(index);
      } else {
        return attributesBuilder_.getMessage(index);
      }
    }
    /**
     * <pre>
     * A list of attributes in this collection.
     * </pre>
     *
     * <code>repeated .maps.fleetengine.v1.VehicleAttribute attributes = 1;</code>
     */
    public Builder setAttributes(
        int index, google.maps.fleetengine.v1.VehicleAttribute value) {
      if (attributesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureAttributesIsMutable();
        attributes_.set(index, value);
        onChanged();
      } else {
        attributesBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <pre>
     * A list of attributes in this collection.
     * </pre>
     *
     * <code>repeated .maps.fleetengine.v1.VehicleAttribute attributes = 1;</code>
     */
    public Builder setAttributes(
        int index, google.maps.fleetengine.v1.VehicleAttribute.Builder builderForValue) {
      if (attributesBuilder_ == null) {
        ensureAttributesIsMutable();
        attributes_.set(index, builderForValue.build());
        onChanged();
      } else {
        attributesBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     * A list of attributes in this collection.
     * </pre>
     *
     * <code>repeated .maps.fleetengine.v1.VehicleAttribute attributes = 1;</code>
     */
    public Builder addAttributes(google.maps.fleetengine.v1.VehicleAttribute value) {
      if (attributesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureAttributesIsMutable();
        attributes_.add(value);
        onChanged();
      } else {
        attributesBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <pre>
     * A list of attributes in this collection.
     * </pre>
     *
     * <code>repeated .maps.fleetengine.v1.VehicleAttribute attributes = 1;</code>
     */
    public Builder addAttributes(
        int index, google.maps.fleetengine.v1.VehicleAttribute value) {
      if (attributesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureAttributesIsMutable();
        attributes_.add(index, value);
        onChanged();
      } else {
        attributesBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <pre>
     * A list of attributes in this collection.
     * </pre>
     *
     * <code>repeated .maps.fleetengine.v1.VehicleAttribute attributes = 1;</code>
     */
    public Builder addAttributes(
        google.maps.fleetengine.v1.VehicleAttribute.Builder builderForValue) {
      if (attributesBuilder_ == null) {
        ensureAttributesIsMutable();
        attributes_.add(builderForValue.build());
        onChanged();
      } else {
        attributesBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     * A list of attributes in this collection.
     * </pre>
     *
     * <code>repeated .maps.fleetengine.v1.VehicleAttribute attributes = 1;</code>
     */
    public Builder addAttributes(
        int index, google.maps.fleetengine.v1.VehicleAttribute.Builder builderForValue) {
      if (attributesBuilder_ == null) {
        ensureAttributesIsMutable();
        attributes_.add(index, builderForValue.build());
        onChanged();
      } else {
        attributesBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     * A list of attributes in this collection.
     * </pre>
     *
     * <code>repeated .maps.fleetengine.v1.VehicleAttribute attributes = 1;</code>
     */
    public Builder addAllAttributes(
        java.lang.Iterable<? extends google.maps.fleetengine.v1.VehicleAttribute> values) {
      if (attributesBuilder_ == null) {
        ensureAttributesIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, attributes_);
        onChanged();
      } else {
        attributesBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <pre>
     * A list of attributes in this collection.
     * </pre>
     *
     * <code>repeated .maps.fleetengine.v1.VehicleAttribute attributes = 1;</code>
     */
    public Builder clearAttributes() {
      if (attributesBuilder_ == null) {
        attributes_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        attributesBuilder_.clear();
      }
      return this;
    }
    /**
     * <pre>
     * A list of attributes in this collection.
     * </pre>
     *
     * <code>repeated .maps.fleetengine.v1.VehicleAttribute attributes = 1;</code>
     */
    public Builder removeAttributes(int index) {
      if (attributesBuilder_ == null) {
        ensureAttributesIsMutable();
        attributes_.remove(index);
        onChanged();
      } else {
        attributesBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <pre>
     * A list of attributes in this collection.
     * </pre>
     *
     * <code>repeated .maps.fleetengine.v1.VehicleAttribute attributes = 1;</code>
     */
    public google.maps.fleetengine.v1.VehicleAttribute.Builder getAttributesBuilder(
        int index) {
      return getAttributesFieldBuilder().getBuilder(index);
    }
    /**
     * <pre>
     * A list of attributes in this collection.
     * </pre>
     *
     * <code>repeated .maps.fleetengine.v1.VehicleAttribute attributes = 1;</code>
     */
    public google.maps.fleetengine.v1.VehicleAttributeOrBuilder getAttributesOrBuilder(
        int index) {
      if (attributesBuilder_ == null) {
        return attributes_.get(index);  } else {
        return attributesBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <pre>
     * A list of attributes in this collection.
     * </pre>
     *
     * <code>repeated .maps.fleetengine.v1.VehicleAttribute attributes = 1;</code>
     */
    public java.util.List<? extends google.maps.fleetengine.v1.VehicleAttributeOrBuilder> 
         getAttributesOrBuilderList() {
      if (attributesBuilder_ != null) {
        return attributesBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(attributes_);
      }
    }
    /**
     * <pre>
     * A list of attributes in this collection.
     * </pre>
     *
     * <code>repeated .maps.fleetengine.v1.VehicleAttribute attributes = 1;</code>
     */
    public google.maps.fleetengine.v1.VehicleAttribute.Builder addAttributesBuilder() {
      return getAttributesFieldBuilder().addBuilder(
          google.maps.fleetengine.v1.VehicleAttribute.getDefaultInstance());
    }
    /**
     * <pre>
     * A list of attributes in this collection.
     * </pre>
     *
     * <code>repeated .maps.fleetengine.v1.VehicleAttribute attributes = 1;</code>
     */
    public google.maps.fleetengine.v1.VehicleAttribute.Builder addAttributesBuilder(
        int index) {
      return getAttributesFieldBuilder().addBuilder(
          index, google.maps.fleetengine.v1.VehicleAttribute.getDefaultInstance());
    }
    /**
     * <pre>
     * A list of attributes in this collection.
     * </pre>
     *
     * <code>repeated .maps.fleetengine.v1.VehicleAttribute attributes = 1;</code>
     */
    public java.util.List<google.maps.fleetengine.v1.VehicleAttribute.Builder> 
         getAttributesBuilderList() {
      return getAttributesFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        google.maps.fleetengine.v1.VehicleAttribute, google.maps.fleetengine.v1.VehicleAttribute.Builder, google.maps.fleetengine.v1.VehicleAttributeOrBuilder> 
        getAttributesFieldBuilder() {
      if (attributesBuilder_ == null) {
        attributesBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            google.maps.fleetengine.v1.VehicleAttribute, google.maps.fleetengine.v1.VehicleAttribute.Builder, google.maps.fleetengine.v1.VehicleAttributeOrBuilder>(
                attributes_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        attributes_ = null;
      }
      return attributesBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:maps.fleetengine.v1.VehicleAttributeList)
  }

  // @@protoc_insertion_point(class_scope:maps.fleetengine.v1.VehicleAttributeList)
  private static final google.maps.fleetengine.v1.VehicleAttributeList DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new google.maps.fleetengine.v1.VehicleAttributeList();
  }

  public static google.maps.fleetengine.v1.VehicleAttributeList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<VehicleAttributeList>
      PARSER = new com.google.protobuf.AbstractParser<VehicleAttributeList>() {
    @java.lang.Override
    public VehicleAttributeList parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new VehicleAttributeList(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<VehicleAttributeList> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<VehicleAttributeList> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public google.maps.fleetengine.v1.VehicleAttributeList getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

