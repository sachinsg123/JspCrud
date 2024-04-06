<%@page import="com.bean.Student"%>
<%@page import="com.dao.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
String id = request.getParameter("id");
Student student = DBConnection.getStudentById(Integer.parseInt(id));

%>

<form action="edit_student.jsp" method="post">
<input type="hidden" name="id" value="<%=student.getId() %>">
<input type="text" name="name" value="<%=student.getName()%>">
<br>
<input type="text" name="email" value="<%=student.getEmail()%>">

<button type="submit">submit</button>
</form>

</body>
</html>