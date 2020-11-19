<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edycja zadania</title>
<link rel="stylesheet" href="style.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;400&display=swap" rel="stylesheet">
</head>
<body>
<ul>
<li><a class="active" href="#about">PeojektHUB</a></li>
  <li><a href="#"> >> Lista projektów</a></li>
</ul>
<div id="center">
<c:url value="/EdytujZadanie" var="linkEdytujZadanie">
<c:param name="x_zadanie_id" value="${requestScope.zadanie.zadanieId}" />
	</c:url>
<h2>Edycja zadania: ${requestScope.zadanie.nazwa}</h2>
<form action='${linkEdytujZadanie}' method="post">
Nazwa: <input type="text" value='${requestScope.zadanie.nazwa}' name="nazwa">
Opis: <input type="text" value='${requestScope.zadanie.opis}' name="opis">
Kolejność: <input type="text" name="kolejnosc" value='${requestScope.zadanie.kolejnosc}'/> 
<input type="submit" value="Aktualizuj" />
</form>
</div>
</body>
</html>