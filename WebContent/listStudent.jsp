<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List All Student Records</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th> Student ID </th>
				<th> First Name </th>
				<th> Last Name </th>
				<th> Program </th>
				<th> GPA </th>
				<th colspan="2">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${students}" var="student">
				<tr>
					<td><c:out.value="${student.studentid }" /></td>
					<td><c:out.value="${student.firstname }" /></td>
					<td><c:out.value="${student.lastname }" /></td>
					<td><c:out.value="${student.program }" /></td>
					<td><c:out.value="${student.gpa }" /></td>
					
					<td><a href="StudentController?action=edit&
							studentid=<c:out value="${student.studentid }" />">Update</a></td>
					<td><a href="StudentController?action=delete&
							studentid=<c:out value="${student.studentid }" />">Delete</a></td>				
				</tr>
			</c:forEach>			
		</tbody>		
	</table>

	<a href="StudentController?action=insert">Add Student</a>
	
	


</body>
</html>