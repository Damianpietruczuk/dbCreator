<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<body>
<h1>Wpisz dane swojej tabeli</h1>
<form:form method="post" action="save">

    <tr>
        <td>Nazwa tabeli :</td>
        <td><form:input path="name"/></td>
    </tr>
    <tr>
        <td>kolumna1 :</td>
        <td><form:input path="column1"/></td>
    </tr>
    <tr>
        <td>kolumna2 :</td>
        <td><form:input path="column2"/></td>
    </tr>
    <input type="submit" value="Dodaj">
</form:form>
</body>