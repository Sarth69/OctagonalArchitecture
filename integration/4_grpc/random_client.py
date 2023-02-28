import sys
import logging
import grpc

import random_pb2
import random_pb2_grpc


def callNextRandom( hostname ):
        # TODO
        return

def callSetBounds( hostname, _min, _max ):
        # TODO
        return


if __name__ == '__main__':
    logging.basicConfig()
    if len( sys.argv ) == 2:
        callNextRandom( sys.argv[1] )
    if len( sys.argv ) == 4:
        callSetBounds( sys.argv[1], int( sys.argv[2] ), int( sys.argv[3] ))

