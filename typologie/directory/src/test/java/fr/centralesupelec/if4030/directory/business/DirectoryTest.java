package fr.centralesupelec.if4030.directory.business;
 
 
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
 
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
 
@ExtendWith(MockitoExtension.class)
public class DirectoryTest {
    @Mock
    private IContactData data;
    private Directory directory;
 
    @BeforeEach
    public void setupMock() {
        // Vérification de la création du bouchon
        assertNotNull( data );
        // 1 contact dans notre bouchon pour commencer
        when( data.getIds() ).thenReturn( List.of( 1 ));
        // Le prénom du premier contact
        when( data.getFirstName( 1 )).thenReturn( "Ada" );
        when( data.getLastName( 1 )).thenReturn( "Lovelacet" );
        when( data.getPhones( 1 )).thenReturn( List.of(0606060606, 0101) );
        directory = new Directory( data );
    }
 
    @Test
    public void testUnsucessfulSearch() {
        List< IContact > contacts = directory.search( "zzzzzzzzzzz" );
        assertNotNull( contacts );
        assertEquals( 0, contacts.size() );
    }
 
    @Test
    public void testSucessfulSearch() {
        List< IContact > contacts = directory.search( "lovelace" );
        assertNotNull( contacts );
        assertEquals( 1, contacts.size() );
        assertEquals("Ada", contacts.get(0).getFirstName());
        assertEquals("Lovelacet", contacts.get(0).getLastName());
        assertEquals(0606060606, contacts.get(0).getPhones().get(0));
        assertEquals(0101, contacts.get(0).getPhones().get(1));
    }
 
}