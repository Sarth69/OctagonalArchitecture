package fr.centralesupelec.if4030.directory.user;

import java.util.List;
import java.util.Scanner;

import fr.centralesupelec.if4030.directory.business.IAddEntry;
import fr.centralesupelec.if4030.directory.business.IContact;
import fr.centralesupelec.if4030.directory.business.ISearch;

public class ConsoleAdapter {

    private ISearch search;
    private IAddEntry addEntry;

    public ConsoleAdapter( ISearch search, IAddEntry addEntry ) {
        this.search = search;
        this.addEntry = addEntry;
    }

    public void run() {
        Scanner input = new Scanner( System.in );
        System.out.println( "Commandes disponiblles :" );
        System.out.println( "q : quitter" );
        System.out.println( "a <chaîne> : afficher les contacts dont le nom ou le prénom contient la <chaîne> donnée en argument (sans tenir compte de la casse)" );
        System.out.println( "c <prénom> <nom> <numéro> : ajouter le <numéro> de téléphone au contact \"<prénom> <nom>\" (qui est créé s'il n'existe pas encore)" );
        while( true ) {
            System.out.print( "Commande : " );
            String command = input.next();
            if( command.startsWith( "q" )) break;

            if( command.startsWith( "a" )) {
                List< IContact > list = search.search( input.next() );
                for( IContact contact : list ) {
                    System.out.print( contact.getFirstName() + " " + contact.getLastName().toUpperCase() + " : " );
                    for( Integer p : contact.getPhones() ) {
                        System.out.print( p + " " );
                    }
                    System.out.println();
                }
                continue;
            }

            if( command.startsWith( "c" )) {
                addEntry.addPhone( input.next(), input.next(), Integer.valueOf( input.next() ));
            }

        }

        input.close();
    }
}
