<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>BookStore</title>
</head>
<body>
<nav>
    <ul>
        <li><a href="<c:url value="/init"/>">Initialisation</a></li>
        <li><a href="<c:url value="/registration"/>">Ajouter un livre</a></li>
        <li><a href="<c:url value="/search"/>">Rechercher un livre</a></li>
        <li><a href="<c:url value="/booklist"/>">Lister les livres</a></li>
        <li><a href="<c:url value="/authors"/>">Lister les auteurs</a></li>
        <li><a href="<c:url value="/cart?action=view"/>">Consulter le panier</a></li>
        <li><a href="<c:url value="/cart?action=list"/>">Liste des commandes</a></li>
    </ul>
</nav>
