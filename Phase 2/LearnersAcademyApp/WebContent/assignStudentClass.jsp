<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Assign Student To Class</h2>
<form action="AssignClassToStudent" method="post">
	<label>Class ID to Map to a Student</label>
	<input type="number" name="classid"><br/>
	<label>Student ID</label>
	<input type="number" name="studentid"><br/>
	<input type="submit" value="Add to Class">
	<input type="reset" value="reset">	
</form>
<form action="Home.jsp" method="post"
    onsubmit="">
    <input type="Submit" value="Back to homepage" />
</form>
</body>
</html>