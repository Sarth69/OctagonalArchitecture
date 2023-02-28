package if4030.jms;


import javax.jms.Connection;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

public class RandomServer {
    private String name;
    private int nb;
    private int min = 1;
    private int max = 100;

    public RandomServer( String name, int nb ) {
        this.name = name;
        this.nb = nb;
    }
    
    public void run() {
        try {
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory( "tcp://localhost:61616" );
            Connection connection = connectionFactory.createConnection();
            connection.start();
            
            Session session = connection.createSession( false, Session.AUTO_ACKNOWLEDGE );
            Queue destination = session.createQueue( "IF4030.JMS" );
            MessageProducer producer = session.createProducer( destination );
            
            for( int i = 0; i < nb; ++i ) {
                String message = "P" + name + ": " + nextRandom();
                System.out.println( "Producer " + name + ": Sending: " + message );
                producer.send( session.createTextMessage( message ));
                Thread.sleep( ( int ) ( 200 * Math.random() ));
            }
            producer.close();
            session.close();
            connection.close();
        }
        catch( Exception e ) {
            System.out.println( "Producer " + name + ": Caught: " + e );
            e.printStackTrace();
        }
    }
    
    public int nextRandom() {
        double alea = Math.random();
        return min + ( int ) (( max - min + 1 ) * alea );
    }

    public static void main( String[] args ) throws InterruptedException {
        String name = "0";
        if( args.length > 0 ) name = args[0];
        int nb = 10;
        if( args.length > 1 ) nb = Integer.valueOf( args[1] );
        System.out.println( "RandomServer " + name + " will produce " + nb + " messages" );
        new RandomServer( name, nb ).run();
    }
}
