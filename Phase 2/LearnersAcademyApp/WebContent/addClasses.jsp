<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Add Classroom</h2>
<form action="LearnerControllerClasses" method="post">
	<label>Class Building</label>
	<input type="text" name="classBuilding"><br/>
	<label>Class Section</label>
	<input type="text" name="classSection"><br/>
	<input type="submit" value="Add Classroom">
	<input type="reset" value="reset">	
</form>
<form action="Home.jsp" method="post"
    onsubmit="">
    <input type="Submit" value="Back to homepage" />
</form>

</body>
</html>