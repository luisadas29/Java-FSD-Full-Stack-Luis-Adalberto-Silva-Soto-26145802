<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Add Teacher</h2>
<form action="LearnerController" method="post">
	<label>TeacherName</label>
	<input type="text" name="tname"><br/>
	<label>Age</label>
	<input type="number" name="age"><br/>
	<input type="submit" value="Add Teacher">
	<input type="reset" value="reset">	
</form>
<form action="Home.jsp" method="post"
    onsubmit="">
    <input type="Submit" value="Back to homepage" />
</form>

</body>
</html>