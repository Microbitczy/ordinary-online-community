package cn.hiczy.protobuf;// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: AuthResponse.proto

public final class AuthResponseProto {
  private AuthResponseProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface AuthResponseOrBuilder extends
      // @@protoc_insertion_point(interface_extends:AuthResponse)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <pre>
     *int64 m_id        = 1;  //消息id
     * </pre>
     *
     * <code>.AuthResponse.ResponseCode code = 2;</code>
     * @return The enum numeric value on the wire for code.
     */
    int getCodeValue();
    /**
     * <pre>
     *int64 m_id        = 1;  //消息id
     * </pre>
     *
     * <code>.AuthResponse.ResponseCode code = 2;</code>
     * @return The code.
     */
    AuthResponse.ResponseCode getCode();

    /**
     * <pre>
     *登陆url
     * </pre>
     *
     * <code>string auth_url = 3;</code>
     * @return The authUrl.
     */
    String getAuthUrl();
    /**
     * <pre>
     *登陆url
     * </pre>
     *
     * <code>string auth_url = 3;</code>
     * @return The bytes for authUrl.
     */
    com.google.protobuf.ByteString
        getAuthUrlBytes();
  }
  /**
   * Protobuf type {@code AuthResponse}
   */
  public static final class AuthResponse extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:AuthResponse)
      AuthResponseOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use AuthResponse.newBuilder() to construct.
    private AuthResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private AuthResponse() {
      code_ = 0;
      authUrl_ = "";
    }

    @Override
    @SuppressWarnings({"unused"})
    protected Object newInstance(
        UnusedPrivateParameter unused) {
      return new AuthResponse();
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private AuthResponse(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new NullPointerException();
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
            case 16: {
              int rawValue = input.readEnum();

              code_ = rawValue;
              break;
            }
            case 26: {
              String s = input.readStringRequireUtf8();

              authUrl_ = s;
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
      return AuthResponseProto.internal_static_AuthResponse_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return AuthResponseProto.internal_static_AuthResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              AuthResponse.class, Builder.class);
    }

    /**
     * Protobuf enum {@code AuthResponse.ResponseCode}
     */
    public enum ResponseCode
        implements com.google.protobuf.ProtocolMessageEnum {
      /**
       * <code>FAILED = 0;</code>
       */
      FAILED(0),
      /**
       * <code>OK = 1;</code>
       */
      OK(1),
      UNRECOGNIZED(-1),
      ;

      /**
       * <code>FAILED = 0;</code>
       */
      public static final int FAILED_VALUE = 0;
      /**
       * <code>OK = 1;</code>
       */
      public static final int OK_VALUE = 1;


      public final int getNumber() {
        if (this == UNRECOGNIZED) {
          throw new IllegalArgumentException(
              "Can't get the number of an unknown enum value.");
        }
        return value;
      }

      /**
       * @param value The numeric wire value of the corresponding enum entry.
       * @return The enum associated with the given numeric wire value.
       * @deprecated Use {@link #forNumber(int)} instead.
       */
      @Deprecated
      public static ResponseCode valueOf(int value) {
        return forNumber(value);
      }

      /**
       * @param value The numeric wire value of the corresponding enum entry.
       * @return The enum associated with the given numeric wire value.
       */
      public static ResponseCode forNumber(int value) {
        switch (value) {
          case 0: return FAILED;
          case 1: return OK;
          default: return null;
        }
      }

      public static com.google.protobuf.Internal.EnumLiteMap<ResponseCode>
          internalGetValueMap() {
        return internalValueMap;
      }
      private static final com.google.protobuf.Internal.EnumLiteMap<
          ResponseCode> internalValueMap =
            new com.google.protobuf.Internal.EnumLiteMap<ResponseCode>() {
              public ResponseCode findValueByNumber(int number) {
                return ResponseCode.forNumber(number);
              }
            };

      public final com.google.protobuf.Descriptors.EnumValueDescriptor
          getValueDescriptor() {
        if (this == UNRECOGNIZED) {
          throw new IllegalStateException(
              "Can't get the descriptor of an unrecognized enum value.");
        }
        return getDescriptor().getValues().get(ordinal());
      }
      public final com.google.protobuf.Descriptors.EnumDescriptor
          getDescriptorForType() {
        return getDescriptor();
      }
      public static final com.google.protobuf.Descriptors.EnumDescriptor
          getDescriptor() {
        return AuthResponse.getDescriptor().getEnumTypes().get(0);
      }

      private static final ResponseCode[] VALUES = values();

      public static ResponseCode valueOf(
          com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
        if (desc.getType() != getDescriptor()) {
          throw new IllegalArgumentException(
            "EnumValueDescriptor is not for this type.");
        }
        if (desc.getIndex() == -1) {
          return UNRECOGNIZED;
        }
        return VALUES[desc.getIndex()];
      }

      private final int value;

      private ResponseCode(int value) {
        this.value = value;
      }

      // @@protoc_insertion_point(enum_scope:AuthResponse.ResponseCode)
    }

    public static final int CODE_FIELD_NUMBER = 2;
    private int code_;
    /**
     * <pre>
     *int64 m_id        = 1;  //消息id
     * </pre>
     *
     * <code>.AuthResponse.ResponseCode code = 2;</code>
     * @return The enum numeric value on the wire for code.
     */
    @Override public int getCodeValue() {
      return code_;
    }
    /**
     * <pre>
     *int64 m_id        = 1;  //消息id
     * </pre>
     *
     * <code>.AuthResponse.ResponseCode code = 2;</code>
     * @return The code.
     */
    @Override public ResponseCode getCode() {
      @SuppressWarnings("deprecation")
      ResponseCode result = ResponseCode.valueOf(code_);
      return result == null ? ResponseCode.UNRECOGNIZED : result;
    }

    public static final int AUTH_URL_FIELD_NUMBER = 3;
    private volatile Object authUrl_;
    /**
     * <pre>
     *登陆url
     * </pre>
     *
     * <code>string auth_url = 3;</code>
     * @return The authUrl.
     */
    @Override
    public String getAuthUrl() {
      Object ref = authUrl_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        authUrl_ = s;
        return s;
      }
    }
    /**
     * <pre>
     *登陆url
     * </pre>
     *
     * <code>string auth_url = 3;</code>
     * @return The bytes for authUrl.
     */
    @Override
    public com.google.protobuf.ByteString
        getAuthUrlBytes() {
      Object ref = authUrl_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        authUrl_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private byte memoizedIsInitialized = -1;
    @Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (code_ != ResponseCode.FAILED.getNumber()) {
        output.writeEnum(2, code_);
      }
      if (!getAuthUrlBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, authUrl_);
      }
      unknownFields.writeTo(output);
    }

    @Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (code_ != ResponseCode.FAILED.getNumber()) {
        size += com.google.protobuf.CodedOutputStream
          .computeEnumSize(2, code_);
      }
      if (!getAuthUrlBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, authUrl_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @Override
    public boolean equals(final Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof AuthResponse)) {
        return super.equals(obj);
      }
      AuthResponse other = (AuthResponse) obj;

      if (code_ != other.code_) return false;
      if (!getAuthUrl()
          .equals(other.getAuthUrl())) return false;
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + CODE_FIELD_NUMBER;
      hash = (53 * hash) + code_;
      hash = (37 * hash) + AUTH_URL_FIELD_NUMBER;
      hash = (53 * hash) + getAuthUrl().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static AuthResponse parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static AuthResponse parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static AuthResponse parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static AuthResponse parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static AuthResponse parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static AuthResponse parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static AuthResponse parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static AuthResponse parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static AuthResponse parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static AuthResponse parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static AuthResponse parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static AuthResponse parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(AuthResponse prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override
    protected Builder newBuilderForType(
        BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code AuthResponse}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:AuthResponse)
        AuthResponseOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return AuthResponseProto.internal_static_AuthResponse_descriptor;
      }

      @Override
      protected FieldAccessorTable
          internalGetFieldAccessorTable() {
        return AuthResponseProto.internal_static_AuthResponse_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                AuthResponse.class, Builder.class);
      }

      // Construct using AuthResponseProto.AuthResponse.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      @Override
      public Builder clear() {
        super.clear();
        code_ = 0;

        authUrl_ = "";

        return this;
      }

      @Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return AuthResponseProto.internal_static_AuthResponse_descriptor;
      }

      @Override
      public AuthResponse getDefaultInstanceForType() {
        return AuthResponse.getDefaultInstance();
      }

      @Override
      public AuthResponse build() {
        AuthResponse result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @Override
      public AuthResponse buildPartial() {
        AuthResponse result = new AuthResponse(this);
        result.code_ = code_;
        result.authUrl_ = authUrl_;
        onBuilt();
        return result;
      }

      @Override
      public Builder clone() {
        return super.clone();
      }
      @Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return super.setField(field, value);
      }
      @Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return super.addRepeatedField(field, value);
      }
      @Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof AuthResponse) {
          return mergeFrom((AuthResponse)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(AuthResponse other) {
        if (other == AuthResponse.getDefaultInstance()) return this;
        if (other.code_ != 0) {
          setCodeValue(other.getCodeValue());
        }
        if (!other.getAuthUrl().isEmpty()) {
          authUrl_ = other.authUrl_;
          onChanged();
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @Override
      public final boolean isInitialized() {
        return true;
      }

      @Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        AuthResponse parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (AuthResponse) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int code_ = 0;
      /**
       * <pre>
       *int64 m_id        = 1;  //消息id
       * </pre>
       *
       * <code>.AuthResponse.ResponseCode code = 2;</code>
       * @return The enum numeric value on the wire for code.
       */
      @Override public int getCodeValue() {
        return code_;
      }
      /**
       * <pre>
       *int64 m_id        = 1;  //消息id
       * </pre>
       *
       * <code>.AuthResponse.ResponseCode code = 2;</code>
       * @param value The enum numeric value on the wire for code to set.
       * @return This builder for chaining.
       */
      public Builder setCodeValue(int value) {
        
        code_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       *int64 m_id        = 1;  //消息id
       * </pre>
       *
       * <code>.AuthResponse.ResponseCode code = 2;</code>
       * @return The code.
       */
      @Override
      public ResponseCode getCode() {
        @SuppressWarnings("deprecation")
        ResponseCode result = ResponseCode.valueOf(code_);
        return result == null ? ResponseCode.UNRECOGNIZED : result;
      }
      /**
       * <pre>
       *int64 m_id        = 1;  //消息id
       * </pre>
       *
       * <code>.AuthResponse.ResponseCode code = 2;</code>
       * @param value The code to set.
       * @return This builder for chaining.
       */
      public Builder setCode(ResponseCode value) {
        if (value == null) {
          throw new NullPointerException();
        }
        
        code_ = value.getNumber();
        onChanged();
        return this;
      }
      /**
       * <pre>
       *int64 m_id        = 1;  //消息id
       * </pre>
       *
       * <code>.AuthResponse.ResponseCode code = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearCode() {
        
        code_ = 0;
        onChanged();
        return this;
      }

      private Object authUrl_ = "";
      /**
       * <pre>
       *登陆url
       * </pre>
       *
       * <code>string auth_url = 3;</code>
       * @return The authUrl.
       */
      public String getAuthUrl() {
        Object ref = authUrl_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          authUrl_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <pre>
       *登陆url
       * </pre>
       *
       * <code>string auth_url = 3;</code>
       * @return The bytes for authUrl.
       */
      public com.google.protobuf.ByteString
          getAuthUrlBytes() {
        Object ref = authUrl_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          authUrl_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <pre>
       *登陆url
       * </pre>
       *
       * <code>string auth_url = 3;</code>
       * @param value The authUrl to set.
       * @return This builder for chaining.
       */
      public Builder setAuthUrl(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        authUrl_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       *登陆url
       * </pre>
       *
       * <code>string auth_url = 3;</code>
       * @return This builder for chaining.
       */
      public Builder clearAuthUrl() {
        
        authUrl_ = getDefaultInstance().getAuthUrl();
        onChanged();
        return this;
      }
      /**
       * <pre>
       *登陆url
       * </pre>
       *
       * <code>string auth_url = 3;</code>
       * @param value The bytes for authUrl to set.
       * @return This builder for chaining.
       */
      public Builder setAuthUrlBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        authUrl_ = value;
        onChanged();
        return this;
      }
      @Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:AuthResponse)
    }

    // @@protoc_insertion_point(class_scope:AuthResponse)
    private static final AuthResponse DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new AuthResponse();
    }

    public static AuthResponse getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<AuthResponse>
        PARSER = new com.google.protobuf.AbstractParser<AuthResponse>() {
      @Override
      public AuthResponse parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new AuthResponse(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<AuthResponse> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<AuthResponse> getParserForType() {
      return PARSER;
    }

    @Override
    public AuthResponse getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_AuthResponse_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_AuthResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\022AuthResponse.proto\"n\n\014AuthResponse\022(\n\004" +
      "code\030\002 \001(\0162\032.AuthResponse.ResponseCode\022\020" +
      "\n\010auth_url\030\003 \001(\t\"\"\n\014ResponseCode\022\n\n\006FAIL" +
      "ED\020\000\022\006\n\002OK\020\001B\023B\021AuthResponseProtob\006proto" +
      "3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_AuthResponse_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_AuthResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_AuthResponse_descriptor,
        new String[] { "Code", "AuthUrl", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
