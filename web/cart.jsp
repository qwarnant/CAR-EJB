<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="header.jsp" %>

<h2>Contenu du panier :</h2>
<c:choose>

    <c:when test="${message != null}">
        <h3>${message}</h3>
    </c:when> 
    <c:otherwise>
        
        <c:if test="${books != null}">
            <ul>
            <c:forEach var="book"  items="${books}" >
                <li> <c:out value="${book.title}"/> par <c:out value="${book.author}"/> [<c:out value="${book.yearOfProd}"/>] <a href="<c:url value="/cart?action=del&title=${book.title}"/>">Retirer du panier</a></li>
            </c:forEach>
            </ul>
            <a href="<c:url value="/cart?action=cmd"/>">Passer la commande</a>
        </c:if>
    </c:otherwise>    
</c:choose>
<%@include file="footer.jsp" %>