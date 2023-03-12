<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<body>
<h2>Assign Teacher To Subject</h2>
<form action="AssignTeacherToSubject" method="post">
	<label>Subject ID to Map to a Teacher</label>
	<input type="number" name="subid"><br/>
	<label>Teacher ID</label>
	<input type="number" name="tid"><br/>
	<input type="submit" value="Add to Class">
	<input type="reset" value="reset">	
</form>
<form action="Home.jsp" method="post"
    onsubmit="">
    <input type="Submit" value="Back to homepage" />
</form>
</body>
</body>
</html>