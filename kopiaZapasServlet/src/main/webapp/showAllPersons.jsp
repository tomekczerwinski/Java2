<%@page import="com.example.servletjspdemo.domain.Game"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="storage" class="com.example.servletjspdemo.service.StorageServiceTomek" scope="application" />
<%
	for (com.example.servletjspdemo.domain.Game person : storage.getAllGames()) {
	  out.println("<p>Year of birth: " + person.getDataWydania() + "</p>");
  }
%>
<p>
  <a href="getPersonData.jsp">Add another person</a>
</p>

</body>
</html>