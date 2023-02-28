package if4030.soap;

public class RandomServiceClient {

    public static void main( String args[] ) {
        if( args.length == 0 ) return;
        try {
            RandomServiceStub random = new RandomServiceStub( "http://" + args[0] + ":8080/axis2/services/RandomService" );
            if( args.length == 1 ) {
                RandomServiceStub.NextRandom request = new RandomServiceStub.NextRandom();
                // TODO: 10 appels à nextRandom
            }
            if( args.length == 3 ) {
                // TODO:  appel de setBounds
             }
        }
        catch ( Exception e ) {
            System.err.println( "Client exception: " + e.toString() );
            e.printStackTrace();
        }
    }
}
