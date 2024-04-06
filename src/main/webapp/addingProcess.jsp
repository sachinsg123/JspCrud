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

<jsp:useBean id="s" class="com.bean.Student"></jsp:useBean>
<jsp:setProperty property="*" name="s"/>

<%
  int i = DBConnection.addStudent(s);

if(i>0){
	
	response.sendRedirect("view_all_students.jsp");
}
else{
	
	response.sendRedirect("index.jsp");
}

%>

</body>
</html>