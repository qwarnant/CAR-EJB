package fr.univ.lille1.dal;

import fr.univ.lille1.entities.Book;
import fr.univ.lille1.entities.Client;
import fr.univ.lille1.entities.Command;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;


/**
 *
 * Cette classe de tests unitaires permet de tester la couche DAL pour les commandes
 * 
 * @author Quentin Warnant
 * @version 1.0
 */
public class CommandDalImplTest {
    
    private BookDal bookInstance;
    
    public CommandDalImplTest() {
    }

    @Before
    public void before() throws Exception {
       EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
       bookInstance = (BookDal)container.getContext().lookup("java:global/classes/BookDalImpl");
       bookInstance.init();
    }
    
    /**
     * Test of addToCart method, of class CommandDalImpl.
     */
    @Test
    public void testAddToCart() throws Exception {
        System.out.println("addToCart");
        String title = "Avengers T1";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CommandDal instance = (CommandDal)container.getContext().lookup("java:global/classes/CommandDalImpl");

        instance.addToCart(title);
        assertNotSame(0, instance.getCart().size());
        container.close();
    }

    /**
     * Test of removeFromCart method, of class CommandDalImpl.
     */
    @Test
    public void testRemoveFromCart() throws Exception {
        System.out.println("removeFromCart");
        String titre = "Avengers T1";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CommandDal instance = (CommandDal)container.getContext().lookup("java:global/classes/CommandDalImpl");
        instance.removeFromCart(titre);
        
        assertEquals(0, instance.getCart().size());
        container.close();
    }

    /**
     * Test of saveCommand method, of class CommandDalImpl.
     */
    @Test
    public void testSaveCommand() throws Exception {
        System.out.println("saveCommand");
        Client client = new Client(); // Mock
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CommandDal instance = (CommandDal)container.getContext().lookup("java:global/classes/CommandDalImpl");
        
        for(int i = 0; i < 4; i++) {
            instance.addToCart("Avengers T1");
        }
        
        instance.saveCommand(client);
        
        assertNotSame(0, instance.getCommands().size());
        container.close();
    }
    
    
    /**
     * Test of getCommands method, of class CommandDalImpl.
     */
    @Test
    public void testGetCommands() throws Exception {
        System.out.println("getCommands");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CommandDal instance = (CommandDal)container.getContext().lookup("java:global/classes/CommandDalImpl");
        List<Command> result = instance.getCommands();
        assertNotSame(0, result.size());
        container.close();
    }

    /**
     * Test of getNbBooks method, of class CommandDalImpl.
     */
    @Test
    public void testGetNbBooks() throws Exception {
        System.out.println("getNbBooks");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CommandDal instance = (CommandDal)container.getContext().lookup("java:global/classes/CommandDalImpl");
        
        for(int i = 0; i < 4; i++) {
            instance.addToCart("Avengers T1");
        }
        
        int expResult = 5;
        int result = instance.getNbBooks();
        assertEquals(expResult, result);
        container.close();
    }

    /**
     * Test of getCart method, of class CommandDalImpl.
     */
    @Test
    public void testGetCart() throws Exception {
        System.out.println("getCart");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CommandDal instance = (CommandDal)container.getContext().lookup("java:global/classes/CommandDalImpl");
        List<Book> result = instance.getCart();
        assertNotSame(0, result.size());
        container.close();
    }
}
