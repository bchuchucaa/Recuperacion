 <?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Ticket</title>
<style>
	form{
	margin-left: 25%;
	}
	.input100{
	height: 40px;
	width: 20%;
	}
	.links{
	background-color: aqua;
	}
</style>
</head>
<body>
	<header id="header">
	<nav class="links" style="--items: 5;">
		<a href="/Recuperacion/JSPs/buscar.jsp">IR A LISTAR</a>
		<span class="line"></span>
	</nav>
</header>
<br><br>
<form action="/Recuperacion/ServletTicket" method="get" id="registro">
<div class="limiter">
		<div class="container-login100" style="background-image: url('/ChuchucaAlvarracin-Israel-Examen/img/bg-01.jpg');">
			<div class="wrap-login100 p-t-30 p-b-50">
				<span class="login100-form-title p-b-41">
					<h1>Ticket</h1>
				</span>
				<form class="login100-form validate-form p-b-33 p-t-5">
					<div class="wrap-input100 validate-input" data-validate = "Ingrese fecha y hora de ingreso">
						<input class="input100" type="text" id="cedula"  name="fechaingreso" placeholder="fecha y hora de ingreso" required>
						<span class="focus-input100" data-placeholder="&#xe82a;"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate = "Ingrese fecha y hora de salida">
						<input class="input100" type="text" name="fechasalida"  placeholder="fecha y hora de salida" required>
						<span class="focus-input100" data-placeholder="&#xe82a;"></span>
					</div>
					<h1>Vehiculo</h1>
					<div class="wrap-input100 validate-input" data-validate="Ingrese la placa del vehiculo">
						<input class="input100" type="text" name="placa" placeholder="ingresa la placa" required>
						<span class="focus-input100" data-placeholder="&#xe80f;"></span>
					</div>
					
					<div class="wrap-input100 validate-input" data-validate="Ingrese la marca del vehiculo">
						<input class="input100" type="text" name="marca" placeholder="Ingrese la marca del vehiculo" required>
						<span class="focus-input100" data-placeholder="&#xe80f;"></span>
					</div>
					<div class="wrap-input100 validate-input" data-validate="Ingrese el modelo del vehiculo">
						<input class="input100" type="text" name="modelo" placeholder="Elija el modelo" required>
						<span class="focus-input100" data-placeholder="&#xe80f;"></span>
					</div>
					<h1>Cliente</h1>
						<div class="wrap-input100 validate-input" data-validate="Ingrese la cedula del cliente">
						<input class="input100" type="text" name="cedula"  placeholder="Elija su cedula" required>
						<span class="focus-input100" data-placeholder="&#xe80f;"></span>
					</div>
			
					

					<div class="container-login100-form-btn m-t-32">

						 <input class="login100-form-btn" type="submit" value="Registrarse">
						  <input class="login100-form-btn" type="reset" value="Limpiar">
					</div>

				</form>
			</div>
		</div>
	</div>
	


 </form>













</body>
</html>
