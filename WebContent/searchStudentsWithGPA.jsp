<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="ISO-8859-1">
<title>Search for Students within a given Program</title>
</head>
<body>
<form action="StudentController" method="get">
<fieldset>
<div>
	<label for="gpa">GPA</label>
	<input type="text" name="gpa" />
	<input type="hidden" name="action" value="searchStudentswithgpa" />
</div>
<div>
	<input type="submit" value="Submit" />
</div>
</fieldset>
</form>
</body>
</html>