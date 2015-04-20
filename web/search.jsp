<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="header.jsp" %>

<h2>Recherche de livres :</h2>
<c:choose>

    <c:when test="${message != null}">
        <h3>Il y a eu une erreur dans la recherche des livres : ${message}</h3>
    </c:when> 
    <c:otherwise>
        
        <c:if test="${books != null}">
            <ul>
            <c:forEach var="book"  items="${books}" >
                <li> <c:out value="${book.title}"/> par <c:out value="${book.author}"/> [<c:out value="${book.yearOfProd}"/>] <a href="<c:url value="/cart?action=add&title=${book.title}"/>">Ajouter au panier</a></li>
                
            </c:forEach>
            </ul>
        </c:if>
    </c:otherwise>    
</c:choose>
<form method="post" action="search">
    <label for="title">Titre : </label><br>
    <input type="text" id="title" name="title" value="<c:out value="${param.title}"/>" required/>
    <br />
    <input type="submit" value="Rechercher"/>
</form>
<%@include file="footer.jsp" %>