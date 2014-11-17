<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="dist/css/bootstrap.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add</title>
</head>
<body>

<jsp:useBean id="baza" class="com.example.servletjspdemo.service.StorageServiceTomek" scope="application" />
<jsp:useBean id="game" class="com.example.servletjspdemo.domain.Game" scope="session" />


<form action="gameData">

  Name :<input type="text"  name="name" value="${game.name}" /><br />
  Dystrybutor :<input type="text"  name="dystrybutor" value="${game.dystrybutor}" /><br />
  Data Wydania :<input type="int"  name="dataWydania" value="${game.dataWydania}" /><br />
  Platforma: <br><input type="checkbox" name="platforma" value="Playstation 3">Playstation 3<br /> 
 	<input type="checkbox" name="platforma" value="Xbox 360">Xbox 360<br /> 
  Cena :<input type="float"  name="cena" value="${game.cena}" /><br />

  
  <input type="submit" value=" OK ">
  
</form>

</body>
</html>