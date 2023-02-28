package fr.centralesupelec.if4030.directory.server;

import java.sql.SQLException;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import org.h2.tools.Server;

public class H2ContactDB {

    private EntityManager entityManager;
    private Server tcpServer;
    private Server webServer;

    public H2ContactDB() throws SQLException {
        tcpServer = Server.createTcpServer().start();
        webServer = Server.createWebServer( "-webAllowOthers" ).start();

        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "fr.centralesupelec.if4030.directory.pu" );
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void stop() {
        entityManager.close();
        tcpServer.stop();
        webServer.stop();
    }

    public static void main( String[] args ) throws SQLException {
        H2ContactDB db = new H2ContactDB();
//         Integer id = db.newContact( "Ada", "Lovelace" );
//         db.addPhone( id, 123456 );
//         System.out.println( "firstName: " + db.getFirstName( 1 ));
//         System.out.println( "lastName: " + db.getLastName( 1 ));
//         System.out.println( "phone: " + db.getPhones(1).get( 0 ));
        System.out.println( "Look at http://localhost:8082 then press return to stop" );
        Scanner s = new Scanner( System.in );
        @SuppressWarnings( "unused" )
        String stop = s.nextLine();
        s.close();
        db.stop();
    }
}
