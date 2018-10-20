<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search for Students within a given Program</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<form action="StudentController" method="get">
<fieldset>
<div>
	<label for="program">Program</label>
	<input type="text" name="program" />
	<input type="hidden" name="action" value="searchstudentsfromprogram" />
</div>
<div>
	<input type="submit" value="Submit" />
</div>
</fieldset>
</form>
</body>
</html>