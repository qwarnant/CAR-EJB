<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="header.jsp" %>

<h1>Ajout de Livre</h1>

<form method="post" action="addBook">
    <label for="title">Titre : </label><br>
    <input type="text" id="title" name="title" value="<c:out value="${param.title}"/>" required/>
    <br><label for="author">Auteur : </label><br>
    <input type="text" id="author" name="author" value="<c:out value="${param.author}"/>" required/>
    <br><label for="year">Année : </label><br>
    <input type="number" id="year" name="year" min="0" value="<c:out value="${param.year}"/>" required/>
    <br>
    <input type="submit" value="Ajouter"/>
</form>


<c:if test="${bookinfo != null}">
    <!-- Information complémentaire sur l'état de l'ajout du livre-->
   <span class="information">${bookinfo}</span>
</c:if>

<c:if test="${resume != null}">
   <!-- Récapitulatif du formulaire -->
   <h2>Récapitulatif</h2>
    Titre :  ${param.title} <br/> 
    Auteur :  ${param.author} <br/>
    Année :  ${param.year} <br/>
</c:if>


<%@include file="footer.jsp" %>