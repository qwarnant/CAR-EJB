<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="header.jsp" %>

<h2>Livres :</h2>
<c:choose>

    <c:when test="${error == true}">
        <h3>Il y a eu une erreur dans la recherche des livres.</h3>
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

<%@include file="footer.jsp" %>