package if4030.jms;

import javax.jms.Connection;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

public class RandomClient {
    private String name;
    private int nb;

    public RandomClient( String name, int nb ) {
        this.name = name;
        this.nb = nb;
    }

    public void run() {
        try {
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory( "tcp://localhost:61616" );
            Connection connection = connectionFactory.createConnection();
            connection.start();
            
            Session session = connection.createSession( false, Session.AUTO_ACKNOWLEDGE) ;
            Queue destination = session.createQueue( "IF4030.JMS" );
            MessageConsumer consumer = session.createConsumer( destination );
            
            int i = 0;
            while( i < nb ) {
                TextMessage message = ( TextMessage ) consumer.receive( 1000 );
                if( message != null ) {
                    System.out.println( "Consumer " + name + ": Received: " + message.getText() );
                    ++i;
                }
                else {
                    System.out.println( "Consumer " + name + ": No message received, waiting for another" );
                }
                Thread.sleep( ( int ) ( 400 * Math.random() ));
            }
            consumer.close();
            session.close();
            connection.close();
        }
        catch(Exception e) {
            System.out.println( "Consumer " + name + ": Caught: " + e );
            e.printStackTrace();
        }
    }
    
    public static void main( String[] args ) {
        String name = "0";
        if( args.length > 0 ) name = args[0];
        int nb = 10;
        if( args.length > 1 ) nb = Integer.valueOf( args[1] );
        System.out.println( "RandomClient " + name + " will consume " + nb + " messages" );
        new RandomClient( name, nb ).run();
    }

    static private class RandomClientListener implements MessageListener {
        private String name;
        private int nbReceivedMessages = 0;
        public RandomClientListener( String name ) {
            this.name = name;
        }
    
        @Override
        public void onMessage( Message message ) {
            try {
                System.out.println("Consumer " + name + ": Received: " + ((TextMessage)message).getText());
                ++nbReceivedMessages;
            }
            catch( Exception e ) {
                System.out.println("Consumer " + name + ": Caught: " + e);
                e.printStackTrace();
            }
        }

        public int getNbReceivedMessages() {
            return nbReceivedMessages;
        }
    }
}
