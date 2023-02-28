package fr.centralesupelec.if4030.directory.business;
import java.util.List;

public interface IContact {
    String getFirstName();
    String getLastName();
    List< Integer > getPhones();
}
