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
 * Cette classe de tests unitaires permet de valider les méthodes de la classe Command
 * 
 * @author Quentin Warnant
 * @version 1.0
 */
public class CommandTest {
    
    public CommandTest() {
    }
    
    /**
     * Test of setBooks method, of class Command.
     */
    @Test
    public void testSetBooks() {
        System.out.println("setBooks");
        Command instance = new Command();
        Book book1 = new Book();
        Book book2 = new Book();
        
        Collection<Book> expResult = new ArrayList<>();
        expResult.add(book2);
        expResult.add(book1);
        instance.setBooks(expResult);
        
        Collection<Book> result = instance.getBooks();
        assertEquals(expResult.size(), result.size());
    }

    /**
     * Test of getBooks method, of class Command.
     */
    @Test
    public void testGetBooks() {
        System.out.println("getBooks");
        Command instance = new Command();
        assertNotNull(instance.getBooks());
    }

    /**
     * Test of getClient method, of class Command.
     */
    @Test
    public void testGetClient() {
        System.out.println("getClient");
        Command instance = new Command();
        Client result = instance.getClient();
        assertNull(result);
    }

    /**
     * Test of setClient method, of class Command.
     */
    @Test
    public void testSetClient() {
        System.out.println("setClient");
        Client client = new Client();
        Command instance = new Command();
        instance.setClient(client);
        assertNotNull(instance.getClient());
    }
    
}
