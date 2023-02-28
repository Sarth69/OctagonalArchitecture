package fr.centralesupelec.if4030.directory.business;
import java.util.List;

public interface IContactData {
    // Obtention de la liste des identifiants
    List< Integer > getIds();
 
    // Ajout d'un nouveau contact, son identifiant est retourné
    Integer newContact( String firstName, String lastName );
 
    // Attributs du contact
    String getFirstName( Integer id );
    String getLastName( Integer id );
 
    List< Integer > getPhones( Integer id );
    void addPhone( Integer id, Integer phone );
 
    // Permettre un arrêt propre
    void stop();
}
