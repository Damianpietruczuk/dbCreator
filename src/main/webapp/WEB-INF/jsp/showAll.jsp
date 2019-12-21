<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<table border="2" width="70%" cellpadding="2">
    <tr>
        <th>Nazwa</th>
    </tr>
    <c:forEach var="name" items="${list}">
    <tr>
        <td>
            <form:form method="post" action="show">
                <input type="submit" name="${name}" value="${name}"/>
            </form:form>
        </td>
    </tr>
    </c:forEach>
    <tr><a href="/">Strona glowna</a></tr>
</table>