<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista projektów</title>
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
<h2>Wszystkie projekty</h2>
	<c:url value="/dodawanie_projektu.jsp" var="linkDodajProjekt">
	</c:url>
	<div id="actionButton"><a class="button" href='<c:out value="${linkDodajProjekt}" />'> (+) Nowy projekt</a></div>
	<br>
	<table class="effect2" cellpadding="3">
		<tr>
			<th>Lp.</th>
			<th>Id</th>
			<th>Nazwa</th>
			<th>Opis</th>
			<th>Utworzony</th>
			<th>Data obrony</th>
			<th>Edycja</th>
		</tr>
		<c:forEach var="projekt" items="${requestScope.projekty}"
			varStatus="info">
			<tr>
				<td>${info.count}.</td>
				<td><c:out value="${projekt.projektId}" /></td>
				<td><c:out value="${projekt.nazwa}" /></td>
				<td><c:out value="${projekt.opis}" /></td>
				<javatime:format value="${projekt.dataczasUtworzenia}"
					var="fmtDataczasUtworzenia" pattern="yyyy-MM-dd hh:mm:ss" />
				<td><c:out value="${fmtDataczasUtworzenia}" /></td>
				<javatime:format value="${projekt.dataOddania}" var="fmtDataOddania"
					pattern="yyyy-MM-dd" />
				<td><c:out value="${fmtDataOddania}" /></td>
				<c:url value="/ZadaniaList" var="linkZadaniaProjektu">
					<c:param name="x_projekt_id" value="${projekt.projektId}" />
				</c:url>
				<c:url value="/UsunProjekt" var="linkUsuwaniaProjektu">
					<c:param name="x_projekt_id" value="${projekt.projektId}" />
				</c:url>
				<c:url value="/EdycjaProjektu" var="linkEdycjaProjektu">
					<c:param name="x_projekt_id" value="${projekt.projektId}" />
				</c:url>
				<td><a class="button" href='<c:out value="${linkZadaniaProjektu}" />'>Zadania</a><a class="button" href='<c:out value="${linkEdycjaProjektu}" />'>Edytuj</a><a class="button" href='<c:out value="${linkUsuwaniaProjektu}" />'>Usuń</a></td>
			</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>