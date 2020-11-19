<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista zadań</title>
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
	<h2>Lista zadań</h2>
	<h2>Projekt: ${requestScope.projekt.nazwa}</h2>
	<c:url value="/DodawanieZadania" var="linkDodawanieZadania">
	<c:param name="x_projekt_id" value="${projekt.projektId}" />
	</c:url>
	<div id="actionButton"><a class="button" href='<c:out value="${linkDodawanieZadania}" />'> (+)  Nowe zadania</a></div><br>
	<table cellpadding="3">
		<tr>
			<th>Lp.</th>
			<th>Id</th>
			<th>Nazwa</th>
			<th>Opis</th>
			<th>Projekt_id</th>
			<th>Edycja</th>
		</tr>
		<c:forEach var="zadanie" items="${requestScope.zadania}"
			varStatus="info">
			<tr>
				<td>${info.count}.</td>
				<td><c:out value="${zadanie.zadanieId}" /></td>
				<td><c:out value="${zadanie.nazwa}" /></td>
				<td><c:out value="${zadanie.opis}" /></td>
				<td><c:out value="${zadanie.projekt.projektId}" /></td>
				<c:url value="/EdycjaZadania" var="linkEdycjaZadania">
					<c:param name="x_zadanie_id" value="${zadanie.zadanieId}" />
				</c:url>
				<c:url value="/UsunZadanie" var="linkUsunZadanie">
					<c:param name="x_zadanie_id" value="${zadanie.zadanieId}" />
				</c:url>
				<td><a class="button" href='<c:out value="${linkEdycjaZadania}" />'>Edytuj</a><a class="button" href='<c:out value="${linkUsunZadanie}" />'>Usuń</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>