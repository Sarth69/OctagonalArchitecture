package if4030.xmlrpc;

import java.net.URL;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

public class RandomClient {

    public static void main( String[] args ) {
        if( args.length == 0 ) return;
        
        try {
            XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
            config.setServerURL( new URL( "http://" + args[0] + ":8000/IF4030" ));
            XmlRpcClient client = new XmlRpcClient();
            client.setConfig( config );
        
            // TODO: écrire le code du client
        }
        catch ( Exception e ) {
            System.err.println( "Client exception: " + e.toString() );
            e.printStackTrace();
        }
    }
}
