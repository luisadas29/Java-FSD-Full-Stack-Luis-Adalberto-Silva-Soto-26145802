<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Assign Subject To Class</h2>
<form action="AssignSubjectToClass" method="post">
	<label>Subject ID to Map to a Class</label>
	<input type="number" name="subid"><br/>
	<label>Class ID</label>
	<input type="number" name="classid"><br/>
	<input type="submit" value="Add to Class">
	<input type="reset" value="reset">	
</form>
<form action="Home.jsp" method="post"
    onsubmit="">
    <input type="Submit" value="Back to homepage" />
</form>
</body>
</html>