/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
#include "airavataErrors_types.h"

#include <algorithm>

namespace airavata { namespace api { namespace error {

int _kAiravataErrorTypeValues[] = {
  AiravataErrorType::UNKNOWN,
  AiravataErrorType::PERMISSION_DENIED,
  AiravataErrorType::INTERNAL_ERROR,
  AiravataErrorType::AUTHENTICATION_FAILURE,
  AiravataErrorType::INVALID_AUTHORIZATION,
  AiravataErrorType::AUTHORIZATION_EXPIRED,
  AiravataErrorType::UNKNOWN_GATEWAY_ID,
  AiravataErrorType::UNSUPPORTED_OPERATION
};
const char* _kAiravataErrorTypeNames[] = {
  "UNKNOWN",
  "PERMISSION_DENIED",
  "INTERNAL_ERROR",
  "AUTHENTICATION_FAILURE",
  "INVALID_AUTHORIZATION",
  "AUTHORIZATION_EXPIRED",
  "UNKNOWN_GATEWAY_ID",
  "UNSUPPORTED_OPERATION"
};
const std::map<int, const char*> _AiravataErrorType_VALUES_TO_NAMES(::apache::thrift::TEnumIterator(8, _kAiravataErrorTypeValues, _kAiravataErrorTypeNames), ::apache::thrift::TEnumIterator(-1, NULL, NULL));

const char* ExperimentNotFoundException::ascii_fingerprint = "D0297FC5011701BD87898CC36146A565";
const uint8_t ExperimentNotFoundException::binary_fingerprint[16] = {0xD0,0x29,0x7F,0xC5,0x01,0x17,0x01,0xBD,0x87,0x89,0x8C,0xC3,0x61,0x46,0xA5,0x65};

uint32_t ExperimentNotFoundException::read(::apache::thrift::protocol::TProtocol* iprot) {

  uint32_t xfer = 0;
  std::string fname;
  ::apache::thrift::protocol::TType ftype;
  int16_t fid;

  xfer += iprot->readStructBegin(fname);

  using ::apache::thrift::protocol::TProtocolException;


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
          xfer += iprot->readString(this->identifier);
          this->__isset.identifier = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 2:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->key);
          this->__isset.key = true;
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

  return xfer;
}

uint32_t ExperimentNotFoundException::write(::apache::thrift::protocol::TProtocol* oprot) const {
  uint32_t xfer = 0;
  xfer += oprot->writeStructBegin("ExperimentNotFoundException");

  if (this->__isset.identifier) {
    xfer += oprot->writeFieldBegin("identifier", ::apache::thrift::protocol::T_STRING, 1);
    xfer += oprot->writeString(this->identifier);
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.key) {
    xfer += oprot->writeFieldBegin("key", ::apache::thrift::protocol::T_STRING, 2);
    xfer += oprot->writeString(this->key);
    xfer += oprot->writeFieldEnd();
  }
  xfer += oprot->writeFieldStop();
  xfer += oprot->writeStructEnd();
  return xfer;
}

void swap(ExperimentNotFoundException &a, ExperimentNotFoundException &b) {
  using ::std::swap;
  swap(a.identifier, b.identifier);
  swap(a.key, b.key);
  swap(a.__isset, b.__isset);
}

const char* InvalidRequestException::ascii_fingerprint = "EFB929595D312AC8F305D5A794CFEDA1";
const uint8_t InvalidRequestException::binary_fingerprint[16] = {0xEF,0xB9,0x29,0x59,0x5D,0x31,0x2A,0xC8,0xF3,0x05,0xD5,0xA7,0x94,0xCF,0xED,0xA1};

uint32_t InvalidRequestException::read(::apache::thrift::protocol::TProtocol* iprot) {

  uint32_t xfer = 0;
  std::string fname;
  ::apache::thrift::protocol::TType ftype;
  int16_t fid;

  xfer += iprot->readStructBegin(fname);

  using ::apache::thrift::protocol::TProtocolException;

  bool isset_message = false;

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
          xfer += iprot->readString(this->message);
          isset_message = true;
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

  if (!isset_message)
    throw TProtocolException(TProtocolException::INVALID_DATA);
  return xfer;
}

uint32_t InvalidRequestException::write(::apache::thrift::protocol::TProtocol* oprot) const {
  uint32_t xfer = 0;
  xfer += oprot->writeStructBegin("InvalidRequestException");

  xfer += oprot->writeFieldBegin("message", ::apache::thrift::protocol::T_STRING, 1);
  xfer += oprot->writeString(this->message);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldStop();
  xfer += oprot->writeStructEnd();
  return xfer;
}

void swap(InvalidRequestException &a, InvalidRequestException &b) {
  using ::std::swap;
  swap(a.message, b.message);
}

const char* TimedOutException::ascii_fingerprint = "99914B932BD37A50B983C5E7C90AE93B";
const uint8_t TimedOutException::binary_fingerprint[16] = {0x99,0x91,0x4B,0x93,0x2B,0xD3,0x7A,0x50,0xB9,0x83,0xC5,0xE7,0xC9,0x0A,0xE9,0x3B};

uint32_t TimedOutException::read(::apache::thrift::protocol::TProtocol* iprot) {

  uint32_t xfer = 0;
  std::string fname;
  ::apache::thrift::protocol::TType ftype;
  int16_t fid;

  xfer += iprot->readStructBegin(fname);

  using ::apache::thrift::protocol::TProtocolException;


  while (true)
  {
    xfer += iprot->readFieldBegin(fname, ftype, fid);
    if (ftype == ::apache::thrift::protocol::T_STOP) {
      break;
    }
    xfer += iprot->skip(ftype);
    xfer += iprot->readFieldEnd();
  }

  xfer += iprot->readStructEnd();

  return xfer;
}

uint32_t TimedOutException::write(::apache::thrift::protocol::TProtocol* oprot) const {
  uint32_t xfer = 0;
  xfer += oprot->writeStructBegin("TimedOutException");

  xfer += oprot->writeFieldStop();
  xfer += oprot->writeStructEnd();
  return xfer;
}

void swap(TimedOutException &a, TimedOutException &b) {
  using ::std::swap;
  (void) a;
  (void) b;
}

const char* AuthenticationException::ascii_fingerprint = "EFB929595D312AC8F305D5A794CFEDA1";
const uint8_t AuthenticationException::binary_fingerprint[16] = {0xEF,0xB9,0x29,0x59,0x5D,0x31,0x2A,0xC8,0xF3,0x05,0xD5,0xA7,0x94,0xCF,0xED,0xA1};

uint32_t AuthenticationException::read(::apache::thrift::protocol::TProtocol* iprot) {

  uint32_t xfer = 0;
  std::string fname;
  ::apache::thrift::protocol::TType ftype;
  int16_t fid;

  xfer += iprot->readStructBegin(fname);

  using ::apache::thrift::protocol::TProtocolException;

  bool isset_message = false;

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
          xfer += iprot->readString(this->message);
          isset_message = true;
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

  if (!isset_message)
    throw TProtocolException(TProtocolException::INVALID_DATA);
  return xfer;
}

uint32_t AuthenticationException::write(::apache::thrift::protocol::TProtocol* oprot) const {
  uint32_t xfer = 0;
  xfer += oprot->writeStructBegin("AuthenticationException");

  xfer += oprot->writeFieldBegin("message", ::apache::thrift::protocol::T_STRING, 1);
  xfer += oprot->writeString(this->message);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldStop();
  xfer += oprot->writeStructEnd();
  return xfer;
}

void swap(AuthenticationException &a, AuthenticationException &b) {
  using ::std::swap;
  swap(a.message, b.message);
}

const char* AuthorizationException::ascii_fingerprint = "EFB929595D312AC8F305D5A794CFEDA1";
const uint8_t AuthorizationException::binary_fingerprint[16] = {0xEF,0xB9,0x29,0x59,0x5D,0x31,0x2A,0xC8,0xF3,0x05,0xD5,0xA7,0x94,0xCF,0xED,0xA1};

uint32_t AuthorizationException::read(::apache::thrift::protocol::TProtocol* iprot) {

  uint32_t xfer = 0;
  std::string fname;
  ::apache::thrift::protocol::TType ftype;
  int16_t fid;

  xfer += iprot->readStructBegin(fname);

  using ::apache::thrift::protocol::TProtocolException;

  bool isset_message = false;

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
          xfer += iprot->readString(this->message);
          isset_message = true;
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

  if (!isset_message)
    throw TProtocolException(TProtocolException::INVALID_DATA);
  return xfer;
}

uint32_t AuthorizationException::write(::apache::thrift::protocol::TProtocol* oprot) const {
  uint32_t xfer = 0;
  xfer += oprot->writeStructBegin("AuthorizationException");

  xfer += oprot->writeFieldBegin("message", ::apache::thrift::protocol::T_STRING, 1);
  xfer += oprot->writeString(this->message);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldStop();
  xfer += oprot->writeStructEnd();
  return xfer;
}

void swap(AuthorizationException &a, AuthorizationException &b) {
  using ::std::swap;
  swap(a.message, b.message);
}

const char* AiravataClientException::ascii_fingerprint = "24652790C81ECE22B629CB60A19F1E93";
const uint8_t AiravataClientException::binary_fingerprint[16] = {0x24,0x65,0x27,0x90,0xC8,0x1E,0xCE,0x22,0xB6,0x29,0xCB,0x60,0xA1,0x9F,0x1E,0x93};

uint32_t AiravataClientException::read(::apache::thrift::protocol::TProtocol* iprot) {

  uint32_t xfer = 0;
  std::string fname;
  ::apache::thrift::protocol::TType ftype;
  int16_t fid;

  xfer += iprot->readStructBegin(fname);

  using ::apache::thrift::protocol::TProtocolException;

  bool isset_airavataErrorType = false;

  while (true)
  {
    xfer += iprot->readFieldBegin(fname, ftype, fid);
    if (ftype == ::apache::thrift::protocol::T_STOP) {
      break;
    }
    switch (fid)
    {
      case 1:
        if (ftype == ::apache::thrift::protocol::T_I32) {
          int32_t ecast0;
          xfer += iprot->readI32(ecast0);
          this->airavataErrorType = (AiravataErrorType::type)ecast0;
          isset_airavataErrorType = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 2:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->parameter);
          this->__isset.parameter = true;
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

  if (!isset_airavataErrorType)
    throw TProtocolException(TProtocolException::INVALID_DATA);
  return xfer;
}

uint32_t AiravataClientException::write(::apache::thrift::protocol::TProtocol* oprot) const {
  uint32_t xfer = 0;
  xfer += oprot->writeStructBegin("AiravataClientException");

  xfer += oprot->writeFieldBegin("airavataErrorType", ::apache::thrift::protocol::T_I32, 1);
  xfer += oprot->writeI32((int32_t)this->airavataErrorType);
  xfer += oprot->writeFieldEnd();

  if (this->__isset.parameter) {
    xfer += oprot->writeFieldBegin("parameter", ::apache::thrift::protocol::T_STRING, 2);
    xfer += oprot->writeString(this->parameter);
    xfer += oprot->writeFieldEnd();
  }
  xfer += oprot->writeFieldStop();
  xfer += oprot->writeStructEnd();
  return xfer;
}

void swap(AiravataClientException &a, AiravataClientException &b) {
  using ::std::swap;
  swap(a.airavataErrorType, b.airavataErrorType);
  swap(a.parameter, b.parameter);
  swap(a.__isset, b.__isset);
}

const char* AiravataSystemException::ascii_fingerprint = "24652790C81ECE22B629CB60A19F1E93";
const uint8_t AiravataSystemException::binary_fingerprint[16] = {0x24,0x65,0x27,0x90,0xC8,0x1E,0xCE,0x22,0xB6,0x29,0xCB,0x60,0xA1,0x9F,0x1E,0x93};

uint32_t AiravataSystemException::read(::apache::thrift::protocol::TProtocol* iprot) {

  uint32_t xfer = 0;
  std::string fname;
  ::apache::thrift::protocol::TType ftype;
  int16_t fid;

  xfer += iprot->readStructBegin(fname);

  using ::apache::thrift::protocol::TProtocolException;

  bool isset_airavataErrorType = false;

  while (true)
  {
    xfer += iprot->readFieldBegin(fname, ftype, fid);
    if (ftype == ::apache::thrift::protocol::T_STOP) {
      break;
    }
    switch (fid)
    {
      case 1:
        if (ftype == ::apache::thrift::protocol::T_I32) {
          int32_t ecast1;
          xfer += iprot->readI32(ecast1);
          this->airavataErrorType = (AiravataErrorType::type)ecast1;
          isset_airavataErrorType = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 2:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->message);
          this->__isset.message = true;
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

  if (!isset_airavataErrorType)
    throw TProtocolException(TProtocolException::INVALID_DATA);
  return xfer;
}

uint32_t AiravataSystemException::write(::apache::thrift::protocol::TProtocol* oprot) const {
  uint32_t xfer = 0;
  xfer += oprot->writeStructBegin("AiravataSystemException");

  xfer += oprot->writeFieldBegin("airavataErrorType", ::apache::thrift::protocol::T_I32, 1);
  xfer += oprot->writeI32((int32_t)this->airavataErrorType);
  xfer += oprot->writeFieldEnd();

  if (this->__isset.message) {
    xfer += oprot->writeFieldBegin("message", ::apache::thrift::protocol::T_STRING, 2);
    xfer += oprot->writeString(this->message);
    xfer += oprot->writeFieldEnd();
  }
  xfer += oprot->writeFieldStop();
  xfer += oprot->writeStructEnd();
  return xfer;
}

void swap(AiravataSystemException &a, AiravataSystemException &b) {
  using ::std::swap;
  swap(a.airavataErrorType, b.airavataErrorType);
  swap(a.message, b.message);
  swap(a.__isset, b.__isset);
}

}}} // namespace
