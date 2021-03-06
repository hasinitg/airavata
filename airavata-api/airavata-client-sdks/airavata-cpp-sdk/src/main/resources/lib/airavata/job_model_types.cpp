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
#include "job_model_types.h"

#include <algorithm>
#include <ostream>

#include <thrift/TToString.h>

namespace apache { namespace airavata { namespace model { namespace job {


JobModel::~JobModel() throw() {
}


void JobModel::__set_jobId(const std::string& val) {
  this->jobId = val;
}

void JobModel::__set_taskId(const std::string& val) {
  this->taskId = val;
}

void JobModel::__set_jobDescription(const std::string& val) {
  this->jobDescription = val;
}

void JobModel::__set_creationTime(const int64_t val) {
  this->creationTime = val;
__isset.creationTime = true;
}

void JobModel::__set_jobStatus(const  ::apache::airavata::model::status::JobStatus& val) {
  this->jobStatus = val;
__isset.jobStatus = true;
}

void JobModel::__set_computeResourceConsumed(const std::string& val) {
  this->computeResourceConsumed = val;
__isset.computeResourceConsumed = true;
}

void JobModel::__set_jobName(const std::string& val) {
  this->jobName = val;
__isset.jobName = true;
}

void JobModel::__set_workingDir(const std::string& val) {
  this->workingDir = val;
__isset.workingDir = true;
}

const char* JobModel::ascii_fingerprint = "41CA915161D6C0FFEE6B97FACBDE9259";
const uint8_t JobModel::binary_fingerprint[16] = {0x41,0xCA,0x91,0x51,0x61,0xD6,0xC0,0xFF,0xEE,0x6B,0x97,0xFA,0xCB,0xDE,0x92,0x59};

uint32_t JobModel::read(::apache::thrift::protocol::TProtocol* iprot) {

  uint32_t xfer = 0;
  std::string fname;
  ::apache::thrift::protocol::TType ftype;
  int16_t fid;

  xfer += iprot->readStructBegin(fname);

  using ::apache::thrift::protocol::TProtocolException;

  bool isset_jobId = false;
  bool isset_taskId = false;
  bool isset_jobDescription = false;

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
          xfer += iprot->readString(this->jobId);
          isset_jobId = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 2:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->taskId);
          isset_taskId = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 3:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->jobDescription);
          isset_jobDescription = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 4:
        if (ftype == ::apache::thrift::protocol::T_I64) {
          xfer += iprot->readI64(this->creationTime);
          this->__isset.creationTime = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 5:
        if (ftype == ::apache::thrift::protocol::T_STRUCT) {
          xfer += this->jobStatus.read(iprot);
          this->__isset.jobStatus = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 6:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->computeResourceConsumed);
          this->__isset.computeResourceConsumed = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 7:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->jobName);
          this->__isset.jobName = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 8:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->workingDir);
          this->__isset.workingDir = true;
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

  if (!isset_jobId)
    throw TProtocolException(TProtocolException::INVALID_DATA);
  if (!isset_taskId)
    throw TProtocolException(TProtocolException::INVALID_DATA);
  if (!isset_jobDescription)
    throw TProtocolException(TProtocolException::INVALID_DATA);
  return xfer;
}

uint32_t JobModel::write(::apache::thrift::protocol::TProtocol* oprot) const {
  uint32_t xfer = 0;
  oprot->incrementRecursionDepth();
  xfer += oprot->writeStructBegin("JobModel");

  xfer += oprot->writeFieldBegin("jobId", ::apache::thrift::protocol::T_STRING, 1);
  xfer += oprot->writeString(this->jobId);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("taskId", ::apache::thrift::protocol::T_STRING, 2);
  xfer += oprot->writeString(this->taskId);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("jobDescription", ::apache::thrift::protocol::T_STRING, 3);
  xfer += oprot->writeString(this->jobDescription);
  xfer += oprot->writeFieldEnd();

  if (this->__isset.creationTime) {
    xfer += oprot->writeFieldBegin("creationTime", ::apache::thrift::protocol::T_I64, 4);
    xfer += oprot->writeI64(this->creationTime);
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.jobStatus) {
    xfer += oprot->writeFieldBegin("jobStatus", ::apache::thrift::protocol::T_STRUCT, 5);
    xfer += this->jobStatus.write(oprot);
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.computeResourceConsumed) {
    xfer += oprot->writeFieldBegin("computeResourceConsumed", ::apache::thrift::protocol::T_STRING, 6);
    xfer += oprot->writeString(this->computeResourceConsumed);
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.jobName) {
    xfer += oprot->writeFieldBegin("jobName", ::apache::thrift::protocol::T_STRING, 7);
    xfer += oprot->writeString(this->jobName);
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.workingDir) {
    xfer += oprot->writeFieldBegin("workingDir", ::apache::thrift::protocol::T_STRING, 8);
    xfer += oprot->writeString(this->workingDir);
    xfer += oprot->writeFieldEnd();
  }
  xfer += oprot->writeFieldStop();
  xfer += oprot->writeStructEnd();
  oprot->decrementRecursionDepth();
  return xfer;
}

void swap(JobModel &a, JobModel &b) {
  using ::std::swap;
  swap(a.jobId, b.jobId);
  swap(a.taskId, b.taskId);
  swap(a.jobDescription, b.jobDescription);
  swap(a.creationTime, b.creationTime);
  swap(a.jobStatus, b.jobStatus);
  swap(a.computeResourceConsumed, b.computeResourceConsumed);
  swap(a.jobName, b.jobName);
  swap(a.workingDir, b.workingDir);
  swap(a.__isset, b.__isset);
}

JobModel::JobModel(const JobModel& other0) {
  jobId = other0.jobId;
  taskId = other0.taskId;
  jobDescription = other0.jobDescription;
  creationTime = other0.creationTime;
  jobStatus = other0.jobStatus;
  computeResourceConsumed = other0.computeResourceConsumed;
  jobName = other0.jobName;
  workingDir = other0.workingDir;
  __isset = other0.__isset;
}
JobModel& JobModel::operator=(const JobModel& other1) {
  jobId = other1.jobId;
  taskId = other1.taskId;
  jobDescription = other1.jobDescription;
  creationTime = other1.creationTime;
  jobStatus = other1.jobStatus;
  computeResourceConsumed = other1.computeResourceConsumed;
  jobName = other1.jobName;
  workingDir = other1.workingDir;
  __isset = other1.__isset;
  return *this;
}
std::ostream& operator<<(std::ostream& out, const JobModel& obj) {
  using apache::thrift::to_string;
  out << "JobModel(";
  out << "jobId=" << to_string(obj.jobId);
  out << ", " << "taskId=" << to_string(obj.taskId);
  out << ", " << "jobDescription=" << to_string(obj.jobDescription);
  out << ", " << "creationTime="; (obj.__isset.creationTime ? (out << to_string(obj.creationTime)) : (out << "<null>"));
  out << ", " << "jobStatus="; (obj.__isset.jobStatus ? (out << to_string(obj.jobStatus)) : (out << "<null>"));
  out << ", " << "computeResourceConsumed="; (obj.__isset.computeResourceConsumed ? (out << to_string(obj.computeResourceConsumed)) : (out << "<null>"));
  out << ", " << "jobName="; (obj.__isset.jobName ? (out << to_string(obj.jobName)) : (out << "<null>"));
  out << ", " << "workingDir="; (obj.__isset.workingDir ? (out << to_string(obj.workingDir)) : (out << "<null>"));
  out << ")";
  return out;
}

}}}} // namespace
