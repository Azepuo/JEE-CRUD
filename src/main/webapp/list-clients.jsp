<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
  <meta charset="UTF-8" />
  <title>Liste des Clients</title>
  <link rel="stylesheet" href="css/style.css" />
</head>
<body>
  <div class="container">
    <h2>Clients</h2>
    
    <!-- Barre de recherche -->
    <form action="clients" method="get" class="search-form">
      <input type="hidden" name="action" value="search" />
      <input type="text" name="query" placeholder="Rechercher par nom ou email"
             value="${fn:escapeXml(query)}" />
      <button type="submit">🔍</button>
    </form>
    
    <p><a class="btn" href="clients?action=new">+ Ajouter un client</a></p>

    <table class="table">
      <thead>
        <tr><th>ID</th><th>Nom</th><th>Email</th><th>Téléphone</th><th>Actions</th></tr>
      </thead>
      <tbody>
      <c:forEach var="c" items="${listeClients}">
        <tr>
          <td>${c.id}</td>
          <td>${c.nom}</td>
          <td>${c.email}</td>
          <td>${c.telephone}</td>
          <td>
            <a class="action edit" href="clients?action=edit&id=${c.id}">Modifier</a>
            <a class="action delete"
               href="clients?action=delete&id=${c.id}"
               onclick="return confirm('Supprimer ce client ?');">Supprimer</a>
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
</body>
</html>
