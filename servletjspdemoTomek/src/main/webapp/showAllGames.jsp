<%@page import="com.example.servletjspdemo.domain.Game"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border=1>
        <thead>
            <tr>
                <th>Name</th>
                <th>Dystrybutor</th>
                <th>Data Wydania</th>
                <th>Platforma</th>
                <th>Cena</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
<jsp:useBean id="baza" class="com.example.servletjspdemo.service.StorageServiceTomek" scope="application" />
<tbody>
<%
	int id=0;
	for (com.example.servletjspdemo.domain.Game game : baza.getAllGames()) {
		id=game.getId();
		%>
		<tr>
		<td>
		<%
		out.println("<p>" + game.getName() + "</p>");
		%>
		</td>
		<td>
		<%
		out.println("<p>" + game.getDystrybutor() + "</p>");
		%>
		</td>
		<td>
		<%
		out.println("<p>" + game.getDataWydania() + "</p>");
		%>
		</td>
		<td>
		<%
		out.println("<p>" + game.getPlatforma() + "</p>");
		%>
		</td>
		<td>
		<%
		out.println("<p>" + game.getCena() + "</p>");
		%>
		</td>
				
		<%
		//out.println("<p>" + game.getId() + "</p>");
		
		//out.println("<td>");

		out.println("<td><a href=\"deleteGame?userId="+String.valueOf(game.getId())+"\">Usun</a></td>	</tr>");
		out.println("<td><a href=\"updateGameForm?userId="+String.valueOf(game.getId())+"\">Update</a></td>	</tr>");
	}
		

		%>
<p>
  <a href="getGameData.jsp">Add another person</a>
</p>

</body>
</html>