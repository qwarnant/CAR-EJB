package fr.univ.lille1.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * Cette classe représente l'entité Book en base de données, ainsi que tous les
 * champs associés
 *
 * @author Quentin Warnant
 * @version 1.0
 */
@Table(name = "BOOK")
@Entity
@NamedQueries(value = {
    @NamedQuery(name = "allBooks", query = "SELECT b FROM Book b"),
    @NamedQuery(name = "findByTitle", query = "SELECT b FROM Book b WHERE LOWER(b.title) = LOWER(:title)"),
    @NamedQuery(name = "findByTitlePart", query = "SELECT b FROM Book b WHERE LOWER(b.title) LIKE LOWER(:title)"),
    @NamedQuery(name = "findByAuthor", query = "SELECT b FROM Book b WHERE LOWER(b.author) = LOWER(:author)"),
    @NamedQuery(name = "allAuthors", query = "SELECT DISTINCT(b.author) FROM Book b"),})
public class Book implements Serializable {

    private static final long serialVersionUID = 2661035917971849256L;

    @Id
    private String title;
    @JoinColumn(nullable = false)
    private String author;
    @Column(nullable = false)
    private int yearOfProd;

    @JoinTable(name = "BOOK_COMMAND", joinColumns = {
        @JoinColumn(name = "IDBOOK", referencedColumnName = "TITLE")}, inverseJoinColumns = {
        @JoinColumn(name = "IDCOMMAND", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Command> commandCollection;

    /**
     * Constructeur par défaut
     */
    public Book() {
    }

    /**
     * Constructeur
     *
     * @param titre String le titre du livre
     * @param author String l'auteur du livre
     * @param yearOfProd int l'année de publication du livre
     */
    public Book(String titre, String author, int yearOfProd) {
        this.title = titre;
        this.author = author;
        this.yearOfProd = yearOfProd;
    }

    /**
     * Cette méthode retourne le titre du livre
     *
     * @return String le titre du livre
     */
    public String getTitle() {
        return title;
    }

    /**
     * Cette méthode change le titre du livre courant
     *
     * @param title String le nouveau titre
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Cette méthode retourne l'auteur du livre
     *
     * @return String l'auteur du livre
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Cette méthode change l'auteur du livre courant
     *
     * @param author String le nouvel auteur
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Cette méthode retourne l'année de publication du livre
     *
     * @return int l'année de publication
     */
    public int getYearOfProd() {
        return yearOfProd;
    }

    /**
     * Cette méthode change l'année de publication du livre courant
     *
     * @param yearOfProd int l'année de publication
     */
    public void setYearOfProd(int yearOfProd) {
        this.yearOfProd = yearOfProd;
    }

    /**
     * Cette méthode retourne la liste des commandes auxquelles le livre courant
     * est associé
     *
     * @return List<Command> la liste des commandes
     */
    public Collection<Command> getCommandCollection() {
        return commandCollection;
    }

    /**
     * Cette méthode change la liste des commandes auxquelles le livre courant
     * est associé
     *
     * @param commandCollection Collection<Command> la nouvelle liste des
     * commandes
     */
    public void setCommandCollection(Collection<Command> commandCollection) {
        this.commandCollection = commandCollection;
    }

}
