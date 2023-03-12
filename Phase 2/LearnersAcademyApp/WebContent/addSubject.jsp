<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Add Subject</h2>
<form action="LearnerControllerSubject" method="post">
	<label>Subject Name</label>
	<input type="text" name="subname"><br/>
	<input type="submit" value="Add Subject">
	<input type="reset" value="reset">	
</form>
<form action="Home.jsp" method="post"
    onsubmit="">
    <input type="Submit" value="Back to homepage" />
</form>

</body>
</html>