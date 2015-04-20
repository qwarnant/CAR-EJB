<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="header.jsp" %>


<c:choose>
    <c:when test="${initBase != null && initBase == true && initUser != null && initUser == true}">
        <h3>La base de données a bien été rajoutée.</h3>
    </c:when> 
    <c:when test="${initBase != null && initBase == false  && initUser != null && initUser == false}">
        <h3>La base de données existe déja, rien a rajouter.</h3>
    </c:when> 
    <c:when test="${error == true}">
        <h3>Il y a eu une erreur dans l'init de la base de données.</h3>
    </c:when> 
    <c:otherwise>
    </c:otherwise>   
</c:choose>

<%@include file="footer.jsp" %>