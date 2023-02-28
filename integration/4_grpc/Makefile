
.PHONY: all clean

PROGS = random_server random_client

PROTO_CPP_SRC = random.pb.cc
PROTO_CPP_H = random.pb.h
PROTO_PYTHON_SRC = random_pb2.py
GRPC_CPP_SRC = random.grpc.pb.cc
GRPC_CPP_H = random.grpc.pb.h
GRPC_PYTHON_SRC = random_pb2_grpc.py

RANDOM_CPP_SRC = random_server.cc random_client.cc

CPP_SRC = $(PROTO_CPP_SRC) $(GRPC_CPP_SRC) $(RANDOM_CPP_SRC)

OBJS = $(CPP_SRC:%.cc=%.o)

CPPFLAGS += `pkg-config --cflags protobuf grpc`
CXXFLAGS += -std=c++11

HOST_SYSTEM = $(shell uname | cut -f 1 -d_)
SYSTEM ?= $(HOST_SYSTEM)
ifeq ($(SYSTEM),Darwin)
LIBS += -L/usr/local/lib `pkg-config --libs protobuf grpc++`\
        -pthread\
        -lgrpc++_reflection\
        -ldl
else
LIBS += -L/usr/local/lib `pkg-config --libs protobuf grpc++`\
        -pthread\
        -Wl,--no-as-needed -lgrpc++_reflection -Wl,--as-needed\
        -ldl
endif

PROTOC = protoc
GRPC_CPP_PLUGIN = grpc_cpp_plugin
GRPC_CPP_PLUGIN_PATH ?= `which $(GRPC_CPP_PLUGIN)`

PYTHON = python3

all: $(PROGS) $(PROTO_PYTHON_SRC) $(GRPC_PYTHON_SRC)

random_server: random_server.o random.grpc.pb.o random.pb.o
	$(CXX) $(CXXFLAGS) $(LDFLAGS) -o $@ $^ $(LIBS)

random_client: random_client.o random.grpc.pb.o random.pb.o
	$(CXX) $(CXXFLAGS) $(LDFLAGS) -o $@ $^ $(LIBS)

$(PROTO_CPP_SRC) $(PROTO_CPP_H): random.proto
	$(PROTOC) --cpp_out=. random.proto

$(PROTO_PYTHON_SRC): random.proto
	$(PYTHON) -m grpc_tools.protoc --python_out=. -I. random.proto

$(GRPC_CPP_SRC) $(GRPC_CPP_H): random.proto
	$(PROTOC) --grpc_out=. --plugin=protoc-gen-grpc=$(GRPC_CPP_PLUGIN_PATH) random.proto

$(GRPC_PYTHON_SRC): random.proto
	$(PYTHON) -m grpc_tools.protoc --grpc_python_out=. -I. random.proto

%.o: %.cc $(PROTO_CPP_H) $(GRPC_CPP_H)
	$(CXX) -c $(CXXFLAGS) $(CPPFLAGS) -o $@ $<

clean:
	rm -f $(PROGS) $(OBJS) $(PROTO_CPP_SRC) $(PROTO_CPP_H) $(PROTO_PYTHON_SRC) $(GRPC_CPP_SRC) $(GRPC_CPP_H) $(GRPC_PYTHON_SRC)

