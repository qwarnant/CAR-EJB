# CAR-EJB
=====================
* Développement d'une application web J2EE
* Quentin Warnant
* 20/04/15

HOW TO
------------
* Pour lancer l'application web, il faut installer Netbeans IDE 8.0.2 en choisissant d'installer Glassfish server 4.1 lors du processus d'installation.
* Une fois glasshfish lancé, rendez-vous à l'adresse localhost:4848 dans votre navigateur pour ajouter deux JDBC Resources, "bookstore__nontx" et "bookstore__pm". L'application ne fonctionnera pas sans ces deux connexions.
* Enfin, vous pouvez enfin lancer l'application en appuyant sur le run de Netbeans, qui se chargera de lancer et déployer l'application web.

* Le projet a été compilé pour être lancé avec Java 7.

Introduction
------------
Ce package logiciel contient une implémentation d'une application web de gestion de commandes de livres en ligne grâce à J2EE.

Architecture
------------
* Projects
	* TransferMsgLauncher
		* fr.univ.lille1 (Contient les constructeurs de structures de données RMI)
	* TransferMsgNodeGraph
		* fr.univ.lille1 (Contient la structure de données du graphe RMI et son comportement)
	* TransferMsgNodeTree
		* fr.univ.lille1 (Contient la structure de données de l'arbre RMI et son comportement)
* Classes abstraites
    * SiteTreeIft (Interface représentant un noeud de l'arbre RMI)
    * SiteGraphIft (Interface représentant un noeud du graphe RMI)
* Erreurs
    * catch dans les noeuds lorsqu'une RemoteException intervient
    * catch dans les constructeurs de structures de données si une RemoteException intervient
    
Code samples
------------
1. Nous avons implémenté la transmission de messages RMI grâce à une structure de données de type arbre où
chaque client RMI représente un noeud de l'arbre. Chaque noeud possède un père et deux fils. Nous avons créé
un constructeur d'arbre qui se charge de construire l'arbre et de faire les relations entre noeuds.

```java
	private static void buildTree() throws RemoteException {
		NODES[1].buildNode(null, new SiteTreeItf[] { NODES[2], NODES[5] });
		NODES[2].buildNode(NODES[1], new SiteTreeItf[] { NODES[3], NODES[4] });
		NODES[3].buildNode(NODES[2], null);
		NODES[4].buildNode(NODES[2], null);
		NODES[5].buildNode(NODES[1], new SiteTreeItf[] { NODES[6] });
		NODES[6].buildNode(NODES[5], null);
	}
```

2. Nous avons  également implémenté la transmission de messages RMI grâce à une structure de données de type graphe où
chaque client RMI représente un noeud du graphe. Chaque noeud possède une liste de noeuds connectés. Nous avons créé
un constructeur de graphe qui se charge de construire le graphe et de faire les relations entre noeuds.

```java
	private static void buildGraph() throws RemoteException {
		NODES[1].buildNode(new SiteGraphItf[] { NODES[2], NODES[5] });
		NODES[2].buildNode(new SiteGraphItf[] { NODES[1], NODES[3], NODES[4] });
		NODES[3].buildNode(new SiteGraphItf[] { NODES[2] });
		NODES[4].buildNode(new SiteGraphItf[] { NODES[2], NODES[6] });
		NODES[5].buildNode(new SiteGraphItf[] { NODES[1], NODES[6] });
		NODES[6].buildNode(new SiteGraphItf[] { NODES[4], NODES[5] });
	}
```