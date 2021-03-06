/**
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
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
#include "workspace_model_types.h"

#include <algorithm>
#include <ostream>

#include <thrift/TToString.h>

namespace apache { namespace airavata { namespace model { namespace workspace {


Group::~Group() throw() {
}


void Group::__set_groupName(const std::string& val) {
  this->groupName = val;
}

void Group::__set_description(const std::string& val) {
  this->description = val;
__isset.description = true;
}

const char* Group::ascii_fingerprint = "5B708A954C550ECA9C1A49D3C5CAFAB9";
const uint8_t Group::binary_fingerprint[16] = {0x5B,0x70,0x8A,0x95,0x4C,0x55,0x0E,0xCA,0x9C,0x1A,0x49,0xD3,0xC5,0xCA,0xFA,0xB9};

uint32_t Group::read(::apache::thrift::protocol::TProtocol* iprot) {

  uint32_t xfer = 0;
  std::string fname;
  ::apache::thrift::protocol::TType ftype;
  int16_t fid;

  xfer += iprot->readStructBegin(fname);

  using ::apache::thrift::protocol::TProtocolException;

  bool isset_groupName = false;

  while (true)
  {
    xfer += iprot->readFieldBegin(fname, ftype, fid);
    if (ftype == ::apache::thrift::protocol::T_STOP) {
      break;
    }
    switch (fid)
    {
      case 1:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->groupName);
          isset_groupName = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 2:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->description);
          this->__isset.description = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      default:
        xfer += iprot->skip(ftype);
        break;
    }
    xfer += iprot->readFieldEnd();
  }

  xfer += iprot->readStructEnd();

  if (!isset_groupName)
    throw TProtocolException(TProtocolException::INVALID_DATA);
  return xfer;
}

uint32_t Group::write(::apache::thrift::protocol::TProtocol* oprot) const {
  uint32_t xfer = 0;
  oprot->incrementRecursionDepth();
  xfer += oprot->writeStructBegin("Group");

  xfer += oprot->writeFieldBegin("groupName", ::apache::thrift::protocol::T_STRING, 1);
  xfer += oprot->writeString(this->groupName);
  xfer += oprot->writeFieldEnd();

  if (this->__isset.description) {
    xfer += oprot->writeFieldBegin("description", ::apache::thrift::protocol::T_STRING, 2);
    xfer += oprot->writeString(this->description);
    xfer += oprot->writeFieldEnd();
  }
  xfer += oprot->writeFieldStop();
  xfer += oprot->writeStructEnd();
  oprot->decrementRecursionDepth();
  return xfer;
}

void swap(Group &a, Group &b) {
  using ::std::swap;
  swap(a.groupName, b.groupName);
  swap(a.description, b.description);
  swap(a.__isset, b.__isset);
}

Group::Group(const Group& other0) {
  groupName = other0.groupName;
  description = other0.description;
  __isset = other0.__isset;
}
Group& Group::operator=(const Group& other1) {
  groupName = other1.groupName;
  description = other1.description;
  __isset = other1.__isset;
  return *this;
}
std::ostream& operator<<(std::ostream& out, const Group& obj) {
  using apache::thrift::to_string;
  out << "Group(";
  out << "groupName=" << to_string(obj.groupName);
  out << ", " << "description="; (obj.__isset.description ? (out << to_string(obj.description)) : (out << "<null>"));
  out << ")";
  return out;
}


Project::~Project() throw() {
}


void Project::__set_projectID(const std::string& val) {
  this->projectID = val;
}

void Project::__set_owner(const std::string& val) {
  this->owner = val;
}

void Project::__set_name(const std::string& val) {
  this->name = val;
}

void Project::__set_description(const std::string& val) {
  this->description = val;
__isset.description = true;
}

void Project::__set_creationTime(const int64_t val) {
  this->creationTime = val;
__isset.creationTime = true;
}

void Project::__set_sharedUsers(const std::vector<std::string> & val) {
  this->sharedUsers = val;
__isset.sharedUsers = true;
}

void Project::__set_sharedGroups(const std::vector<std::string> & val) {
  this->sharedGroups = val;
__isset.sharedGroups = true;
}

const char* Project::ascii_fingerprint = "AFD8090DE564134035942D450F918628";
const uint8_t Project::binary_fingerprint[16] = {0xAF,0xD8,0x09,0x0D,0xE5,0x64,0x13,0x40,0x35,0x94,0x2D,0x45,0x0F,0x91,0x86,0x28};

uint32_t Project::read(::apache::thrift::protocol::TProtocol* iprot) {

  uint32_t xfer = 0;
  std::string fname;
  ::apache::thrift::protocol::TType ftype;
  int16_t fid;

  xfer += iprot->readStructBegin(fname);

  using ::apache::thrift::protocol::TProtocolException;

  bool isset_projectID = false;
  bool isset_owner = false;
  bool isset_name = false;

  while (true)
  {
    xfer += iprot->readFieldBegin(fname, ftype, fid);
    if (ftype == ::apache::thrift::protocol::T_STOP) {
      break;
    }
    switch (fid)
    {
      case 1:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->projectID);
          isset_projectID = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 2:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->owner);
          isset_owner = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 3:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->name);
          isset_name = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 4:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->description);
          this->__isset.description = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 5:
        if (ftype == ::apache::thrift::protocol::T_I64) {
          xfer += iprot->readI64(this->creationTime);
          this->__isset.creationTime = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 6:
        if (ftype == ::apache::thrift::protocol::T_LIST) {
          {
            this->sharedUsers.clear();
            uint32_t _size2;
            ::apache::thrift::protocol::TType _etype5;
            xfer += iprot->readListBegin(_etype5, _size2);
            this->sharedUsers.resize(_size2);
            uint32_t _i6;
            for (_i6 = 0; _i6 < _size2; ++_i6)
            {
              xfer += iprot->readString(this->sharedUsers[_i6]);
            }
            xfer += iprot->readListEnd();
          }
          this->__isset.sharedUsers = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 7:
        if (ftype == ::apache::thrift::protocol::T_LIST) {
          {
            this->sharedGroups.clear();
            uint32_t _size7;
            ::apache::thrift::protocol::TType _etype10;
            xfer += iprot->readListBegin(_etype10, _size7);
            this->sharedGroups.resize(_size7);
            uint32_t _i11;
            for (_i11 = 0; _i11 < _size7; ++_i11)
            {
              xfer += iprot->readString(this->sharedGroups[_i11]);
            }
            xfer += iprot->readListEnd();
          }
          this->__isset.sharedGroups = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      default:
        xfer += iprot->skip(ftype);
        break;
    }
    xfer += iprot->readFieldEnd();
  }

  xfer += iprot->readStructEnd();

  if (!isset_projectID)
    throw TProtocolException(TProtocolException::INVALID_DATA);
  if (!isset_owner)
    throw TProtocolException(TProtocolException::INVALID_DATA);
  if (!isset_name)
    throw TProtocolException(TProtocolException::INVALID_DATA);
  return xfer;
}

uint32_t Project::write(::apache::thrift::protocol::TProtocol* oprot) const {
  uint32_t xfer = 0;
  oprot->incrementRecursionDepth();
  xfer += oprot->writeStructBegin("Project");

  xfer += oprot->writeFieldBegin("projectID", ::apache::thrift::protocol::T_STRING, 1);
  xfer += oprot->writeString(this->projectID);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("owner", ::apache::thrift::protocol::T_STRING, 2);
  xfer += oprot->writeString(this->owner);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("name", ::apache::thrift::protocol::T_STRING, 3);
  xfer += oprot->writeString(this->name);
  xfer += oprot->writeFieldEnd();

  if (this->__isset.description) {
    xfer += oprot->writeFieldBegin("description", ::apache::thrift::protocol::T_STRING, 4);
    xfer += oprot->writeString(this->description);
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.creationTime) {
    xfer += oprot->writeFieldBegin("creationTime", ::apache::thrift::protocol::T_I64, 5);
    xfer += oprot->writeI64(this->creationTime);
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.sharedUsers) {
    xfer += oprot->writeFieldBegin("sharedUsers", ::apache::thrift::protocol::T_LIST, 6);
    {
      xfer += oprot->writeListBegin(::apache::thrift::protocol::T_STRING, static_cast<uint32_t>(this->sharedUsers.size()));
      std::vector<std::string> ::const_iterator _iter12;
      for (_iter12 = this->sharedUsers.begin(); _iter12 != this->sharedUsers.end(); ++_iter12)
      {
        xfer += oprot->writeString((*_iter12));
      }
      xfer += oprot->writeListEnd();
    }
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.sharedGroups) {
    xfer += oprot->writeFieldBegin("sharedGroups", ::apache::thrift::protocol::T_LIST, 7);
    {
      xfer += oprot->writeListBegin(::apache::thrift::protocol::T_STRING, static_cast<uint32_t>(this->sharedGroups.size()));
      std::vector<std::string> ::const_iterator _iter13;
      for (_iter13 = this->sharedGroups.begin(); _iter13 != this->sharedGroups.end(); ++_iter13)
      {
        xfer += oprot->writeString((*_iter13));
      }
      xfer += oprot->writeListEnd();
    }
    xfer += oprot->writeFieldEnd();
  }
  xfer += oprot->writeFieldStop();
  xfer += oprot->writeStructEnd();
  oprot->decrementRecursionDepth();
  return xfer;
}

void swap(Project &a, Project &b) {
  using ::std::swap;
  swap(a.projectID, b.projectID);
  swap(a.owner, b.owner);
  swap(a.name, b.name);
  swap(a.description, b.description);
  swap(a.creationTime, b.creationTime);
  swap(a.sharedUsers, b.sharedUsers);
  swap(a.sharedGroups, b.sharedGroups);
  swap(a.__isset, b.__isset);
}

Project::Project(const Project& other14) {
  projectID = other14.projectID;
  owner = other14.owner;
  name = other14.name;
  description = other14.description;
  creationTime = other14.creationTime;
  sharedUsers = other14.sharedUsers;
  sharedGroups = other14.sharedGroups;
  __isset = other14.__isset;
}
Project& Project::operator=(const Project& other15) {
  projectID = other15.projectID;
  owner = other15.owner;
  name = other15.name;
  description = other15.description;
  creationTime = other15.creationTime;
  sharedUsers = other15.sharedUsers;
  sharedGroups = other15.sharedGroups;
  __isset = other15.__isset;
  return *this;
}
std::ostream& operator<<(std::ostream& out, const Project& obj) {
  using apache::thrift::to_string;
  out << "Project(";
  out << "projectID=" << to_string(obj.projectID);
  out << ", " << "owner=" << to_string(obj.owner);
  out << ", " << "name=" << to_string(obj.name);
  out << ", " << "description="; (obj.__isset.description ? (out << to_string(obj.description)) : (out << "<null>"));
  out << ", " << "creationTime="; (obj.__isset.creationTime ? (out << to_string(obj.creationTime)) : (out << "<null>"));
  out << ", " << "sharedUsers="; (obj.__isset.sharedUsers ? (out << to_string(obj.sharedUsers)) : (out << "<null>"));
  out << ", " << "sharedGroups="; (obj.__isset.sharedGroups ? (out << to_string(obj.sharedGroups)) : (out << "<null>"));
  out << ")";
  return out;
}


User::~User() throw() {
}


void User::__set_userName(const std::string& val) {
  this->userName = val;
}

void User::__set_groupList(const std::vector<Group> & val) {
  this->groupList = val;
__isset.groupList = true;
}

const char* User::ascii_fingerprint = "D7DA282D6B2F08CB02B4E3CF47DB44E5";
const uint8_t User::binary_fingerprint[16] = {0xD7,0xDA,0x28,0x2D,0x6B,0x2F,0x08,0xCB,0x02,0xB4,0xE3,0xCF,0x47,0xDB,0x44,0xE5};

uint32_t User::read(::apache::thrift::protocol::TProtocol* iprot) {

  uint32_t xfer = 0;
  std::string fname;
  ::apache::thrift::protocol::TType ftype;
  int16_t fid;

  xfer += iprot->readStructBegin(fname);

  using ::apache::thrift::protocol::TProtocolException;

  bool isset_userName = false;

  while (true)
  {
    xfer += iprot->readFieldBegin(fname, ftype, fid);
    if (ftype == ::apache::thrift::protocol::T_STOP) {
      break;
    }
    switch (fid)
    {
      case 1:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->userName);
          isset_userName = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 2:
        if (ftype == ::apache::thrift::protocol::T_LIST) {
          {
            this->groupList.clear();
            uint32_t _size16;
            ::apache::thrift::protocol::TType _etype19;
            xfer += iprot->readListBegin(_etype19, _size16);
            this->groupList.resize(_size16);
            uint32_t _i20;
            for (_i20 = 0; _i20 < _size16; ++_i20)
            {
              xfer += this->groupList[_i20].read(iprot);
            }
            xfer += iprot->readListEnd();
          }
          this->__isset.groupList = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      default:
        xfer += iprot->skip(ftype);
        break;
    }
    xfer += iprot->readFieldEnd();
  }

  xfer += iprot->readStructEnd();

  if (!isset_userName)
    throw TProtocolException(TProtocolException::INVALID_DATA);
  return xfer;
}

uint32_t User::write(::apache::thrift::protocol::TProtocol* oprot) const {
  uint32_t xfer = 0;
  oprot->incrementRecursionDepth();
  xfer += oprot->writeStructBegin("User");

  xfer += oprot->writeFieldBegin("userName", ::apache::thrift::protocol::T_STRING, 1);
  xfer += oprot->writeString(this->userName);
  xfer += oprot->writeFieldEnd();

  if (this->__isset.groupList) {
    xfer += oprot->writeFieldBegin("groupList", ::apache::thrift::protocol::T_LIST, 2);
    {
      xfer += oprot->writeListBegin(::apache::thrift::protocol::T_STRUCT, static_cast<uint32_t>(this->groupList.size()));
      std::vector<Group> ::const_iterator _iter21;
      for (_iter21 = this->groupList.begin(); _iter21 != this->groupList.end(); ++_iter21)
      {
        xfer += (*_iter21).write(oprot);
      }
      xfer += oprot->writeListEnd();
    }
    xfer += oprot->writeFieldEnd();
  }
  xfer += oprot->writeFieldStop();
  xfer += oprot->writeStructEnd();
  oprot->decrementRecursionDepth();
  return xfer;
}

void swap(User &a, User &b) {
  using ::std::swap;
  swap(a.userName, b.userName);
  swap(a.groupList, b.groupList);
  swap(a.__isset, b.__isset);
}

User::User(const User& other22) {
  userName = other22.userName;
  groupList = other22.groupList;
  __isset = other22.__isset;
}
User& User::operator=(const User& other23) {
  userName = other23.userName;
  groupList = other23.groupList;
  __isset = other23.__isset;
  return *this;
}
std::ostream& operator<<(std::ostream& out, const User& obj) {
  using apache::thrift::to_string;
  out << "User(";
  out << "userName=" << to_string(obj.userName);
  out << ", " << "groupList="; (obj.__isset.groupList ? (out << to_string(obj.groupList)) : (out << "<null>"));
  out << ")";
  return out;
}


Gateway::~Gateway() throw() {
}


void Gateway::__set_gatewayId(const std::string& val) {
  this->gatewayId = val;
}

void Gateway::__set_gatewayName(const std::string& val) {
  this->gatewayName = val;
__isset.gatewayName = true;
}

void Gateway::__set_domain(const std::string& val) {
  this->domain = val;
__isset.domain = true;
}

void Gateway::__set_emailAddress(const std::string& val) {
  this->emailAddress = val;
__isset.emailAddress = true;
}

const char* Gateway::ascii_fingerprint = "6BA700CA2E5FC52A8DA5ADCF811DC8DA";
const uint8_t Gateway::binary_fingerprint[16] = {0x6B,0xA7,0x00,0xCA,0x2E,0x5F,0xC5,0x2A,0x8D,0xA5,0xAD,0xCF,0x81,0x1D,0xC8,0xDA};

uint32_t Gateway::read(::apache::thrift::protocol::TProtocol* iprot) {

  uint32_t xfer = 0;
  std::string fname;
  ::apache::thrift::protocol::TType ftype;
  int16_t fid;

  xfer += iprot->readStructBegin(fname);

  using ::apache::thrift::protocol::TProtocolException;

  bool isset_gatewayId = false;

  while (true)
  {
    xfer += iprot->readFieldBegin(fname, ftype, fid);
    if (ftype == ::apache::thrift::protocol::T_STOP) {
      break;
    }
    switch (fid)
    {
      case 1:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->gatewayId);
          isset_gatewayId = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 2:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->gatewayName);
          this->__isset.gatewayName = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 3:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->domain);
          this->__isset.domain = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 4:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->emailAddress);
          this->__isset.emailAddress = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      default:
        xfer += iprot->skip(ftype);
        break;
    }
    xfer += iprot->readFieldEnd();
  }

  xfer += iprot->readStructEnd();

  if (!isset_gatewayId)
    throw TProtocolException(TProtocolException::INVALID_DATA);
  return xfer;
}

uint32_t Gateway::write(::apache::thrift::protocol::TProtocol* oprot) const {
  uint32_t xfer = 0;
  oprot->incrementRecursionDepth();
  xfer += oprot->writeStructBegin("Gateway");

  xfer += oprot->writeFieldBegin("gatewayId", ::apache::thrift::protocol::T_STRING, 1);
  xfer += oprot->writeString(this->gatewayId);
  xfer += oprot->writeFieldEnd();

  if (this->__isset.gatewayName) {
    xfer += oprot->writeFieldBegin("gatewayName", ::apache::thrift::protocol::T_STRING, 2);
    xfer += oprot->writeString(this->gatewayName);
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.domain) {
    xfer += oprot->writeFieldBegin("domain", ::apache::thrift::protocol::T_STRING, 3);
    xfer += oprot->writeString(this->domain);
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.emailAddress) {
    xfer += oprot->writeFieldBegin("emailAddress", ::apache::thrift::protocol::T_STRING, 4);
    xfer += oprot->writeString(this->emailAddress);
    xfer += oprot->writeFieldEnd();
  }
  xfer += oprot->writeFieldStop();
  xfer += oprot->writeStructEnd();
  oprot->decrementRecursionDepth();
  return xfer;
}

void swap(Gateway &a, Gateway &b) {
  using ::std::swap;
  swap(a.gatewayId, b.gatewayId);
  swap(a.gatewayName, b.gatewayName);
  swap(a.domain, b.domain);
  swap(a.emailAddress, b.emailAddress);
  swap(a.__isset, b.__isset);
}

Gateway::Gateway(const Gateway& other24) {
  gatewayId = other24.gatewayId;
  gatewayName = other24.gatewayName;
  domain = other24.domain;
  emailAddress = other24.emailAddress;
  __isset = other24.__isset;
}
Gateway& Gateway::operator=(const Gateway& other25) {
  gatewayId = other25.gatewayId;
  gatewayName = other25.gatewayName;
  domain = other25.domain;
  emailAddress = other25.emailAddress;
  __isset = other25.__isset;
  return *this;
}
std::ostream& operator<<(std::ostream& out, const Gateway& obj) {
  using apache::thrift::to_string;
  out << "Gateway(";
  out << "gatewayId=" << to_string(obj.gatewayId);
  out << ", " << "gatewayName="; (obj.__isset.gatewayName ? (out << to_string(obj.gatewayName)) : (out << "<null>"));
  out << ", " << "domain="; (obj.__isset.domain ? (out << to_string(obj.domain)) : (out << "<null>"));
  out << ", " << "emailAddress="; (obj.__isset.emailAddress ? (out << to_string(obj.emailAddress)) : (out << "<null>"));
  out << ")";
  return out;
}

}}}} // namespace
