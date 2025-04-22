<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Liste des Clients</title>
</head>
<body>
    <h2>Clients</h2>
    <p><a href="clients?action=new">+ Ajouter un client</a></p>
    <table border="1" cellpadding="5" cellspacing="0">
        <tr>
            <th>ID</th><th>Nom</th><th>Email</th><th>Téléphone</th><th>Actions</th>
        </tr>
        <c:forEach var="c" items="${listeClients}">
            <tr>
                <td>${c.id}</td>
                <td>${c.nom}</td>
                <td>${c.email}</td>
                <td>${c.telephone}</td>
                <td>
                    <a href="clients?action=edit&id=${c.id}">Modifier</a> |
                    <a href="clients?action=delete&id=${c.id}" onclick="return confirm('Supprimer ce client ?');">Supprimer</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>