<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dodawanie zadania</title>
</head>
<body>
<c:url value="/DodajZadanie" var="linkDodajZadanie">
<c:param name="x_projekt_id" value="${requestScope.x_projekt_id}" />
	</c:url>
<form method="post" action='${linkDodajZadanie}'>
		Nazwa: <input type="text" name="nazwa" /> 
		Opis: <input type="text" name="opis" /> 
		Kolejność: <input type="text" name="kolejnosc" /> 
		<input type="submit" value="Dodaj" />
	</form>
</body>
</html>