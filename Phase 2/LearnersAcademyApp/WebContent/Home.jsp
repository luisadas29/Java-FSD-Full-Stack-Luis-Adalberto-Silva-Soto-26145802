<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Learner Academy App Operations page!</h1>
<form action="addTeacher.jsp" method="post"
    onsubmit="">
    <input type="Submit" value="Add Teacher" />
</form>

<form action="viewTeacher.jsp" method="get"
    onsubmit="">
    <input type="Submit" value="View Teachers" />
</form>    
<form action="addStudent.jsp" method="post"
    onsubmit="">
   <input type="Submit" value="Add Student" />
</form>

<form action="viewStudent.jsp" method="post"
    onsubmit="">
   <input type="Submit" value="View Students" />
</form>

<form action="addSubject.jsp" method="post"
    onsubmit="">
   <input type="Submit" value="Add Subject" />
</form>

<form action="ViewSubjects.jsp" method="post"
    onsubmit="">
   <input type="Submit" value="View Subjects" />
</form>

<form action="addClasses.jsp" method="post"
    onsubmit="">
   <input type="Submit" value="Add Classroom" />
</form>

<form action="viewClasses.jsp" method="post"
    onsubmit="">
   <input type="Submit" value="View Classrooms" />
</form>

<form action="assignStudentClass.jsp" method="post"
    onsubmit="">
   <input type="Submit" value="Assign Student to Class" />
</form>

<form action="assignTeacherClass.jsp" method="post"
    onsubmit="">
   <input type="Submit" value="Assign Teacher to Class" />
</form>

<form action="assignTeacherSubject.jsp" method="post"
    onsubmit="">
   <input type="Submit" value="Assign Subject to a Teacher" />
</form>

<form action="assignSubjectToClass.jsp" method="post"
    onsubmit="">
   <input type="Submit" value="Assign Subject to a Classroom" />
</form>

</body>
</html>