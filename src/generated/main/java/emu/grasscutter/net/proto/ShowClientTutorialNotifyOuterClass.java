// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ShowClientTutorialNotify.proto

package emu.grasscutter.net.proto;

public final class ShowClientTutorialNotifyOuterClass {
  private ShowClientTutorialNotifyOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface ShowClientTutorialNotifyOrBuilder extends
      // @@protoc_insertion_point(interface_extends:ShowClientTutorialNotify)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>uint32 tutorial_id = 7;</code>
     * @return The tutorialId.
     */
    int getTutorialId();
  }
  /**
   * <pre>
   * CmdId: 2753
   * Obf: KDFBIIGEAOC
   * </pre>
   *
   * Protobuf type {@code ShowClientTutorialNotify}
   */
  public static final class ShowClientTutorialNotify extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:ShowClientTutorialNotify)
      ShowClientTutorialNotifyOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use ShowClientTutorialNotify.newBuilder() to construct.
    private ShowClientTutorialNotify(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private ShowClientTutorialNotify() {
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new ShowClientTutorialNotify();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private ShowClientTutorialNotify(
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
            case 56: {

              tutorialId_ = input.readUInt32();
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
      return emu.grasscutter.net.proto.ShowClientTutorialNotifyOuterClass.internal_static_ShowClientTutorialNotify_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return emu.grasscutter.net.proto.ShowClientTutorialNotifyOuterClass.internal_static_ShowClientTutorialNotify_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              emu.grasscutter.net.proto.ShowClientTutorialNotifyOuterClass.ShowClientTutorialNotify.class, emu.grasscutter.net.proto.ShowClientTutorialNotifyOuterClass.ShowClientTutorialNotify.Builder.class);
    }

    public static final int TUTORIAL_ID_FIELD_NUMBER = 7;
    private int tutorialId_;
    /**
     * <code>uint32 tutorial_id = 7;</code>
     * @return The tutorialId.
     */
    @java.lang.Override
    public int getTutorialId() {
      return tutorialId_;
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
      if (tutorialId_ != 0) {
        output.writeUInt32(7, tutorialId_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (tutorialId_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt32Size(7, tutorialId_);
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
      if (!(obj instanceof emu.grasscutter.net.proto.ShowClientTutorialNotifyOuterClass.ShowClientTutorialNotify)) {
        return super.equals(obj);
      }
      emu.grasscutter.net.proto.ShowClientTutorialNotifyOuterClass.ShowClientTutorialNotify other = (emu.grasscutter.net.proto.ShowClientTutorialNotifyOuterClass.ShowClientTutorialNotify) obj;

      if (getTutorialId()
          != other.getTutorialId()) return false;
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
      hash = (37 * hash) + TUTORIAL_ID_FIELD_NUMBER;
      hash = (53 * hash) + getTutorialId();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static emu.grasscutter.net.proto.ShowClientTutorialNotifyOuterClass.ShowClientTutorialNotify parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static emu.grasscutter.net.proto.ShowClientTutorialNotifyOuterClass.ShowClientTutorialNotify parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static emu.grasscutter.net.proto.ShowClientTutorialNotifyOuterClass.ShowClientTutorialNotify parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static emu.grasscutter.net.proto.ShowClientTutorialNotifyOuterClass.ShowClientTutorialNotify parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static emu.grasscutter.net.proto.ShowClientTutorialNotifyOuterClass.ShowClientTutorialNotify parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static emu.grasscutter.net.proto.ShowClientTutorialNotifyOuterClass.ShowClientTutorialNotify parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static emu.grasscutter.net.proto.ShowClientTutorialNotifyOuterClass.ShowClientTutorialNotify parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static emu.grasscutter.net.proto.ShowClientTutorialNotifyOuterClass.ShowClientTutorialNotify parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static emu.grasscutter.net.proto.ShowClientTutorialNotifyOuterClass.ShowClientTutorialNotify parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static emu.grasscutter.net.proto.ShowClientTutorialNotifyOuterClass.ShowClientTutorialNotify parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static emu.grasscutter.net.proto.ShowClientTutorialNotifyOuterClass.ShowClientTutorialNotify parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static emu.grasscutter.net.proto.ShowClientTutorialNotifyOuterClass.ShowClientTutorialNotify parseFrom(
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
    public static Builder newBuilder(emu.grasscutter.net.proto.ShowClientTutorialNotifyOuterClass.ShowClientTutorialNotify prototype) {
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
     * CmdId: 2753
     * Obf: KDFBIIGEAOC
     * </pre>
     *
     * Protobuf type {@code ShowClientTutorialNotify}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:ShowClientTutorialNotify)
        emu.grasscutter.net.proto.ShowClientTutorialNotifyOuterClass.ShowClientTutorialNotifyOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return emu.grasscutter.net.proto.ShowClientTutorialNotifyOuterClass.internal_static_ShowClientTutorialNotify_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return emu.grasscutter.net.proto.ShowClientTutorialNotifyOuterClass.internal_static_ShowClientTutorialNotify_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                emu.grasscutter.net.proto.ShowClientTutorialNotifyOuterClass.ShowClientTutorialNotify.class, emu.grasscutter.net.proto.ShowClientTutorialNotifyOuterClass.ShowClientTutorialNotify.Builder.class);
      }

      // Construct using emu.grasscutter.net.proto.ShowClientTutorialNotifyOuterClass.ShowClientTutorialNotify.newBuilder()
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
        tutorialId_ = 0;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return emu.grasscutter.net.proto.ShowClientTutorialNotifyOuterClass.internal_static_ShowClientTutorialNotify_descriptor;
      }

      @java.lang.Override
      public emu.grasscutter.net.proto.ShowClientTutorialNotifyOuterClass.ShowClientTutorialNotify getDefaultInstanceForType() {
        return emu.grasscutter.net.proto.ShowClientTutorialNotifyOuterClass.ShowClientTutorialNotify.getDefaultInstance();
      }

      @java.lang.Override
      public emu.grasscutter.net.proto.ShowClientTutorialNotifyOuterClass.ShowClientTutorialNotify build() {
        emu.grasscutter.net.proto.ShowClientTutorialNotifyOuterClass.ShowClientTutorialNotify result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public emu.grasscutter.net.proto.ShowClientTutorialNotifyOuterClass.ShowClientTutorialNotify buildPartial() {
        emu.grasscutter.net.proto.ShowClientTutorialNotifyOuterClass.ShowClientTutorialNotify result = new emu.grasscutter.net.proto.ShowClientTutorialNotifyOuterClass.ShowClientTutorialNotify(this);
        result.tutorialId_ = tutorialId_;
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
        if (other instanceof emu.grasscutter.net.proto.ShowClientTutorialNotifyOuterClass.ShowClientTutorialNotify) {
          return mergeFrom((emu.grasscutter.net.proto.ShowClientTutorialNotifyOuterClass.ShowClientTutorialNotify)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(emu.grasscutter.net.proto.ShowClientTutorialNotifyOuterClass.ShowClientTutorialNotify other) {
        if (other == emu.grasscutter.net.proto.ShowClientTutorialNotifyOuterClass.ShowClientTutorialNotify.getDefaultInstance()) return this;
        if (other.getTutorialId() != 0) {
          setTutorialId(other.getTutorialId());
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
        emu.grasscutter.net.proto.ShowClientTutorialNotifyOuterClass.ShowClientTutorialNotify parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (emu.grasscutter.net.proto.ShowClientTutorialNotifyOuterClass.ShowClientTutorialNotify) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int tutorialId_ ;
      /**
       * <code>uint32 tutorial_id = 7;</code>
       * @return The tutorialId.
       */
      @java.lang.Override
      public int getTutorialId() {
        return tutorialId_;
      }
      /**
       * <code>uint32 tutorial_id = 7;</code>
       * @param value The tutorialId to set.
       * @return This builder for chaining.
       */
      public Builder setTutorialId(int value) {
        
        tutorialId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>uint32 tutorial_id = 7;</code>
       * @return This builder for chaining.
       */
      public Builder clearTutorialId() {
        
        tutorialId_ = 0;
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


      // @@protoc_insertion_point(builder_scope:ShowClientTutorialNotify)
    }

    // @@protoc_insertion_point(class_scope:ShowClientTutorialNotify)
    private static final emu.grasscutter.net.proto.ShowClientTutorialNotifyOuterClass.ShowClientTutorialNotify DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new emu.grasscutter.net.proto.ShowClientTutorialNotifyOuterClass.ShowClientTutorialNotify();
    }

    public static emu.grasscutter.net.proto.ShowClientTutorialNotifyOuterClass.ShowClientTutorialNotify getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<ShowClientTutorialNotify>
        PARSER = new com.google.protobuf.AbstractParser<ShowClientTutorialNotify>() {
      @java.lang.Override
      public ShowClientTutorialNotify parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new ShowClientTutorialNotify(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<ShowClientTutorialNotify> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<ShowClientTutorialNotify> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public emu.grasscutter.net.proto.ShowClientTutorialNotifyOuterClass.ShowClientTutorialNotify getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ShowClientTutorialNotify_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ShowClientTutorialNotify_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\036ShowClientTutorialNotify.proto\"/\n\030Show" +
      "ClientTutorialNotify\022\023\n\013tutorial_id\030\007 \001(" +
      "\rB\033\n\031emu.grasscutter.net.protob\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_ShowClientTutorialNotify_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ShowClientTutorialNotify_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ShowClientTutorialNotify_descriptor,
        new java.lang.String[] { "TutorialId", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
