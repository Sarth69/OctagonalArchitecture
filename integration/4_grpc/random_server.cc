
#include <iostream>
#include <string>
#include <memory>

#include <cstdlib>

#include <grpc++/grpc++.h>

#include "random.pb.h"
#include "random.grpc.pb.h"

using grpc::Server;
using grpc::ServerBuilder;
using grpc::ServerContext;
using grpc::Status;

namespace if3040::grpc {

class RandomServer final : public RandomService::Service {
public:
    RandomServer() {}
    
    Status SetBounds( ServerContext * context,
                      const SetBoundsRequest *  request,
                      SetBoundsResponse  * response ) {
        // TODO
        return Status::OK;
    }
    
    Status NextRandom( ServerContext * context,
                       const NextRandomRequest * request,
                       NextRandomResponse * response ) {
        // TODO
        return Status::OK;
    }

private:
    // TODO
};

}


int main() {
    if3040::grpc::RandomServer random_server;
    
    std::string server_address( "0.0.0.0:50051" );
    ServerBuilder builder;
    builder.AddListeningPort( server_address, grpc::InsecureServerCredentials() );
    builder.RegisterService( &random_server );
    std::unique_ptr< Server > server( builder.BuildAndStart() );
    std::cout << "Server listening on " << server_address << std::endl;
    server->Wait();
    
    return 0;
}
