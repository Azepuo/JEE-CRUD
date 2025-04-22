<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Formulaire Client</title>
</head>
<body>
    <h2>
        <c:choose>
            <c:when test="${not empty client}">Modifier Client</c:when>
            <c:otherwise>Nouveau Client</c:otherwise>
        </c:choose>
    </h2>
    <form action="clients" method="post">
        <input type="hidden" name="id" value="${client.id}" />
        <p>Nom      : <input type="text" name="nom" value="${client.nom}" required /></p>
        <p>Email    : <input type="email" name="email" value="${client.email}" required /></p>
        <p>Téléphone: <input type="text" name="telephone" value="${client.telephone}" /></p>
        <p><button type="submit">Enregistrer</button></p>
    </form>
    <p><a href="clients"> Retour à la liste</a></p>
</body>
</html>