package fr.univ.lille1.dal;

import fr.univ.lille1.entities.Client;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * Cette classe de tests unitaires permet de valider les méthodes de la couche DAL pour les clients
 * 
 * @author Quentin Warnant
 * @version 1.0
 */
public class ClientDalImplTest {
    
    public ClientDalImplTest() {
    }
  
    /**
     * Test of init method, of class ClientDalImpl.
     */
    @Test
    public void testInit() throws Exception {
        System.out.println("init");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ClientDal instance = (ClientDal)container.getContext().lookup("java:global/classes/ClientDalImpl");
        boolean expResult = true;
        boolean result = instance.init();
        assertEquals(expResult, result);
        container.close();
    }

    /**
     * Test of getUsers method, of class ClientDalImpl.
     */
    @Test
    public void testGetUsers() throws Exception {
        System.out.println("getUsers");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ClientDal instance = (ClientDal)container.getContext().lookup("java:global/classes/ClientDalImpl");
        List<Client> result = instance.getUsers();
        assertNotSame(0, result.size());
        container.close();
    }

    /**
     * Test of getUserByUsername method, of class ClientDalImpl.
     */
    @Test
    public void testGetUserByUsername() throws Exception {
        System.out.println("getUserByUsername");
        String username = "quentin1";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ClientDal instance = (ClientDal)container.getContext().lookup("java:global/classes/ClientDalImpl");
        Client result = instance.getUserByUsername(username);
        assertNotNull(result);
        container.close();
    }

    /**
     * Test of addUser method, of class ClientDalImpl.
     */
    @Test
    public void testAddUser() throws Exception {
        System.out.println("addUser");
        String username = "quentin3";
        String password = "password3";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ClientDal instance = (ClientDal)container.getContext().lookup("java:global/classes/ClientDalImpl");
        boolean expResult = true;
        boolean result = instance.addUser(username, password);
        assertEquals(expResult, result);
        container.close();
    }

    /**
     * Test of setAdmin method, of class ClientDalImpl.
     */
    @Test
    public void testSetAdmin() throws Exception {
        System.out.println("setAdmin");
        String username = "quentin3";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ClientDal instance = (ClientDal)container.getContext().lookup("java:global/classes/ClientDalImpl");
        boolean expResult = true;
        boolean result = instance.setAdmin(username);
        assertEquals(expResult, result);
        container.close();
    }
    
}
