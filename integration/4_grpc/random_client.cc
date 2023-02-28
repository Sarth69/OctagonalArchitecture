#include <iostream>
#include <string>
#include <memory>

#include <cstdlib>

#include <grpc++/grpc++.h>

#include "random.pb.h"
#include "random.grpc.pb.h"

using grpc::Channel;
using grpc::ClientContext;
using grpc::Status;

using if3040::grpc::RandomService;
using if3040::grpc::SetBoundsRequest;
using if3040::grpc::SetBoundsResponse;
using if3040::grpc::NextRandomRequest;
using if3040::grpc::NextRandomResponse;

int main( int argc, char* argv[] )
{
    if( argc == 1 ) return -1;
    std::string host{ argv[1] };

    std::shared_ptr< Channel > channel = grpc::CreateChannel( host + ":50051", grpc::InsecureChannelCredentials() );
    std::unique_ptr< RandomService::Stub > stub( RandomService::NewStub( channel ));
    
    if( argc == 2 ) {
        // TODO : 10 appels à NextRandom
    }

    if( argc == 4 ) {
        // TODO : appel à SetBounds avec argv[2] et argv[3]
    }

    return 0;
}

