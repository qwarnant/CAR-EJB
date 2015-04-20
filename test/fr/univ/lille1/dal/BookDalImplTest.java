/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ.lille1.dal;

import fr.univ.lille1.entities.Book;
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
public class BookDalImplTest {
    
    public BookDalImplTest() {
    }
   

    /**
     * Test of init method, of class BookDalImpl.
     */
    @Test
    public void testInit() throws Exception {
        System.out.println("init");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BookDal instance = (BookDal)container.getContext().lookup("java:global/classes/BookDalImpl");
        boolean expResult = true;
        boolean result = instance.init();
        assertEquals(expResult, result);
        container.close();
    }

    /**
     * Test of getAuthors method, of class BookDalImpl.
     */
    @Test
    public void testGetAuthors() throws Exception {
        System.out.println("getAuthors");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BookDal instance = (BookDal)container.getContext().lookup("java:global/classes/BookDalImpl");
        List<String> result = instance.getAuthors();
        assertNotSame(0, result.size());
        container.close();
    }

    /**
     * Test of getBooks method, of class BookDalImpl.
     */
    @Test
    public void testGetBooks() throws Exception {
        System.out.println("getBooks");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BookDal instance = (BookDal)container.getContext().lookup("java:global/classes/BookDalImpl");
        List<Book> result = instance.getBooks();
        assertNotSame(0, result.size());
        container.close();
    }
   
    /**
     * Test of addBook method, of class BookDalImpl.
     */
    @Test
    public void testAddBook() throws Exception {
        System.out.println("addBook");
        String title = "title";
        String authorName = "author";
        int year = 2015;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BookDal instance = (BookDal)container.getContext().lookup("java:global/classes/BookDalImpl");
        instance.addBook(title, authorName, year);
        assertNotNull(instance.findBook("title"));
        container.close();
    }



    /**
     * Test of findBooks method, of class BookDalImpl.
     */
    @Test
    public void testFindBooks() throws Exception {
        System.out.println("findBooks");
        String titlePart = "title";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BookDal instance = (BookDal)container.getContext().lookup("java:global/classes/BookDalImpl");
        List<Book> result = instance.findBooks(titlePart);
        assertNotSame(0, result.size());
        container.close();
    }
    
}
