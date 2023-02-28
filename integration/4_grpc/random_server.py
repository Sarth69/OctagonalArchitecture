from concurrent import futures
import logging
import random

import grpc
import random_pb2
import random_pb2_grpc


class RandomServer( random_pb2_grpc.RandomServiceServicer ):

    def SetBounds( self, request, context ):
        # TODO
        return

    def NextRandom( self, request, context ):
        # TODO
        return

def serve():
    server = grpc.server( futures.ThreadPoolExecutor( max_workers=10 ))
    random_pb2_grpc.add_RandomServiceServicer_to_server( RandomServer(), server )
    server.add_insecure_port( '[::]:50051' )
    server.start()
    print( "server ready" )
    server.wait_for_termination()


if __name__ == '__main__':
    logging.basicConfig()
    serve()

