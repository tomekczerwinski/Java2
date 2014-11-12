<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="baza" class="com.example.servletjspdemo.service.StorageServiceTomek" scope="application" />
<jsp:useBean id="game" class="com.example.servletjspdemo.domain.Game" scope="session" />

<form action="gameData">

  Name :<input type="text"  name="name" value="${game.name}" /><br />
  Dystrybutor :<input type="text"  name="dystrybutor" value="${game.dystrybutor}" /><br />
  Data Wydania :<input type="int"  name="dataWydania" value="${game.dataWydania}" /><br />
  Platforma :<input type="text"  name="platforma" value="${game.platforma}" /><br />
  Cena :<input type="int"  name="cena" value="${game.cena}" /><br />
  <input type="hidden"  name="id" value="${game.id}" /><br />
  
  <input type="submit" value=" OK ">
  
</form>

</body>
</html>