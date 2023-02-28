package if4030.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RandomClient {

    public static void main( String[] args ) {
        if( args.length == 0 ) return;
        try {
            Registry registry = LocateRegistry.getRegistry( args[0], 10099 );
            IRandom random = ( IRandom ) registry.lookup( "Random" );
            // TODO
            
        }
        catch ( Exception e ) {
            System.err.println( "Client exception: " + e.toString() );
            e.printStackTrace();
        }
    }
}
