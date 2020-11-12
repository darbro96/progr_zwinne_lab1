<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dodawanie projektu</title>
</head>
<body>
	<c:url value="/DodajProjekt" var="linkDodajProjekt">
	</c:url>
	<form method="post" action='${linkDodajProjekt}'>
		Nazwa: <input type="text" name="nazwa" /> 
		Opis: <input type="text" name="opis" /> 
		Data oddania (RRRR-MM-DD): <input type="text" name="dataOddania"> 
		<input type="submit" value="Dodaj" />
	</form>
</body>
</html>