<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Add Student</h2>
<form action="LearnerControllerStudent" method="post">
	<label>Student Name</label>
	<input type="text" name="stname"><br/>
	<label>Age</label>
	<input type="number" name="age"><br/>
	<input type="submit" value="Add Student">
	<input type="reset" value="reset">	
</form>
<form action="Home.jsp" method="post"
    onsubmit="">
    <input type="Submit" value="Back to homepage" />
</form>

</body>
</html>