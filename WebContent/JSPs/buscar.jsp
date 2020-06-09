<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	
<title>Busqueda por Placa</title>
<style>
form{
width: 50%;
margin-left: 15%;
}
table{
margin-left:10%;
width:60%;
border-style: solid;
border-width: 2px;
border-color: gray;
}
tr{
border-style: solid;
border-width: 2px;
border-color: gray;
}
h1{
margin-left: 10%;
}
h2{
margin-left: 10%;
}
</style>
</head>
<body>
	<header id="header">
	<nav class="links" style="--items: 5;">
		<a href="/Recuperacion/JSPs/ticket.jsp">REGISTRAR TICKET</a>
		<span class="line"></span>
	</nav>
</header>
<br><br>
 
<form action="/Recuperacion/Buscar" autocomplete="off">
    <fieldset class="url">
      <input id="url" type="text" name="cedula"  required>
      <label for="url"><i class="fa fa-search" aria-hidden="true"></i> Ingrese cedula para buscar Tickets</label>
      <div class="after"></div>
    </fieldset>
    <fieldset class="enter">
      <input type="submit" value="Buscar"/>
    </fieldset>
  </form>
<form action="/Recuperacion/BuscarPorPlaca" autocomplete="off">
    <fieldset class="url">
      <input id="url" type="text" name="placa"   required>
      <label for="url"><i class="fa fa-search" aria-hidden="true"></i> Ingrese la placa</label>
      <div class="after"></div>
    </fieldset>
    <fieldset class="enter">
      <input type="submit" value="Buscar"/>
    </fieldset>
  </form>
  

<br><br><br>
<c:set var="p1" value="${requestScope['telefonos']}" />
		<h2>TUS DATOS<br> Id: ${cliente.cedula}<br> Nombre: ${cliente.nombre}<br></h2>
	
		<h1>Datos Ticket y  Vehiculos </h1>
		<table class=container>
				<tr>
					<td>Fecha ingreso</td>
					<td>Fecha salida</td>
					<td>Placa</td>
					<td>Marca</td>
					<td>Modelo</td>
					
				</tr>
			<c:forEach items="${tickets}" var="tickets">
				
				
				<tr>
					<td>${tickets.fechahoraingreso}</td>
					<td>${tickets.fechahorasalida}</td>
					<td>${tickets.vehiculo.placa}</td>
					<td>${tickets.vehiculo.marca}</td>
					<td>${tickets.vehiculo.modelo}</td>
					
				</tr>
				
			</c:forEach>
		</table>
		<h1>listo</h1>

</body>
</html>