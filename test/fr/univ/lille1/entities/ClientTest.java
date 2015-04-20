/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ.lille1.entities;

import java.util.ArrayList;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * Cette classe de tests unitaires permet de valider les méthodes de la classe Client
 * 
 * @author Quentin Warnant
 * @version 1.0
 */
public class ClientTest {
    
    public ClientTest() {
    }

    /**
     * Test of getUsername method, of class Client.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        Client instance = new Client("username", "password");
        String expResult = "username";
        String result = instance.getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUsername method, of class Client.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "username";
        Client instance = new Client();
        instance.setUsername(username);
        assertEquals(username, instance.getUsername());
    }

    /**
     * Test of getPassword method, of class Client.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Client instance = new Client("username", "password");
        String expResult = "password";
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPassword method, of class Client.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "password";
        Client instance = new Client();
        instance.setPassword(password);
        assertEquals(password, instance.getPassword());

    }

    /**
     * Test of isAdmin method, of class Client.
     */
    @Test
    public void testIsAdmin() {
        System.out.println("isAdmin");
        Client instance = new Client();
        boolean expResult = false;
        boolean result = instance.isAdmin();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAdmin method, of class Client.
     */
    @Test
    public void testSetAdmin() {
        System.out.println("setAdmin");
        boolean admin = true;
        Client instance = new Client();
        instance.setAdmin(admin);
        assertTrue(instance.isAdmin());
    }

    /**
     * Test of getCommands method, of class Client.
     */
    @Test
    public void testGetCommands() {
        System.out.println("getCommands");
        Client instance = new Client();
        Collection<Command> result = instance.getCommands();
        assertNotNull(result);
    }

    /**
     * Test of setCommands method, of class Client.
     */
    @Test
    public void testSetCommands() {
        System.out.println("setCommands");
        Collection<Command> commands = new ArrayList<Command>();
        Command command1 = new Command();
        commands.add(command1);
        
        Client instance = new Client();
        instance.setCommands(commands);

        assertEquals(commands.size(), instance.getCommands().size());
    }
    
}
