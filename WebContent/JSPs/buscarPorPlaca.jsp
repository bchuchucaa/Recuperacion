<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Busqueda por placa</title>
</head>
<body>
	<header id="header">
	<nav class="links" style="--items: 5;">
		<a href="/JPADAOProyecto1/index.html">Inicio</a>
		<span class="line"></span>
	</nav>
</header>
<br><br>
 
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
  

<br><br><br><br><br><br>
<c:set var="p1" value="${requestScope['telefonos']}" />

		<table class=container>
				<tr>
					<td>Usuario</td>
					<td>${userexistente.nombre}</td>
					<td><a href="mailto:${userexistente.correo}">Enviar correo<i class="fa fa-envelope-o" style="font-size:48px;color:red"></i></a></td>
					
				</tr>
			<c:forEach items="${telefonos}" var="telefonos">
				
				
				<tr>
					<td>${telefonos.tipo}</td>
					<td>${telefonos.numero}</td>
					<td><a href="tel:${telefonos.numero}">Contactar usuario<i class="fa fa-mobile-phone" style="font-size:48px;color:red"></i></a></td>
					
			
				</tr>
				
			</c:forEach>
		</table>
		<h1>listo</h1>

</body>
</html>