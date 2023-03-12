<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%! String emailid,password; %>

<%
emailid= request.getParameter("emailid");
password= request.getParameter("pass");
//RequestDispatcher rd1 = request.getRequestDispatcher("Home.jsp");
//RequestDispatcher rd2 = request.getRequestDispatcher("login.jsp");
if (emailid.equals("luisadas1@hotmail.com") && password.equals("123")){
	out.println("Successfully Login");
	%>
	<jsp:forward page="Home.jsp"></jsp:forward>
	<%
	//rd1.forward(request, response);
} else {
	out.println(" Failure , please try once again");
	//rd2.include(request, response);
			%>
			<jsp:include page="login.jsp"></jsp:include>
			<%
}
	
%>

</body>
</html>