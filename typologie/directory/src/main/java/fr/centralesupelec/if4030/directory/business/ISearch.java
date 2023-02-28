package fr.centralesupelec.if4030.directory.business;
import java.util.List;

public interface ISearch {
    List< IContact > search( String name );
}
