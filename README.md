# CAR-EJB
=====================
* Développement d'une application web J2EE
* Quentin Warnant
* 20/04/15
* Une version en ligne de ce readme est disponible sur le répertoire github : https://github.com/qwarnant/CAR-EJB

HOW TO
------------
* Pour lancer l'application web, il faut installer Netbeans IDE 8.0.2 en choisissant d'installer Glassfish server 4.1 lors du processus d'installation.
* Une fois glasshfish lancé, rendez-vous à l'adresse localhost:4848 dans votre navigateur pour ajouter deux JDBC Resources, "bookstore__nontx" et "bookstore__pm". L'application ne fonctionnera pas sans ces deux connexions.
* Enfin, vous pouvez enfin lancer l'application en appuyant sur le run de Netbeans, qui se chargera de lancer et déployer l'application web.

* Le projet est directement importable et exécutable dans l'IDE Netbeans 8.0.2.
* Le projet a été compilé pour être lancé avec Java 7.

Introduction
------------
Ce package logiciel contient une implémentation d'une application web de gestion de commandes de livres en ligne grâce à J2EE.
Les fonctionnalités de notre application sont les suivantes :
* Initialisation de l'application avec une base de livres
* Possibilité de lister les auteurs
* Possibilité de recherche un livre grâce à son titre (ou une partie)
* Possibilité d'ajouter un livre en base de données
* Possibilité d'ajouter ou de supprimer un livre de son panier
* Possibilité de passer commande
* Possibilité de lister les commandes effectuées

Architecture
------------
* dist
	* javadoc : La documentation de tout le projet
* nbproject : Fichiers de configuration propres à Netbeans
* setup : Fichiers de configuration propres à l'environnement serveur Glassfish
* src
	* java
		* dal : Contient la couche d'accès à la base de données et à toutes les tables
		* entities : Contient les classes métiers de l'application web
		* exception : Contient les classes d'exception
		* service : Contient tous les servlets qui permettent d'afficher les pages de l'application web
* test : Contient les tests unitaires liés aux entités et à la couche DAL
* web : Contient les pages JSP de l'application web

* Erreurs
    * catch dans les créations de livres si le livre existe déjà en base de données avec BookAlreadyExistException
    * catch dans les doPost/doGet des servlets pour afficher des messages d'erreur précis dans les pages à l'utilisateur en cas de problème
    
Code samples
------------

1. Nous avons utilisé des annotations de persistance et des NamedQuery directement dans les classes entités du domaine métier de l'application.
```java
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
```

2. Nous avons implémenté un routeur de requêtes sous la forme d'un switch dans un servlet grâce à Java 7. On peut donc facilement rajouter une action supplémentaire sans devoir rajouter des if successifs dans la méthode doGet.

```java
        switch (request.getParameter("action")) {
            case "add":
                try {
                    cmdSession.addToCart(request.getParameter("title"));
                    returnView = "/booklist";
                } catch (Exception e) {
                    infocmd = "une erreur est survenue lors de l'ajout du livre";
                }
                break;
            case "del":
                try {
                    cmdSession.removeFromCart(request.getParameter("title"));
                    returnView = "/cart.jsp";
                } catch (Exception e) {
                    infocmd = "une erreur est survenue lors de la suppression du livre";
                }
                break;
            case "cmd":
                try {
                    cmdSession.saveCommand(new Client());
                    returnView = "/index.jsp";
                } catch (Exception e) {
                    infocmd = "une erreur est survenue lors de l'ajout de votre commande ";
                }
                break;
            case "list":
                try {
                    request.setAttribute("commands", cmdSession.getCommands());
                    returnView = "/commands.jsp";
                } catch (Exception e) {
                    infocmd = "une erreur est survenue lors de la récupération des commandes.";
                }
                break;
            case "view":
                try {
                    request.setAttribute("books", cmdSession.getCart());
                    returnView = "/cart.jsp";
                } catch (Exception e) {
                    infocmd = "une erreur est survenue lors de la récupération du panier.";
                }
                break;
        }
```

3. Enfin, nous avons commencé à implémenter une gestion utilisateur et administrateur dans l'application web avec une table supplémentaire dans la base de données. Nous n'avons malheureusement pas eu le temps de finir cette partie pour le rendu.
```java
    public boolean setAdmin(String username) throws Exception {
        try {
            Client user = getUserByUsername(username);
            user.setAdmin(true);
            em.persist(user);
            return true;
        } catch (NoUserExistException e) {
            return false;
        }

    }
```