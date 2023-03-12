<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Learner Academy App Admin Login!</h1>
<form action="checkLogin.jsp" method="post">

<label>Email Id</label>
<input type="email" name="emailid"><br/>

<label>Password</label>
<input type="password" name="pass"><br/>
<input type="submit" value="Sign In">
<input type="reset" value="reset">
</form>


<%-- <jsp:include page="addTeacher.jsp"></jsp:include>
<jsp:include page="viewTeacher.jsp"></jsp:include> --%>
</body>
</body>
</html>