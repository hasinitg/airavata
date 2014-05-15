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
package org.apache.airavata.model.appcatalog;

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

@SuppressWarnings("all") public class GSISSHJobSubmission implements org.apache.thrift.TBase<GSISSHJobSubmission, GSISSHJobSubmission._Fields>, java.io.Serializable, Cloneable, Comparable<GSISSHJobSubmission> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("GSISSHJobSubmission");

  private static final org.apache.thrift.protocol.TField RESOURCE_JOB_MANAGER_FIELD_DESC = new org.apache.thrift.protocol.TField("resourceJobManager", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField SSH_PORT_FIELD_DESC = new org.apache.thrift.protocol.TField("sshPort", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField EXPORTS_FIELD_DESC = new org.apache.thrift.protocol.TField("exports", org.apache.thrift.protocol.TType.SET, (short)4);
  private static final org.apache.thrift.protocol.TField PRE_JOB_COMMANDS_FIELD_DESC = new org.apache.thrift.protocol.TField("preJobCommands", org.apache.thrift.protocol.TType.LIST, (short)5);
  private static final org.apache.thrift.protocol.TField POST_JOB_COMMANDS_FIELD_DESC = new org.apache.thrift.protocol.TField("postJobCommands", org.apache.thrift.protocol.TType.LIST, (short)6);
  private static final org.apache.thrift.protocol.TField INSTALLED_PATH_FIELD_DESC = new org.apache.thrift.protocol.TField("installedPath", org.apache.thrift.protocol.TType.STRING, (short)7);
  private static final org.apache.thrift.protocol.TField MONITOR_MODE_FIELD_DESC = new org.apache.thrift.protocol.TField("monitorMode", org.apache.thrift.protocol.TType.STRING, (short)8);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new GSISSHJobSubmissionStandardSchemeFactory());
    schemes.put(TupleScheme.class, new GSISSHJobSubmissionTupleSchemeFactory());
  }

  private ResourceJobManager resourceJobManager; // required
  private int sshPort; // optional
  private Set<String> exports; // optional
  private List<String> preJobCommands; // optional
  private List<String> postJobCommands; // optional
  private String installedPath; // optional
  private String monitorMode; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  @SuppressWarnings("all") public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 
     * @see ResourceJobManager
     */
    RESOURCE_JOB_MANAGER((short)2, "resourceJobManager"),
    SSH_PORT((short)3, "sshPort"),
    EXPORTS((short)4, "exports"),
    PRE_JOB_COMMANDS((short)5, "preJobCommands"),
    POST_JOB_COMMANDS((short)6, "postJobCommands"),
    INSTALLED_PATH((short)7, "installedPath"),
    MONITOR_MODE((short)8, "monitorMode");

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
        case 2: // RESOURCE_JOB_MANAGER
          return RESOURCE_JOB_MANAGER;
        case 3: // SSH_PORT
          return SSH_PORT;
        case 4: // EXPORTS
          return EXPORTS;
        case 5: // PRE_JOB_COMMANDS
          return PRE_JOB_COMMANDS;
        case 6: // POST_JOB_COMMANDS
          return POST_JOB_COMMANDS;
        case 7: // INSTALLED_PATH
          return INSTALLED_PATH;
        case 8: // MONITOR_MODE
          return MONITOR_MODE;
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
  private static final int __SSHPORT_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private _Fields optionals[] = {_Fields.SSH_PORT,_Fields.EXPORTS,_Fields.PRE_JOB_COMMANDS,_Fields.POST_JOB_COMMANDS,_Fields.INSTALLED_PATH,_Fields.MONITOR_MODE};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.RESOURCE_JOB_MANAGER, new org.apache.thrift.meta_data.FieldMetaData("resourceJobManager", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, ResourceJobManager.class)));
    tmpMap.put(_Fields.SSH_PORT, new org.apache.thrift.meta_data.FieldMetaData("sshPort", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.EXPORTS, new org.apache.thrift.meta_data.FieldMetaData("exports", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.SetMetaData(org.apache.thrift.protocol.TType.SET, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.PRE_JOB_COMMANDS, new org.apache.thrift.meta_data.FieldMetaData("preJobCommands", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.POST_JOB_COMMANDS, new org.apache.thrift.meta_data.FieldMetaData("postJobCommands", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.INSTALLED_PATH, new org.apache.thrift.meta_data.FieldMetaData("installedPath", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.MONITOR_MODE, new org.apache.thrift.meta_data.FieldMetaData("monitorMode", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(GSISSHJobSubmission.class, metaDataMap);
  }

  public GSISSHJobSubmission() {
    this.sshPort = 22;

  }

  public GSISSHJobSubmission(
    ResourceJobManager resourceJobManager)
  {
    this();
    this.resourceJobManager = resourceJobManager;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public GSISSHJobSubmission(GSISSHJobSubmission other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetResourceJobManager()) {
      this.resourceJobManager = other.resourceJobManager;
    }
    this.sshPort = other.sshPort;
    if (other.isSetExports()) {
      Set<String> __this__exports = new HashSet<String>(other.exports);
      this.exports = __this__exports;
    }
    if (other.isSetPreJobCommands()) {
      List<String> __this__preJobCommands = new ArrayList<String>(other.preJobCommands);
      this.preJobCommands = __this__preJobCommands;
    }
    if (other.isSetPostJobCommands()) {
      List<String> __this__postJobCommands = new ArrayList<String>(other.postJobCommands);
      this.postJobCommands = __this__postJobCommands;
    }
    if (other.isSetInstalledPath()) {
      this.installedPath = other.installedPath;
    }
    if (other.isSetMonitorMode()) {
      this.monitorMode = other.monitorMode;
    }
  }

  public GSISSHJobSubmission deepCopy() {
    return new GSISSHJobSubmission(this);
  }

  @Override
  public void clear() {
    this.resourceJobManager = null;
    this.sshPort = 22;

    this.exports = null;
    this.preJobCommands = null;
    this.postJobCommands = null;
    this.installedPath = null;
    this.monitorMode = null;
  }

  /**
   * 
   * @see ResourceJobManager
   */
  public ResourceJobManager getResourceJobManager() {
    return this.resourceJobManager;
  }

  /**
   * 
   * @see ResourceJobManager
   */
  public void setResourceJobManager(ResourceJobManager resourceJobManager) {
    this.resourceJobManager = resourceJobManager;
  }

  public void unsetResourceJobManager() {
    this.resourceJobManager = null;
  }

  /** Returns true if field resourceJobManager is set (has been assigned a value) and false otherwise */
  public boolean isSetResourceJobManager() {
    return this.resourceJobManager != null;
  }

  public void setResourceJobManagerIsSet(boolean value) {
    if (!value) {
      this.resourceJobManager = null;
    }
  }

  public int getSshPort() {
    return this.sshPort;
  }

  public void setSshPort(int sshPort) {
    this.sshPort = sshPort;
    setSshPortIsSet(true);
  }

  public void unsetSshPort() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __SSHPORT_ISSET_ID);
  }

  /** Returns true if field sshPort is set (has been assigned a value) and false otherwise */
  public boolean isSetSshPort() {
    return EncodingUtils.testBit(__isset_bitfield, __SSHPORT_ISSET_ID);
  }

  public void setSshPortIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __SSHPORT_ISSET_ID, value);
  }

  public int getExportsSize() {
    return (this.exports == null) ? 0 : this.exports.size();
  }

  public java.util.Iterator<String> getExportsIterator() {
    return (this.exports == null) ? null : this.exports.iterator();
  }

  public void addToExports(String elem) {
    if (this.exports == null) {
      this.exports = new HashSet<String>();
    }
    this.exports.add(elem);
  }

  public Set<String> getExports() {
    return this.exports;
  }

  public void setExports(Set<String> exports) {
    this.exports = exports;
  }

  public void unsetExports() {
    this.exports = null;
  }

  /** Returns true if field exports is set (has been assigned a value) and false otherwise */
  public boolean isSetExports() {
    return this.exports != null;
  }

  public void setExportsIsSet(boolean value) {
    if (!value) {
      this.exports = null;
    }
  }

  public int getPreJobCommandsSize() {
    return (this.preJobCommands == null) ? 0 : this.preJobCommands.size();
  }

  public java.util.Iterator<String> getPreJobCommandsIterator() {
    return (this.preJobCommands == null) ? null : this.preJobCommands.iterator();
  }

  public void addToPreJobCommands(String elem) {
    if (this.preJobCommands == null) {
      this.preJobCommands = new ArrayList<String>();
    }
    this.preJobCommands.add(elem);
  }

  public List<String> getPreJobCommands() {
    return this.preJobCommands;
  }

  public void setPreJobCommands(List<String> preJobCommands) {
    this.preJobCommands = preJobCommands;
  }

  public void unsetPreJobCommands() {
    this.preJobCommands = null;
  }

  /** Returns true if field preJobCommands is set (has been assigned a value) and false otherwise */
  public boolean isSetPreJobCommands() {
    return this.preJobCommands != null;
  }

  public void setPreJobCommandsIsSet(boolean value) {
    if (!value) {
      this.preJobCommands = null;
    }
  }

  public int getPostJobCommandsSize() {
    return (this.postJobCommands == null) ? 0 : this.postJobCommands.size();
  }

  public java.util.Iterator<String> getPostJobCommandsIterator() {
    return (this.postJobCommands == null) ? null : this.postJobCommands.iterator();
  }

  public void addToPostJobCommands(String elem) {
    if (this.postJobCommands == null) {
      this.postJobCommands = new ArrayList<String>();
    }
    this.postJobCommands.add(elem);
  }

  public List<String> getPostJobCommands() {
    return this.postJobCommands;
  }

  public void setPostJobCommands(List<String> postJobCommands) {
    this.postJobCommands = postJobCommands;
  }

  public void unsetPostJobCommands() {
    this.postJobCommands = null;
  }

  /** Returns true if field postJobCommands is set (has been assigned a value) and false otherwise */
  public boolean isSetPostJobCommands() {
    return this.postJobCommands != null;
  }

  public void setPostJobCommandsIsSet(boolean value) {
    if (!value) {
      this.postJobCommands = null;
    }
  }

  public String getInstalledPath() {
    return this.installedPath;
  }

  public void setInstalledPath(String installedPath) {
    this.installedPath = installedPath;
  }

  public void unsetInstalledPath() {
    this.installedPath = null;
  }

  /** Returns true if field installedPath is set (has been assigned a value) and false otherwise */
  public boolean isSetInstalledPath() {
    return this.installedPath != null;
  }

  public void setInstalledPathIsSet(boolean value) {
    if (!value) {
      this.installedPath = null;
    }
  }

  public String getMonitorMode() {
    return this.monitorMode;
  }

  public void setMonitorMode(String monitorMode) {
    this.monitorMode = monitorMode;
  }

  public void unsetMonitorMode() {
    this.monitorMode = null;
  }

  /** Returns true if field monitorMode is set (has been assigned a value) and false otherwise */
  public boolean isSetMonitorMode() {
    return this.monitorMode != null;
  }

  public void setMonitorModeIsSet(boolean value) {
    if (!value) {
      this.monitorMode = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case RESOURCE_JOB_MANAGER:
      if (value == null) {
        unsetResourceJobManager();
      } else {
        setResourceJobManager((ResourceJobManager)value);
      }
      break;

    case SSH_PORT:
      if (value == null) {
        unsetSshPort();
      } else {
        setSshPort((Integer)value);
      }
      break;

    case EXPORTS:
      if (value == null) {
        unsetExports();
      } else {
        setExports((Set<String>)value);
      }
      break;

    case PRE_JOB_COMMANDS:
      if (value == null) {
        unsetPreJobCommands();
      } else {
        setPreJobCommands((List<String>)value);
      }
      break;

    case POST_JOB_COMMANDS:
      if (value == null) {
        unsetPostJobCommands();
      } else {
        setPostJobCommands((List<String>)value);
      }
      break;

    case INSTALLED_PATH:
      if (value == null) {
        unsetInstalledPath();
      } else {
        setInstalledPath((String)value);
      }
      break;

    case MONITOR_MODE:
      if (value == null) {
        unsetMonitorMode();
      } else {
        setMonitorMode((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case RESOURCE_JOB_MANAGER:
      return getResourceJobManager();

    case SSH_PORT:
      return Integer.valueOf(getSshPort());

    case EXPORTS:
      return getExports();

    case PRE_JOB_COMMANDS:
      return getPreJobCommands();

    case POST_JOB_COMMANDS:
      return getPostJobCommands();

    case INSTALLED_PATH:
      return getInstalledPath();

    case MONITOR_MODE:
      return getMonitorMode();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case RESOURCE_JOB_MANAGER:
      return isSetResourceJobManager();
    case SSH_PORT:
      return isSetSshPort();
    case EXPORTS:
      return isSetExports();
    case PRE_JOB_COMMANDS:
      return isSetPreJobCommands();
    case POST_JOB_COMMANDS:
      return isSetPostJobCommands();
    case INSTALLED_PATH:
      return isSetInstalledPath();
    case MONITOR_MODE:
      return isSetMonitorMode();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof GSISSHJobSubmission)
      return this.equals((GSISSHJobSubmission)that);
    return false;
  }

  public boolean equals(GSISSHJobSubmission that) {
    if (that == null)
      return false;

    boolean this_present_resourceJobManager = true && this.isSetResourceJobManager();
    boolean that_present_resourceJobManager = true && that.isSetResourceJobManager();
    if (this_present_resourceJobManager || that_present_resourceJobManager) {
      if (!(this_present_resourceJobManager && that_present_resourceJobManager))
        return false;
      if (!this.resourceJobManager.equals(that.resourceJobManager))
        return false;
    }

    boolean this_present_sshPort = true && this.isSetSshPort();
    boolean that_present_sshPort = true && that.isSetSshPort();
    if (this_present_sshPort || that_present_sshPort) {
      if (!(this_present_sshPort && that_present_sshPort))
        return false;
      if (this.sshPort != that.sshPort)
        return false;
    }

    boolean this_present_exports = true && this.isSetExports();
    boolean that_present_exports = true && that.isSetExports();
    if (this_present_exports || that_present_exports) {
      if (!(this_present_exports && that_present_exports))
        return false;
      if (!this.exports.equals(that.exports))
        return false;
    }

    boolean this_present_preJobCommands = true && this.isSetPreJobCommands();
    boolean that_present_preJobCommands = true && that.isSetPreJobCommands();
    if (this_present_preJobCommands || that_present_preJobCommands) {
      if (!(this_present_preJobCommands && that_present_preJobCommands))
        return false;
      if (!this.preJobCommands.equals(that.preJobCommands))
        return false;
    }

    boolean this_present_postJobCommands = true && this.isSetPostJobCommands();
    boolean that_present_postJobCommands = true && that.isSetPostJobCommands();
    if (this_present_postJobCommands || that_present_postJobCommands) {
      if (!(this_present_postJobCommands && that_present_postJobCommands))
        return false;
      if (!this.postJobCommands.equals(that.postJobCommands))
        return false;
    }

    boolean this_present_installedPath = true && this.isSetInstalledPath();
    boolean that_present_installedPath = true && that.isSetInstalledPath();
    if (this_present_installedPath || that_present_installedPath) {
      if (!(this_present_installedPath && that_present_installedPath))
        return false;
      if (!this.installedPath.equals(that.installedPath))
        return false;
    }

    boolean this_present_monitorMode = true && this.isSetMonitorMode();
    boolean that_present_monitorMode = true && that.isSetMonitorMode();
    if (this_present_monitorMode || that_present_monitorMode) {
      if (!(this_present_monitorMode && that_present_monitorMode))
        return false;
      if (!this.monitorMode.equals(that.monitorMode))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(GSISSHJobSubmission other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetResourceJobManager()).compareTo(other.isSetResourceJobManager());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetResourceJobManager()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.resourceJobManager, other.resourceJobManager);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSshPort()).compareTo(other.isSetSshPort());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSshPort()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sshPort, other.sshPort);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetExports()).compareTo(other.isSetExports());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetExports()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.exports, other.exports);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPreJobCommands()).compareTo(other.isSetPreJobCommands());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPreJobCommands()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.preJobCommands, other.preJobCommands);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPostJobCommands()).compareTo(other.isSetPostJobCommands());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPostJobCommands()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.postJobCommands, other.postJobCommands);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetInstalledPath()).compareTo(other.isSetInstalledPath());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetInstalledPath()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.installedPath, other.installedPath);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMonitorMode()).compareTo(other.isSetMonitorMode());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMonitorMode()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.monitorMode, other.monitorMode);
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
    StringBuilder sb = new StringBuilder("GSISSHJobSubmission(");
    boolean first = true;

    sb.append("resourceJobManager:");
    if (this.resourceJobManager == null) {
      sb.append("null");
    } else {
      sb.append(this.resourceJobManager);
    }
    first = false;
    if (isSetSshPort()) {
      if (!first) sb.append(", ");
      sb.append("sshPort:");
      sb.append(this.sshPort);
      first = false;
    }
    if (isSetExports()) {
      if (!first) sb.append(", ");
      sb.append("exports:");
      if (this.exports == null) {
        sb.append("null");
      } else {
        sb.append(this.exports);
      }
      first = false;
    }
    if (isSetPreJobCommands()) {
      if (!first) sb.append(", ");
      sb.append("preJobCommands:");
      if (this.preJobCommands == null) {
        sb.append("null");
      } else {
        sb.append(this.preJobCommands);
      }
      first = false;
    }
    if (isSetPostJobCommands()) {
      if (!first) sb.append(", ");
      sb.append("postJobCommands:");
      if (this.postJobCommands == null) {
        sb.append("null");
      } else {
        sb.append(this.postJobCommands);
      }
      first = false;
    }
    if (isSetInstalledPath()) {
      if (!first) sb.append(", ");
      sb.append("installedPath:");
      if (this.installedPath == null) {
        sb.append("null");
      } else {
        sb.append(this.installedPath);
      }
      first = false;
    }
    if (isSetMonitorMode()) {
      if (!first) sb.append(", ");
      sb.append("monitorMode:");
      if (this.monitorMode == null) {
        sb.append("null");
      } else {
        sb.append(this.monitorMode);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (!isSetResourceJobManager()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'resourceJobManager' is unset! Struct:" + toString());
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

  private static class GSISSHJobSubmissionStandardSchemeFactory implements SchemeFactory {
    public GSISSHJobSubmissionStandardScheme getScheme() {
      return new GSISSHJobSubmissionStandardScheme();
    }
  }

  private static class GSISSHJobSubmissionStandardScheme extends StandardScheme<GSISSHJobSubmission> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, GSISSHJobSubmission struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 2: // RESOURCE_JOB_MANAGER
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.resourceJobManager = ResourceJobManager.findByValue(iprot.readI32());
              struct.setResourceJobManagerIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // SSH_PORT
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.sshPort = iprot.readI32();
              struct.setSshPortIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // EXPORTS
            if (schemeField.type == org.apache.thrift.protocol.TType.SET) {
              {
                org.apache.thrift.protocol.TSet _set0 = iprot.readSetBegin();
                struct.exports = new HashSet<String>(2*_set0.size);
                for (int _i1 = 0; _i1 < _set0.size; ++_i1)
                {
                  String _elem2;
                  _elem2 = iprot.readString();
                  struct.exports.add(_elem2);
                }
                iprot.readSetEnd();
              }
              struct.setExportsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // PRE_JOB_COMMANDS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list3 = iprot.readListBegin();
                struct.preJobCommands = new ArrayList<String>(_list3.size);
                for (int _i4 = 0; _i4 < _list3.size; ++_i4)
                {
                  String _elem5;
                  _elem5 = iprot.readString();
                  struct.preJobCommands.add(_elem5);
                }
                iprot.readListEnd();
              }
              struct.setPreJobCommandsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // POST_JOB_COMMANDS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list6 = iprot.readListBegin();
                struct.postJobCommands = new ArrayList<String>(_list6.size);
                for (int _i7 = 0; _i7 < _list6.size; ++_i7)
                {
                  String _elem8;
                  _elem8 = iprot.readString();
                  struct.postJobCommands.add(_elem8);
                }
                iprot.readListEnd();
              }
              struct.setPostJobCommandsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // INSTALLED_PATH
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.installedPath = iprot.readString();
              struct.setInstalledPathIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 8: // MONITOR_MODE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.monitorMode = iprot.readString();
              struct.setMonitorModeIsSet(true);
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
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, GSISSHJobSubmission struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.resourceJobManager != null) {
        oprot.writeFieldBegin(RESOURCE_JOB_MANAGER_FIELD_DESC);
        oprot.writeI32(struct.resourceJobManager.getValue());
        oprot.writeFieldEnd();
      }
      if (struct.isSetSshPort()) {
        oprot.writeFieldBegin(SSH_PORT_FIELD_DESC);
        oprot.writeI32(struct.sshPort);
        oprot.writeFieldEnd();
      }
      if (struct.exports != null) {
        if (struct.isSetExports()) {
          oprot.writeFieldBegin(EXPORTS_FIELD_DESC);
          {
            oprot.writeSetBegin(new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.STRING, struct.exports.size()));
            for (String _iter9 : struct.exports)
            {
              oprot.writeString(_iter9);
            }
            oprot.writeSetEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.preJobCommands != null) {
        if (struct.isSetPreJobCommands()) {
          oprot.writeFieldBegin(PRE_JOB_COMMANDS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.preJobCommands.size()));
            for (String _iter10 : struct.preJobCommands)
            {
              oprot.writeString(_iter10);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.postJobCommands != null) {
        if (struct.isSetPostJobCommands()) {
          oprot.writeFieldBegin(POST_JOB_COMMANDS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.postJobCommands.size()));
            for (String _iter11 : struct.postJobCommands)
            {
              oprot.writeString(_iter11);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.installedPath != null) {
        if (struct.isSetInstalledPath()) {
          oprot.writeFieldBegin(INSTALLED_PATH_FIELD_DESC);
          oprot.writeString(struct.installedPath);
          oprot.writeFieldEnd();
        }
      }
      if (struct.monitorMode != null) {
        if (struct.isSetMonitorMode()) {
          oprot.writeFieldBegin(MONITOR_MODE_FIELD_DESC);
          oprot.writeString(struct.monitorMode);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class GSISSHJobSubmissionTupleSchemeFactory implements SchemeFactory {
    public GSISSHJobSubmissionTupleScheme getScheme() {
      return new GSISSHJobSubmissionTupleScheme();
    }
  }

  private static class GSISSHJobSubmissionTupleScheme extends TupleScheme<GSISSHJobSubmission> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, GSISSHJobSubmission struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.resourceJobManager.getValue());
      BitSet optionals = new BitSet();
      if (struct.isSetSshPort()) {
        optionals.set(0);
      }
      if (struct.isSetExports()) {
        optionals.set(1);
      }
      if (struct.isSetPreJobCommands()) {
        optionals.set(2);
      }
      if (struct.isSetPostJobCommands()) {
        optionals.set(3);
      }
      if (struct.isSetInstalledPath()) {
        optionals.set(4);
      }
      if (struct.isSetMonitorMode()) {
        optionals.set(5);
      }
      oprot.writeBitSet(optionals, 6);
      if (struct.isSetSshPort()) {
        oprot.writeI32(struct.sshPort);
      }
      if (struct.isSetExports()) {
        {
          oprot.writeI32(struct.exports.size());
          for (String _iter12 : struct.exports)
          {
            oprot.writeString(_iter12);
          }
        }
      }
      if (struct.isSetPreJobCommands()) {
        {
          oprot.writeI32(struct.preJobCommands.size());
          for (String _iter13 : struct.preJobCommands)
          {
            oprot.writeString(_iter13);
          }
        }
      }
      if (struct.isSetPostJobCommands()) {
        {
          oprot.writeI32(struct.postJobCommands.size());
          for (String _iter14 : struct.postJobCommands)
          {
            oprot.writeString(_iter14);
          }
        }
      }
      if (struct.isSetInstalledPath()) {
        oprot.writeString(struct.installedPath);
      }
      if (struct.isSetMonitorMode()) {
        oprot.writeString(struct.monitorMode);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, GSISSHJobSubmission struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.resourceJobManager = ResourceJobManager.findByValue(iprot.readI32());
      struct.setResourceJobManagerIsSet(true);
      BitSet incoming = iprot.readBitSet(6);
      if (incoming.get(0)) {
        struct.sshPort = iprot.readI32();
        struct.setSshPortIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TSet _set15 = new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.exports = new HashSet<String>(2*_set15.size);
          for (int _i16 = 0; _i16 < _set15.size; ++_i16)
          {
            String _elem17;
            _elem17 = iprot.readString();
            struct.exports.add(_elem17);
          }
        }
        struct.setExportsIsSet(true);
      }
      if (incoming.get(2)) {
        {
          org.apache.thrift.protocol.TList _list18 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.preJobCommands = new ArrayList<String>(_list18.size);
          for (int _i19 = 0; _i19 < _list18.size; ++_i19)
          {
            String _elem20;
            _elem20 = iprot.readString();
            struct.preJobCommands.add(_elem20);
          }
        }
        struct.setPreJobCommandsIsSet(true);
      }
      if (incoming.get(3)) {
        {
          org.apache.thrift.protocol.TList _list21 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.postJobCommands = new ArrayList<String>(_list21.size);
          for (int _i22 = 0; _i22 < _list21.size; ++_i22)
          {
            String _elem23;
            _elem23 = iprot.readString();
            struct.postJobCommands.add(_elem23);
          }
        }
        struct.setPostJobCommandsIsSet(true);
      }
      if (incoming.get(4)) {
        struct.installedPath = iprot.readString();
        struct.setInstalledPathIsSet(true);
      }
      if (incoming.get(5)) {
        struct.monitorMode = iprot.readString();
        struct.setMonitorModeIsSet(true);
      }
    }
  }

}

