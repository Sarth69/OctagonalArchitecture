
import random

from xmlrpc.server import SimpleXMLRPCServer
from xmlrpc.server import SimpleXMLRPCRequestHandler

# Restrict to a particular path.
class RequestHandler( SimpleXMLRPCRequestHandler ):
    rpc_paths = ( '/IF4030', )

# Create server
with SimpleXMLRPCServer(( 'localhost', 8000 ),
                        requestHandler = RequestHandler ) as server:

    # TODO: écrire la classe RandomServer

    server.register_instance( RandomServer() )
    print( "server ready" )

    server.serve_forever()
