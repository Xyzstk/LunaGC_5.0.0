// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: HitClientTrivialNotify.proto

package emu.grasscutter.net.proto;

public final class HitClientTrivialNotifyOuterClass {
  private HitClientTrivialNotifyOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface HitClientTrivialNotifyOrBuilder extends
      // @@protoc_insertion_point(interface_extends:HitClientTrivialNotify)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>.Vector position = 10;</code>
     * @return Whether the position field is set.
     */
    boolean hasPosition();
    /**
     * <code>.Vector position = 10;</code>
     * @return The position.
     */
    emu.grasscutter.net.proto.VectorOuterClass.Vector getPosition();
    /**
     * <code>.Vector position = 10;</code>
     */
    emu.grasscutter.net.proto.VectorOuterClass.VectorOrBuilder getPositionOrBuilder();

    /**
     * <code>uint32 owner_entity_id = 15;</code>
     * @return The ownerEntityId.
     */
    int getOwnerEntityId();
  }
  /**
   * <pre>
   * CmdId: 25759
   * </pre>
   *
   * Protobuf type {@code HitClientTrivialNotify}
   */
  public static final class HitClientTrivialNotify extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:HitClientTrivialNotify)
      HitClientTrivialNotifyOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use HitClientTrivialNotify.newBuilder() to construct.
    private HitClientTrivialNotify(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private HitClientTrivialNotify() {
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new HitClientTrivialNotify();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private HitClientTrivialNotify(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
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
            case 82: {
              emu.grasscutter.net.proto.VectorOuterClass.Vector.Builder subBuilder = null;
              if (position_ != null) {
                subBuilder = position_.toBuilder();
              }
              position_ = input.readMessage(emu.grasscutter.net.proto.VectorOuterClass.Vector.parser(), extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(position_);
                position_ = subBuilder.buildPartial();
              }

              break;
            }
            case 120: {

              ownerEntityId_ = input.readUInt32();
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
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return emu.grasscutter.net.proto.HitClientTrivialNotifyOuterClass.internal_static_HitClientTrivialNotify_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return emu.grasscutter.net.proto.HitClientTrivialNotifyOuterClass.internal_static_HitClientTrivialNotify_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              emu.grasscutter.net.proto.HitClientTrivialNotifyOuterClass.HitClientTrivialNotify.class, emu.grasscutter.net.proto.HitClientTrivialNotifyOuterClass.HitClientTrivialNotify.Builder.class);
    }

    public static final int POSITION_FIELD_NUMBER = 10;
    private emu.grasscutter.net.proto.VectorOuterClass.Vector position_;
    /**
     * <code>.Vector position = 10;</code>
     * @return Whether the position field is set.
     */
    @java.lang.Override
    public boolean hasPosition() {
      return position_ != null;
    }
    /**
     * <code>.Vector position = 10;</code>
     * @return The position.
     */
    @java.lang.Override
    public emu.grasscutter.net.proto.VectorOuterClass.Vector getPosition() {
      return position_ == null ? emu.grasscutter.net.proto.VectorOuterClass.Vector.getDefaultInstance() : position_;
    }
    /**
     * <code>.Vector position = 10;</code>
     */
    @java.lang.Override
    public emu.grasscutter.net.proto.VectorOuterClass.VectorOrBuilder getPositionOrBuilder() {
      return getPosition();
    }

    public static final int OWNER_ENTITY_ID_FIELD_NUMBER = 15;
    private int ownerEntityId_;
    /**
     * <code>uint32 owner_entity_id = 15;</code>
     * @return The ownerEntityId.
     */
    @java.lang.Override
    public int getOwnerEntityId() {
      return ownerEntityId_;
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
      if (position_ != null) {
        output.writeMessage(10, getPosition());
      }
      if (ownerEntityId_ != 0) {
        output.writeUInt32(15, ownerEntityId_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (position_ != null) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(10, getPosition());
      }
      if (ownerEntityId_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt32Size(15, ownerEntityId_);
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
      if (!(obj instanceof emu.grasscutter.net.proto.HitClientTrivialNotifyOuterClass.HitClientTrivialNotify)) {
        return super.equals(obj);
      }
      emu.grasscutter.net.proto.HitClientTrivialNotifyOuterClass.HitClientTrivialNotify other = (emu.grasscutter.net.proto.HitClientTrivialNotifyOuterClass.HitClientTrivialNotify) obj;

      if (hasPosition() != other.hasPosition()) return false;
      if (hasPosition()) {
        if (!getPosition()
            .equals(other.getPosition())) return false;
      }
      if (getOwnerEntityId()
          != other.getOwnerEntityId()) return false;
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
      if (hasPosition()) {
        hash = (37 * hash) + POSITION_FIELD_NUMBER;
        hash = (53 * hash) + getPosition().hashCode();
      }
      hash = (37 * hash) + OWNER_ENTITY_ID_FIELD_NUMBER;
      hash = (53 * hash) + getOwnerEntityId();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static emu.grasscutter.net.proto.HitClientTrivialNotifyOuterClass.HitClientTrivialNotify parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static emu.grasscutter.net.proto.HitClientTrivialNotifyOuterClass.HitClientTrivialNotify parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static emu.grasscutter.net.proto.HitClientTrivialNotifyOuterClass.HitClientTrivialNotify parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static emu.grasscutter.net.proto.HitClientTrivialNotifyOuterClass.HitClientTrivialNotify parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static emu.grasscutter.net.proto.HitClientTrivialNotifyOuterClass.HitClientTrivialNotify parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static emu.grasscutter.net.proto.HitClientTrivialNotifyOuterClass.HitClientTrivialNotify parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static emu.grasscutter.net.proto.HitClientTrivialNotifyOuterClass.HitClientTrivialNotify parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static emu.grasscutter.net.proto.HitClientTrivialNotifyOuterClass.HitClientTrivialNotify parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static emu.grasscutter.net.proto.HitClientTrivialNotifyOuterClass.HitClientTrivialNotify parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static emu.grasscutter.net.proto.HitClientTrivialNotifyOuterClass.HitClientTrivialNotify parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static emu.grasscutter.net.proto.HitClientTrivialNotifyOuterClass.HitClientTrivialNotify parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static emu.grasscutter.net.proto.HitClientTrivialNotifyOuterClass.HitClientTrivialNotify parseFrom(
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
    public static Builder newBuilder(emu.grasscutter.net.proto.HitClientTrivialNotifyOuterClass.HitClientTrivialNotify prototype) {
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
     * CmdId: 25759
     * </pre>
     *
     * Protobuf type {@code HitClientTrivialNotify}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:HitClientTrivialNotify)
        emu.grasscutter.net.proto.HitClientTrivialNotifyOuterClass.HitClientTrivialNotifyOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return emu.grasscutter.net.proto.HitClientTrivialNotifyOuterClass.internal_static_HitClientTrivialNotify_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return emu.grasscutter.net.proto.HitClientTrivialNotifyOuterClass.internal_static_HitClientTrivialNotify_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                emu.grasscutter.net.proto.HitClientTrivialNotifyOuterClass.HitClientTrivialNotify.class, emu.grasscutter.net.proto.HitClientTrivialNotifyOuterClass.HitClientTrivialNotify.Builder.class);
      }

      // Construct using emu.grasscutter.net.proto.HitClientTrivialNotifyOuterClass.HitClientTrivialNotify.newBuilder()
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
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        if (positionBuilder_ == null) {
          position_ = null;
        } else {
          position_ = null;
          positionBuilder_ = null;
        }
        ownerEntityId_ = 0;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return emu.grasscutter.net.proto.HitClientTrivialNotifyOuterClass.internal_static_HitClientTrivialNotify_descriptor;
      }

      @java.lang.Override
      public emu.grasscutter.net.proto.HitClientTrivialNotifyOuterClass.HitClientTrivialNotify getDefaultInstanceForType() {
        return emu.grasscutter.net.proto.HitClientTrivialNotifyOuterClass.HitClientTrivialNotify.getDefaultInstance();
      }

      @java.lang.Override
      public emu.grasscutter.net.proto.HitClientTrivialNotifyOuterClass.HitClientTrivialNotify build() {
        emu.grasscutter.net.proto.HitClientTrivialNotifyOuterClass.HitClientTrivialNotify result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public emu.grasscutter.net.proto.HitClientTrivialNotifyOuterClass.HitClientTrivialNotify buildPartial() {
        emu.grasscutter.net.proto.HitClientTrivialNotifyOuterClass.HitClientTrivialNotify result = new emu.grasscutter.net.proto.HitClientTrivialNotifyOuterClass.HitClientTrivialNotify(this);
        if (positionBuilder_ == null) {
          result.position_ = position_;
        } else {
          result.position_ = positionBuilder_.build();
        }
        result.ownerEntityId_ = ownerEntityId_;
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
        if (other instanceof emu.grasscutter.net.proto.HitClientTrivialNotifyOuterClass.HitClientTrivialNotify) {
          return mergeFrom((emu.grasscutter.net.proto.HitClientTrivialNotifyOuterClass.HitClientTrivialNotify)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(emu.grasscutter.net.proto.HitClientTrivialNotifyOuterClass.HitClientTrivialNotify other) {
        if (other == emu.grasscutter.net.proto.HitClientTrivialNotifyOuterClass.HitClientTrivialNotify.getDefaultInstance()) return this;
        if (other.hasPosition()) {
          mergePosition(other.getPosition());
        }
        if (other.getOwnerEntityId() != 0) {
          setOwnerEntityId(other.getOwnerEntityId());
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
        emu.grasscutter.net.proto.HitClientTrivialNotifyOuterClass.HitClientTrivialNotify parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (emu.grasscutter.net.proto.HitClientTrivialNotifyOuterClass.HitClientTrivialNotify) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private emu.grasscutter.net.proto.VectorOuterClass.Vector position_;
      private com.google.protobuf.SingleFieldBuilderV3<
          emu.grasscutter.net.proto.VectorOuterClass.Vector, emu.grasscutter.net.proto.VectorOuterClass.Vector.Builder, emu.grasscutter.net.proto.VectorOuterClass.VectorOrBuilder> positionBuilder_;
      /**
       * <code>.Vector position = 10;</code>
       * @return Whether the position field is set.
       */
      public boolean hasPosition() {
        return positionBuilder_ != null || position_ != null;
      }
      /**
       * <code>.Vector position = 10;</code>
       * @return The position.
       */
      public emu.grasscutter.net.proto.VectorOuterClass.Vector getPosition() {
        if (positionBuilder_ == null) {
          return position_ == null ? emu.grasscutter.net.proto.VectorOuterClass.Vector.getDefaultInstance() : position_;
        } else {
          return positionBuilder_.getMessage();
        }
      }
      /**
       * <code>.Vector position = 10;</code>
       */
      public Builder setPosition(emu.grasscutter.net.proto.VectorOuterClass.Vector value) {
        if (positionBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          position_ = value;
          onChanged();
        } else {
          positionBuilder_.setMessage(value);
        }

        return this;
      }
      /**
       * <code>.Vector position = 10;</code>
       */
      public Builder setPosition(
          emu.grasscutter.net.proto.VectorOuterClass.Vector.Builder builderForValue) {
        if (positionBuilder_ == null) {
          position_ = builderForValue.build();
          onChanged();
        } else {
          positionBuilder_.setMessage(builderForValue.build());
        }

        return this;
      }
      /**
       * <code>.Vector position = 10;</code>
       */
      public Builder mergePosition(emu.grasscutter.net.proto.VectorOuterClass.Vector value) {
        if (positionBuilder_ == null) {
          if (position_ != null) {
            position_ =
              emu.grasscutter.net.proto.VectorOuterClass.Vector.newBuilder(position_).mergeFrom(value).buildPartial();
          } else {
            position_ = value;
          }
          onChanged();
        } else {
          positionBuilder_.mergeFrom(value);
        }

        return this;
      }
      /**
       * <code>.Vector position = 10;</code>
       */
      public Builder clearPosition() {
        if (positionBuilder_ == null) {
          position_ = null;
          onChanged();
        } else {
          position_ = null;
          positionBuilder_ = null;
        }

        return this;
      }
      /**
       * <code>.Vector position = 10;</code>
       */
      public emu.grasscutter.net.proto.VectorOuterClass.Vector.Builder getPositionBuilder() {
        
        onChanged();
        return getPositionFieldBuilder().getBuilder();
      }
      /**
       * <code>.Vector position = 10;</code>
       */
      public emu.grasscutter.net.proto.VectorOuterClass.VectorOrBuilder getPositionOrBuilder() {
        if (positionBuilder_ != null) {
          return positionBuilder_.getMessageOrBuilder();
        } else {
          return position_ == null ?
              emu.grasscutter.net.proto.VectorOuterClass.Vector.getDefaultInstance() : position_;
        }
      }
      /**
       * <code>.Vector position = 10;</code>
       */
      private com.google.protobuf.SingleFieldBuilderV3<
          emu.grasscutter.net.proto.VectorOuterClass.Vector, emu.grasscutter.net.proto.VectorOuterClass.Vector.Builder, emu.grasscutter.net.proto.VectorOuterClass.VectorOrBuilder> 
          getPositionFieldBuilder() {
        if (positionBuilder_ == null) {
          positionBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
              emu.grasscutter.net.proto.VectorOuterClass.Vector, emu.grasscutter.net.proto.VectorOuterClass.Vector.Builder, emu.grasscutter.net.proto.VectorOuterClass.VectorOrBuilder>(
                  getPosition(),
                  getParentForChildren(),
                  isClean());
          position_ = null;
        }
        return positionBuilder_;
      }

      private int ownerEntityId_ ;
      /**
       * <code>uint32 owner_entity_id = 15;</code>
       * @return The ownerEntityId.
       */
      @java.lang.Override
      public int getOwnerEntityId() {
        return ownerEntityId_;
      }
      /**
       * <code>uint32 owner_entity_id = 15;</code>
       * @param value The ownerEntityId to set.
       * @return This builder for chaining.
       */
      public Builder setOwnerEntityId(int value) {
        
        ownerEntityId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>uint32 owner_entity_id = 15;</code>
       * @return This builder for chaining.
       */
      public Builder clearOwnerEntityId() {
        
        ownerEntityId_ = 0;
        onChanged();
        return this;
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


      // @@protoc_insertion_point(builder_scope:HitClientTrivialNotify)
    }

    // @@protoc_insertion_point(class_scope:HitClientTrivialNotify)
    private static final emu.grasscutter.net.proto.HitClientTrivialNotifyOuterClass.HitClientTrivialNotify DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new emu.grasscutter.net.proto.HitClientTrivialNotifyOuterClass.HitClientTrivialNotify();
    }

    public static emu.grasscutter.net.proto.HitClientTrivialNotifyOuterClass.HitClientTrivialNotify getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<HitClientTrivialNotify>
        PARSER = new com.google.protobuf.AbstractParser<HitClientTrivialNotify>() {
      @java.lang.Override
      public HitClientTrivialNotify parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new HitClientTrivialNotify(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<HitClientTrivialNotify> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<HitClientTrivialNotify> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public emu.grasscutter.net.proto.HitClientTrivialNotifyOuterClass.HitClientTrivialNotify getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_HitClientTrivialNotify_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_HitClientTrivialNotify_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\034HitClientTrivialNotify.proto\032\014Vector.p" +
      "roto\"L\n\026HitClientTrivialNotify\022\031\n\010positi" +
      "on\030\n \001(\0132\007.Vector\022\027\n\017owner_entity_id\030\017 \001" +
      "(\rB\033\n\031emu.grasscutter.net.protob\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          emu.grasscutter.net.proto.VectorOuterClass.getDescriptor(),
        });
    internal_static_HitClientTrivialNotify_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_HitClientTrivialNotify_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_HitClientTrivialNotify_descriptor,
        new java.lang.String[] { "Position", "OwnerEntityId", });
    emu.grasscutter.net.proto.VectorOuterClass.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
