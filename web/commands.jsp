<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="header.jsp" %>

<h2>Commandes effectuées :</h2>
<c:choose>

    <c:when test="${message!= null}">
        <h3>${message}</h3>
    </c:when> 
    <c:otherwise>
        
        <c:if test="${commands != null}">
            <ul>
            <c:forEach var="command"  items="${commands}" >
                <li> Commande N°${command.id}</li>
                <ul>
                    <c:forEach var="book"  items="${command.books}" >
                        <li>${book.title}</li>
                    </c:forEach>
                </ul>
            </c:forEach>
            </ul>
        </c:if>
    </c:otherwise>    
</c:choose>

<%@include file="footer.jsp" %>