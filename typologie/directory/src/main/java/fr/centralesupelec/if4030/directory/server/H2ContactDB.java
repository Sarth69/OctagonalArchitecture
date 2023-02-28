package fr.centralesupelec.if4030.directory.server;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import org.h2.tools.Server;

import fr.centralesupelec.if4030.directory.business.IContactData;

public class H2ContactDB implements IContactData {

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
        Integer id = db.newContact( "Ada", "Lovelace" );
        System.out.println("list is " + db.getIds());
        // db.addPhone( id, 123456 );
        System.out.println( "firstName: " + db.getFirstName( 1 ));
        System.out.println( "lastName: " + db.getLastName( 1 ));
        // System.out.println( "phone: " + db.getPhones(1).get( 0 ));
        System.out.println( "Look at http://localhost:8082 then press return to stop" );
        Scanner s = new Scanner( System.in );
        @SuppressWarnings( "unused" )
        String stop = s.nextLine();
        s.close();
        db.stop();
    }

    @Override
    public List<Integer> getIds() {
        return entityManager
            .createQuery("FROM Person", Person.class)
            .getResultList()
            .stream()
            .map(person -> person.getId())
            .collect(Collectors.toList());
    }

    @Override
    public Integer newContact(String firstName, String lastName) {
        Person person = new Person(firstName, lastName);
        entityManager.getTransaction().begin();
        entityManager.persist(person);
        entityManager.getTransaction().commit();
        return person.getId();
    }

    private Person getPerson(Integer id) {
        return entityManager
            .createQuery("SELECT p FROM Person p WHERE p.id = :id", Person.class)
            .setParameter("id",id)
            .getSingleResult();
    }

    @Override
    public String getFirstName(Integer id) {
        return getPerson(id).getGivenName();
    }

    @Override
    public String getLastName(Integer id) {
        return getPerson(id).getName();
    }

    @Override
    public List<Integer> getPhones(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPhones'");
    }

    @Override
    public void addPhone(Integer id, Integer phone) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addPhone'");
    }
}
