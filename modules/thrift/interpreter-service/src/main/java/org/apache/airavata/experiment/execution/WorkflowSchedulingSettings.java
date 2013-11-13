/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.airavata.experiment.execution;

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

public class WorkflowSchedulingSettings implements org.apache.thrift.TBase<WorkflowSchedulingSettings, WorkflowSchedulingSettings._Fields>, java.io.Serializable, Cloneable, Comparable<WorkflowSchedulingSettings> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("WorkflowSchedulingSettings");

  private static final org.apache.thrift.protocol.TField NODE_SETTINGS_LIST_FIELD_DESC = new org.apache.thrift.protocol.TField("nodeSettingsList", org.apache.thrift.protocol.TType.LIST, (short)1);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new WorkflowSchedulingSettingsStandardSchemeFactory());
    schemes.put(TupleScheme.class, new WorkflowSchedulingSettingsTupleSchemeFactory());
  }

  public List<NodeSettings> nodeSettingsList; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    NODE_SETTINGS_LIST((short)1, "nodeSettingsList");

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
        case 1: // NODE_SETTINGS_LIST
          return NODE_SETTINGS_LIST;
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
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.NODE_SETTINGS_LIST, new org.apache.thrift.meta_data.FieldMetaData("nodeSettingsList", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, NodeSettings.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(WorkflowSchedulingSettings.class, metaDataMap);
  }

  public WorkflowSchedulingSettings() {
  }

  public WorkflowSchedulingSettings(
    List<NodeSettings> nodeSettingsList)
  {
    this();
    this.nodeSettingsList = nodeSettingsList;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public WorkflowSchedulingSettings(WorkflowSchedulingSettings other) {
    if (other.isSetNodeSettingsList()) {
      List<NodeSettings> __this__nodeSettingsList = new ArrayList<NodeSettings>(other.nodeSettingsList.size());
      for (NodeSettings other_element : other.nodeSettingsList) {
        __this__nodeSettingsList.add(new NodeSettings(other_element));
      }
      this.nodeSettingsList = __this__nodeSettingsList;
    }
  }

  public WorkflowSchedulingSettings deepCopy() {
    return new WorkflowSchedulingSettings(this);
  }

  @Override
  public void clear() {
    this.nodeSettingsList = null;
  }

  public int getNodeSettingsListSize() {
    return (this.nodeSettingsList == null) ? 0 : this.nodeSettingsList.size();
  }

  public java.util.Iterator<NodeSettings> getNodeSettingsListIterator() {
    return (this.nodeSettingsList == null) ? null : this.nodeSettingsList.iterator();
  }

  public void addToNodeSettingsList(NodeSettings elem) {
    if (this.nodeSettingsList == null) {
      this.nodeSettingsList = new ArrayList<NodeSettings>();
    }
    this.nodeSettingsList.add(elem);
  }

  public List<NodeSettings> getNodeSettingsList() {
    return this.nodeSettingsList;
  }

  public WorkflowSchedulingSettings setNodeSettingsList(List<NodeSettings> nodeSettingsList) {
    this.nodeSettingsList = nodeSettingsList;
    return this;
  }

  public void unsetNodeSettingsList() {
    this.nodeSettingsList = null;
  }

  /** Returns true if field nodeSettingsList is set (has been assigned a value) and false otherwise */
  public boolean isSetNodeSettingsList() {
    return this.nodeSettingsList != null;
  }

  public void setNodeSettingsListIsSet(boolean value) {
    if (!value) {
      this.nodeSettingsList = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case NODE_SETTINGS_LIST:
      if (value == null) {
        unsetNodeSettingsList();
      } else {
        setNodeSettingsList((List<NodeSettings>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case NODE_SETTINGS_LIST:
      return getNodeSettingsList();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case NODE_SETTINGS_LIST:
      return isSetNodeSettingsList();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof WorkflowSchedulingSettings)
      return this.equals((WorkflowSchedulingSettings)that);
    return false;
  }

  public boolean equals(WorkflowSchedulingSettings that) {
    if (that == null)
      return false;

    boolean this_present_nodeSettingsList = true && this.isSetNodeSettingsList();
    boolean that_present_nodeSettingsList = true && that.isSetNodeSettingsList();
    if (this_present_nodeSettingsList || that_present_nodeSettingsList) {
      if (!(this_present_nodeSettingsList && that_present_nodeSettingsList))
        return false;
      if (!this.nodeSettingsList.equals(that.nodeSettingsList))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(WorkflowSchedulingSettings other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetNodeSettingsList()).compareTo(other.isSetNodeSettingsList());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNodeSettingsList()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.nodeSettingsList, other.nodeSettingsList);
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
    StringBuilder sb = new StringBuilder("WorkflowSchedulingSettings(");
    boolean first = true;

    sb.append("nodeSettingsList:");
    if (this.nodeSettingsList == null) {
      sb.append("null");
    } else {
      sb.append(this.nodeSettingsList);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
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
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class WorkflowSchedulingSettingsStandardSchemeFactory implements SchemeFactory {
    public WorkflowSchedulingSettingsStandardScheme getScheme() {
      return new WorkflowSchedulingSettingsStandardScheme();
    }
  }

  private static class WorkflowSchedulingSettingsStandardScheme extends StandardScheme<WorkflowSchedulingSettings> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, WorkflowSchedulingSettings struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // NODE_SETTINGS_LIST
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list8 = iprot.readListBegin();
                struct.nodeSettingsList = new ArrayList<NodeSettings>(_list8.size);
                for (int _i9 = 0; _i9 < _list8.size; ++_i9)
                {
                  NodeSettings _elem10;
                  _elem10 = new NodeSettings();
                  _elem10.read(iprot);
                  struct.nodeSettingsList.add(_elem10);
                }
                iprot.readListEnd();
              }
              struct.setNodeSettingsListIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, WorkflowSchedulingSettings struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.nodeSettingsList != null) {
        oprot.writeFieldBegin(NODE_SETTINGS_LIST_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.nodeSettingsList.size()));
          for (NodeSettings _iter11 : struct.nodeSettingsList)
          {
            _iter11.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class WorkflowSchedulingSettingsTupleSchemeFactory implements SchemeFactory {
    public WorkflowSchedulingSettingsTupleScheme getScheme() {
      return new WorkflowSchedulingSettingsTupleScheme();
    }
  }

  private static class WorkflowSchedulingSettingsTupleScheme extends TupleScheme<WorkflowSchedulingSettings> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, WorkflowSchedulingSettings struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetNodeSettingsList()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetNodeSettingsList()) {
        {
          oprot.writeI32(struct.nodeSettingsList.size());
          for (NodeSettings _iter12 : struct.nodeSettingsList)
          {
            _iter12.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, WorkflowSchedulingSettings struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list13 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.nodeSettingsList = new ArrayList<NodeSettings>(_list13.size);
          for (int _i14 = 0; _i14 < _list13.size; ++_i14)
          {
            NodeSettings _elem15;
            _elem15 = new NodeSettings();
            _elem15.read(iprot);
            struct.nodeSettingsList.add(_elem15);
          }
        }
        struct.setNodeSettingsListIsSet(true);
      }
    }
  }

}
