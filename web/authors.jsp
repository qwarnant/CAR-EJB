<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="header.jsp" %>

<h2>Auteurs :</h2>
<c:choose>

    <c:when test="${error == true}">
        <h3>Il y a eu une erreur dans la recheche des auteurs.</h3>
    </c:when> 
    <c:otherwise>
        
        <c:if test="${authors != null}">
            <ul>
            <c:forEach var="name"  items="${authors}" >
                <li> <c:out value="${name}"/> </li>
                
            </c:forEach>
            </ul>
        </c:if>
    </c:otherwise>    
</c:choose>

<%@include file="footer.jsp" %>