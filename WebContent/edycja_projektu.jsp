<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edycja projektu</title>
<link rel="stylesheet" href="style.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;400&display=swap" rel="stylesheet">
</head>
<body>
<ul>
<li><a class="active" href="#about">ProjektHUB</a></li>
  <li><a href="#"> >> Lista projektów</a></li>
</ul>
<div id="center">
<c:url value="/EdytujProjekt" var="linkEdytujProjekt">
<c:param name="x_projekt_id" value="${requestScope.x_projekt_id}" />
	</c:url>
<h2>Edycja projektu: ${requestScope.projekt.nazwa}</h2>
<form action='${linkEdytujProjekt}' method="post">
Nazwa: <input type="text" value='${requestScope.projekt.nazwa}' name="nazwa">
Opis: <input type="text" value='${requestScope.projekt.opis}' name="opis">
Data oddania (RRRR-MM-DD): <input type="text" name="dataOddania" value='${requestScope.projekt.dataOddania}'> 
<input type="submit" value="Aktualizuj" />
</form>
</div>
</body>
</html>