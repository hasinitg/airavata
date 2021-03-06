    /*
     * Licensed to the Apache Software Foundation (ASF) under one or more
     * contributor license agreements.  See the NOTICE file distributed with
     * this work for additional information regarding copyright ownership.
     * The ASF licenses this file to You under the Apache License, Version 2.0
     * (the "License"); you may not use this file except in compliance with
     * the License.  You may obtain a copy of the License at
     *
     *     http://www.apache.org/licenses/LICENSE-2.0
     *
     * Unless required by applicable law or agreed to in writing, software
     * distributed under the License is distributed on an "AS IS" BASIS,
     * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
     * See the License for the specific language governing permissions and
     * limitations under the License.
     */
/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.airavata.credential.store.datamodel;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("all") public class SSHCredential implements org.apache.thrift.TBase<SSHCredential, SSHCredential._Fields>, java.io.Serializable, Cloneable, Comparable<SSHCredential> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("SSHCredential");

  private static final org.apache.thrift.protocol.TField GATEWAY_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("gatewayId", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField USERNAME_FIELD_DESC = new org.apache.thrift.protocol.TField("username", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField PASSPHRASE_FIELD_DESC = new org.apache.thrift.protocol.TField("passphrase", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField PUBLIC_KEY_FIELD_DESC = new org.apache.thrift.protocol.TField("publicKey", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField PRIVATE_KEY_FIELD_DESC = new org.apache.thrift.protocol.TField("privateKey", org.apache.thrift.protocol.TType.STRING, (short)5);
  private static final org.apache.thrift.protocol.TField PERSISTED_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField("persistedTime", org.apache.thrift.protocol.TType.I64, (short)6);
  private static final org.apache.thrift.protocol.TField TOKEN_FIELD_DESC = new org.apache.thrift.protocol.TField("token", org.apache.thrift.protocol.TType.STRING, (short)7);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new SSHCredentialStandardSchemeFactory());
    schemes.put(TupleScheme.class, new SSHCredentialTupleSchemeFactory());
  }

  public String gatewayId; // required
  public String username; // required
  public String passphrase; // required
  public String publicKey; // optional
  public String privateKey; // optional
  public long persistedTime; // optional
  public String token; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  @SuppressWarnings("all") public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    GATEWAY_ID((short)1, "gatewayId"),
    USERNAME((short)2, "username"),
    PASSPHRASE((short)3, "passphrase"),
    PUBLIC_KEY((short)4, "publicKey"),
    PRIVATE_KEY((short)5, "privateKey"),
    PERSISTED_TIME((short)6, "persistedTime"),
    TOKEN((short)7, "token");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // GATEWAY_ID
          return GATEWAY_ID;
        case 2: // USERNAME
          return USERNAME;
        case 3: // PASSPHRASE
          return PASSPHRASE;
        case 4: // PUBLIC_KEY
          return PUBLIC_KEY;
        case 5: // PRIVATE_KEY
          return PRIVATE_KEY;
        case 6: // PERSISTED_TIME
          return PERSISTED_TIME;
        case 7: // TOKEN
          return TOKEN;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __PERSISTEDTIME_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private _Fields optionals[] = {_Fields.PUBLIC_KEY,_Fields.PRIVATE_KEY,_Fields.PERSISTED_TIME,_Fields.TOKEN};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.GATEWAY_ID, new org.apache.thrift.meta_data.FieldMetaData("gatewayId", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.USERNAME, new org.apache.thrift.meta_data.FieldMetaData("username", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PASSPHRASE, new org.apache.thrift.meta_data.FieldMetaData("passphrase", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PUBLIC_KEY, new org.apache.thrift.meta_data.FieldMetaData("publicKey", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PRIVATE_KEY, new org.apache.thrift.meta_data.FieldMetaData("privateKey", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PERSISTED_TIME, new org.apache.thrift.meta_data.FieldMetaData("persistedTime", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.TOKEN, new org.apache.thrift.meta_data.FieldMetaData("token", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(SSHCredential.class, metaDataMap);
  }

  public SSHCredential() {
  }

  public SSHCredential(
    String gatewayId,
    String username,
    String passphrase)
  {
    this();
    this.gatewayId = gatewayId;
    this.username = username;
    this.passphrase = passphrase;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public SSHCredential(SSHCredential other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetGatewayId()) {
      this.gatewayId = other.gatewayId;
    }
    if (other.isSetUsername()) {
      this.username = other.username;
    }
    if (other.isSetPassphrase()) {
      this.passphrase = other.passphrase;
    }
    if (other.isSetPublicKey()) {
      this.publicKey = other.publicKey;
    }
    if (other.isSetPrivateKey()) {
      this.privateKey = other.privateKey;
    }
    this.persistedTime = other.persistedTime;
    if (other.isSetToken()) {
      this.token = other.token;
    }
  }

  public SSHCredential deepCopy() {
    return new SSHCredential(this);
  }

  @Override
  public void clear() {
    this.gatewayId = null;
    this.username = null;
    this.passphrase = null;
    this.publicKey = null;
    this.privateKey = null;
    setPersistedTimeIsSet(false);
    this.persistedTime = 0;
    this.token = null;
  }

  public String getGatewayId() {
    return this.gatewayId;
  }

  public SSHCredential setGatewayId(String gatewayId) {
    this.gatewayId = gatewayId;
    return this;
  }

  public void unsetGatewayId() {
    this.gatewayId = null;
  }

  /** Returns true if field gatewayId is set (has been assigned a value) and false otherwise */
  public boolean isSetGatewayId() {
    return this.gatewayId != null;
  }

  public void setGatewayIdIsSet(boolean value) {
    if (!value) {
      this.gatewayId = null;
    }
  }

  public String getUsername() {
    return this.username;
  }

  public SSHCredential setUsername(String username) {
    this.username = username;
    return this;
  }

  public void unsetUsername() {
    this.username = null;
  }

  /** Returns true if field username is set (has been assigned a value) and false otherwise */
  public boolean isSetUsername() {
    return this.username != null;
  }

  public void setUsernameIsSet(boolean value) {
    if (!value) {
      this.username = null;
    }
  }

  public String getPassphrase() {
    return this.passphrase;
  }

  public SSHCredential setPassphrase(String passphrase) {
    this.passphrase = passphrase;
    return this;
  }

  public void unsetPassphrase() {
    this.passphrase = null;
  }

  /** Returns true if field passphrase is set (has been assigned a value) and false otherwise */
  public boolean isSetPassphrase() {
    return this.passphrase != null;
  }

  public void setPassphraseIsSet(boolean value) {
    if (!value) {
      this.passphrase = null;
    }
  }

  public String getPublicKey() {
    return this.publicKey;
  }

  public SSHCredential setPublicKey(String publicKey) {
    this.publicKey = publicKey;
    return this;
  }

  public void unsetPublicKey() {
    this.publicKey = null;
  }

  /** Returns true if field publicKey is set (has been assigned a value) and false otherwise */
  public boolean isSetPublicKey() {
    return this.publicKey != null;
  }

  public void setPublicKeyIsSet(boolean value) {
    if (!value) {
      this.publicKey = null;
    }
  }

  public String getPrivateKey() {
    return this.privateKey;
  }

  public SSHCredential setPrivateKey(String privateKey) {
    this.privateKey = privateKey;
    return this;
  }

  public void unsetPrivateKey() {
    this.privateKey = null;
  }

  /** Returns true if field privateKey is set (has been assigned a value) and false otherwise */
  public boolean isSetPrivateKey() {
    return this.privateKey != null;
  }

  public void setPrivateKeyIsSet(boolean value) {
    if (!value) {
      this.privateKey = null;
    }
  }

  public long getPersistedTime() {
    return this.persistedTime;
  }

  public SSHCredential setPersistedTime(long persistedTime) {
    this.persistedTime = persistedTime;
    setPersistedTimeIsSet(true);
    return this;
  }

  public void unsetPersistedTime() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __PERSISTEDTIME_ISSET_ID);
  }

  /** Returns true if field persistedTime is set (has been assigned a value) and false otherwise */
  public boolean isSetPersistedTime() {
    return EncodingUtils.testBit(__isset_bitfield, __PERSISTEDTIME_ISSET_ID);
  }

  public void setPersistedTimeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __PERSISTEDTIME_ISSET_ID, value);
  }

  public String getToken() {
    return this.token;
  }

  public SSHCredential setToken(String token) {
    this.token = token;
    return this;
  }

  public void unsetToken() {
    this.token = null;
  }

  /** Returns true if field token is set (has been assigned a value) and false otherwise */
  public boolean isSetToken() {
    return this.token != null;
  }

  public void setTokenIsSet(boolean value) {
    if (!value) {
      this.token = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case GATEWAY_ID:
      if (value == null) {
        unsetGatewayId();
      } else {
        setGatewayId((String)value);
      }
      break;

    case USERNAME:
      if (value == null) {
        unsetUsername();
      } else {
        setUsername((String)value);
      }
      break;

    case PASSPHRASE:
      if (value == null) {
        unsetPassphrase();
      } else {
        setPassphrase((String)value);
      }
      break;

    case PUBLIC_KEY:
      if (value == null) {
        unsetPublicKey();
      } else {
        setPublicKey((String)value);
      }
      break;

    case PRIVATE_KEY:
      if (value == null) {
        unsetPrivateKey();
      } else {
        setPrivateKey((String)value);
      }
      break;

    case PERSISTED_TIME:
      if (value == null) {
        unsetPersistedTime();
      } else {
        setPersistedTime((Long)value);
      }
      break;

    case TOKEN:
      if (value == null) {
        unsetToken();
      } else {
        setToken((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case GATEWAY_ID:
      return getGatewayId();

    case USERNAME:
      return getUsername();

    case PASSPHRASE:
      return getPassphrase();

    case PUBLIC_KEY:
      return getPublicKey();

    case PRIVATE_KEY:
      return getPrivateKey();

    case PERSISTED_TIME:
      return Long.valueOf(getPersistedTime());

    case TOKEN:
      return getToken();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case GATEWAY_ID:
      return isSetGatewayId();
    case USERNAME:
      return isSetUsername();
    case PASSPHRASE:
      return isSetPassphrase();
    case PUBLIC_KEY:
      return isSetPublicKey();
    case PRIVATE_KEY:
      return isSetPrivateKey();
    case PERSISTED_TIME:
      return isSetPersistedTime();
    case TOKEN:
      return isSetToken();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof SSHCredential)
      return this.equals((SSHCredential)that);
    return false;
  }

  public boolean equals(SSHCredential that) {
    if (that == null)
      return false;

    boolean this_present_gatewayId = true && this.isSetGatewayId();
    boolean that_present_gatewayId = true && that.isSetGatewayId();
    if (this_present_gatewayId || that_present_gatewayId) {
      if (!(this_present_gatewayId && that_present_gatewayId))
        return false;
      if (!this.gatewayId.equals(that.gatewayId))
        return false;
    }

    boolean this_present_username = true && this.isSetUsername();
    boolean that_present_username = true && that.isSetUsername();
    if (this_present_username || that_present_username) {
      if (!(this_present_username && that_present_username))
        return false;
      if (!this.username.equals(that.username))
        return false;
    }

    boolean this_present_passphrase = true && this.isSetPassphrase();
    boolean that_present_passphrase = true && that.isSetPassphrase();
    if (this_present_passphrase || that_present_passphrase) {
      if (!(this_present_passphrase && that_present_passphrase))
        return false;
      if (!this.passphrase.equals(that.passphrase))
        return false;
    }

    boolean this_present_publicKey = true && this.isSetPublicKey();
    boolean that_present_publicKey = true && that.isSetPublicKey();
    if (this_present_publicKey || that_present_publicKey) {
      if (!(this_present_publicKey && that_present_publicKey))
        return false;
      if (!this.publicKey.equals(that.publicKey))
        return false;
    }

    boolean this_present_privateKey = true && this.isSetPrivateKey();
    boolean that_present_privateKey = true && that.isSetPrivateKey();
    if (this_present_privateKey || that_present_privateKey) {
      if (!(this_present_privateKey && that_present_privateKey))
        return false;
      if (!this.privateKey.equals(that.privateKey))
        return false;
    }

    boolean this_present_persistedTime = true && this.isSetPersistedTime();
    boolean that_present_persistedTime = true && that.isSetPersistedTime();
    if (this_present_persistedTime || that_present_persistedTime) {
      if (!(this_present_persistedTime && that_present_persistedTime))
        return false;
      if (this.persistedTime != that.persistedTime)
        return false;
    }

    boolean this_present_token = true && this.isSetToken();
    boolean that_present_token = true && that.isSetToken();
    if (this_present_token || that_present_token) {
      if (!(this_present_token && that_present_token))
        return false;
      if (!this.token.equals(that.token))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(SSHCredential other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetGatewayId()).compareTo(other.isSetGatewayId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetGatewayId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.gatewayId, other.gatewayId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUsername()).compareTo(other.isSetUsername());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUsername()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.username, other.username);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPassphrase()).compareTo(other.isSetPassphrase());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPassphrase()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.passphrase, other.passphrase);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPublicKey()).compareTo(other.isSetPublicKey());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPublicKey()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.publicKey, other.publicKey);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPrivateKey()).compareTo(other.isSetPrivateKey());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPrivateKey()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.privateKey, other.privateKey);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPersistedTime()).compareTo(other.isSetPersistedTime());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPersistedTime()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.persistedTime, other.persistedTime);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetToken()).compareTo(other.isSetToken());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetToken()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.token, other.token);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("SSHCredential(");
    boolean first = true;

    sb.append("gatewayId:");
    if (this.gatewayId == null) {
      sb.append("null");
    } else {
      sb.append(this.gatewayId);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("username:");
    if (this.username == null) {
      sb.append("null");
    } else {
      sb.append(this.username);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("passphrase:");
    if (this.passphrase == null) {
      sb.append("null");
    } else {
      sb.append(this.passphrase);
    }
    first = false;
    if (isSetPublicKey()) {
      if (!first) sb.append(", ");
      sb.append("publicKey:");
      if (this.publicKey == null) {
        sb.append("null");
      } else {
        sb.append(this.publicKey);
      }
      first = false;
    }
    if (isSetPrivateKey()) {
      if (!first) sb.append(", ");
      sb.append("privateKey:");
      if (this.privateKey == null) {
        sb.append("null");
      } else {
        sb.append(this.privateKey);
      }
      first = false;
    }
    if (isSetPersistedTime()) {
      if (!first) sb.append(", ");
      sb.append("persistedTime:");
      sb.append(this.persistedTime);
      first = false;
    }
    if (isSetToken()) {
      if (!first) sb.append(", ");
      sb.append("token:");
      if (this.token == null) {
        sb.append("null");
      } else {
        sb.append(this.token);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (gatewayId == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'gatewayId' was not present! Struct: " + toString());
    }
    if (username == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'username' was not present! Struct: " + toString());
    }
    if (passphrase == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'passphrase' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class SSHCredentialStandardSchemeFactory implements SchemeFactory {
    public SSHCredentialStandardScheme getScheme() {
      return new SSHCredentialStandardScheme();
    }
  }

  private static class SSHCredentialStandardScheme extends StandardScheme<SSHCredential> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, SSHCredential struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // GATEWAY_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.gatewayId = iprot.readString();
              struct.setGatewayIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // USERNAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.username = iprot.readString();
              struct.setUsernameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // PASSPHRASE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.passphrase = iprot.readString();
              struct.setPassphraseIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // PUBLIC_KEY
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.publicKey = iprot.readString();
              struct.setPublicKeyIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // PRIVATE_KEY
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.privateKey = iprot.readString();
              struct.setPrivateKeyIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // PERSISTED_TIME
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.persistedTime = iprot.readI64();
              struct.setPersistedTimeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // TOKEN
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.token = iprot.readString();
              struct.setTokenIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, SSHCredential struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.gatewayId != null) {
        oprot.writeFieldBegin(GATEWAY_ID_FIELD_DESC);
        oprot.writeString(struct.gatewayId);
        oprot.writeFieldEnd();
      }
      if (struct.username != null) {
        oprot.writeFieldBegin(USERNAME_FIELD_DESC);
        oprot.writeString(struct.username);
        oprot.writeFieldEnd();
      }
      if (struct.passphrase != null) {
        oprot.writeFieldBegin(PASSPHRASE_FIELD_DESC);
        oprot.writeString(struct.passphrase);
        oprot.writeFieldEnd();
      }
      if (struct.publicKey != null) {
        if (struct.isSetPublicKey()) {
          oprot.writeFieldBegin(PUBLIC_KEY_FIELD_DESC);
          oprot.writeString(struct.publicKey);
          oprot.writeFieldEnd();
        }
      }
      if (struct.privateKey != null) {
        if (struct.isSetPrivateKey()) {
          oprot.writeFieldBegin(PRIVATE_KEY_FIELD_DESC);
          oprot.writeString(struct.privateKey);
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetPersistedTime()) {
        oprot.writeFieldBegin(PERSISTED_TIME_FIELD_DESC);
        oprot.writeI64(struct.persistedTime);
        oprot.writeFieldEnd();
      }
      if (struct.token != null) {
        if (struct.isSetToken()) {
          oprot.writeFieldBegin(TOKEN_FIELD_DESC);
          oprot.writeString(struct.token);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class SSHCredentialTupleSchemeFactory implements SchemeFactory {
    public SSHCredentialTupleScheme getScheme() {
      return new SSHCredentialTupleScheme();
    }
  }

  private static class SSHCredentialTupleScheme extends TupleScheme<SSHCredential> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, SSHCredential struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeString(struct.gatewayId);
      oprot.writeString(struct.username);
      oprot.writeString(struct.passphrase);
      BitSet optionals = new BitSet();
      if (struct.isSetPublicKey()) {
        optionals.set(0);
      }
      if (struct.isSetPrivateKey()) {
        optionals.set(1);
      }
      if (struct.isSetPersistedTime()) {
        optionals.set(2);
      }
      if (struct.isSetToken()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetPublicKey()) {
        oprot.writeString(struct.publicKey);
      }
      if (struct.isSetPrivateKey()) {
        oprot.writeString(struct.privateKey);
      }
      if (struct.isSetPersistedTime()) {
        oprot.writeI64(struct.persistedTime);
      }
      if (struct.isSetToken()) {
        oprot.writeString(struct.token);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, SSHCredential struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.gatewayId = iprot.readString();
      struct.setGatewayIdIsSet(true);
      struct.username = iprot.readString();
      struct.setUsernameIsSet(true);
      struct.passphrase = iprot.readString();
      struct.setPassphraseIsSet(true);
      BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.publicKey = iprot.readString();
        struct.setPublicKeyIsSet(true);
      }
      if (incoming.get(1)) {
        struct.privateKey = iprot.readString();
        struct.setPrivateKeyIsSet(true);
      }
      if (incoming.get(2)) {
        struct.persistedTime = iprot.readI64();
        struct.setPersistedTimeIsSet(true);
      }
      if (incoming.get(3)) {
        struct.token = iprot.readString();
        struct.setTokenIsSet(true);
      }
    }
  }

}

