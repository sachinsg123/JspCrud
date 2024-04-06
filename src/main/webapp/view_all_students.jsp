<%@page import="com.bean.Student"%>
<%@page import="java.util.List"%>
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

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="t" %>

<h1>List of Students</h1>


<% 
  List<Student> students = DBConnection.getAllStudent();
  request.setAttribute("student", students);
%>
<table border="2 px">

<tr>
<th>ID</th>
<th>name</th>
<th>Email</th>
<th>Edit</th>
<th>Delete</th>
</tr>
<t:forEach items="${student}" var="s">
<tr>
<td>${s.getId()}</td>
<td>${s.getName()}</td>
<td>${s.getEmail()}</td>
<td><a href="editform.jsp?id=${s.getId()}">Edit</a></td>
<td><a href="delete_student.jsp?id=${s.getId()}">Delete</a></td>
</tr>
</t:forEach>
</table>

<h1><a href="add_form.jsp">Add New</a></h1>
</body>
</html>