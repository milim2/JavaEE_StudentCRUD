<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Student</title>
</head>
<body>
	<form action="StudentController" method="post">
	
	<fieldset>
		<div>
		<label for="studentID">Student ID</label>
		<input type="text" name="studentId" 
			value="<c:out value="${student.studentid}" />" readonly="readonly" /> 
		</div>
		<div>
		<label for="firstName">First Name</label>
		<input type="text" name="firstname" 
			value="<c:out value="${student.firstname}" />" /> 
		</div>
		<div>
		<label for="lastName">First Name</label>
		<input type="text" name="lastName" 
			value="<c:out value="${student.lastname}" />" /> 
		</div>
		<div>
		<label for="program">Program</label>
		<input type="text" name="program" 
			value="<c:out value="${student.program}" />" /> 
		</div>
		<div>
		<label for="gpa">GPA</label>
		<input type="text" name="gpa" 
			value="<c:out value="${student.gpa}" />" /> 
		</div>
		
		<input type="submit" value="Submit" />
		
	</fieldset>
</form>
</body>
</html>