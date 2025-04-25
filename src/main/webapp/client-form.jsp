<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<head>
    <meta charset="UTF-8" />
    <title>Formulaire Client</title>
    <link rel="stylesheet" href="css/style.css" />
</head>
<body>
  <div class="form-container">
    <h2>
      <c:choose>
        <c:when test="${not empty client}">Modifier Client</c:when>
        <c:otherwise>Nouveau Client</c:otherwise>
      </c:choose>
    </h2>
    <form action="clients" method="post" class="client-form">
      <input type="hidden" name="id" value="${client.id}" />
      <div class="form-group">
        <label for="nom">Nom :</label>
        <input id="nom" type="text" name="nom" value="${client.nom}" required />
      </div>
      <div class="form-group">
        <label for="email">Email :</label>
        <input id="email" type="email" name="email" value="${client.email}" required />
      </div>
      <div class="form-group">
        <label for="telephone">Téléphone :</label>
        <input id="telephone" type="text" name="telephone" value="${client.telephone}" />
      </div>
      <button type="submit" class="btn-submit">Enregistrer</button>
    </form>
    <p><a class="btn-back" href="clients">← Retour à la liste</a></p>
  </div>
</body>
