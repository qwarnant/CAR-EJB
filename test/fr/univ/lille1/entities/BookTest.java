/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ.lille1.entities;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * Cette classe de tests unitaires permet de valider les méthodes de la classe Book
 * 
 * @author Quentin Warnant
 * @version 1.0
 */
public class BookTest {
    
    public BookTest() {
    }

    /**
     * Test of getTitle method, of class Book.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        Book instance = new Book("title", "author", 2006);
        String expResult = "title";
        String result = instance.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTitle method, of class Book.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        String title = "title";
        Book instance = new Book();
        instance.setTitle(title);
        assertEquals(title, instance.getTitle());
    }

    /**
     * Test of getAuthor method, of class Book.
     */
    @Test
    public void testGetAuthor() {
        System.out.println("getAuthor");
        Book instance = new Book("title", "author", 2006);
        String expResult = "author";
        String result = instance.getAuthor();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAuthor method, of class Book.
     */
    @Test
    public void testSetAuthor() {
        System.out.println("setAuthor");
        String author = "author";
        Book instance = new Book();
        instance.setAuthor(author);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(author, instance.getAuthor());
    }

    /**
     * Test of getYearOfProd method, of class Book.
     */
    @Test
    public void testGetYearOfProd() {
        System.out.println("getYearOfProd");
        Book instance = new Book("title", "author", 2006);
        int expResult = 2006;
        int result = instance.getYearOfProd();
        assertEquals(expResult, result);
    }

    /**
     * Test of setYearOfProd method, of class Book.
     */
    @Test
    public void testSetYearOfProd() {
        System.out.println("setYearOfProd");
        int yearOfProd = 2006;
        Book instance = new Book();
        instance.setYearOfProd(yearOfProd);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(yearOfProd, instance.getYearOfProd());
    }
    
}
