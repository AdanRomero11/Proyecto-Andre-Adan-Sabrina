<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro de Usuario</title>
    <link rel="stylesheet" href="/css/estiloReg.css">
</head>
<body>
    <div class="container">
        <h1>Registro de Usuario</h1>
        <form action="/crearCliente" method="post">
            <div class="form-group">
                <label for="nombre">Nombre:</label>
                <input type="text" id="nombre" name="nombre" required>
            </div> 
			
           <div class="form-group">
	            <label for="apellido1">Primer Apellido:</label>
	            <input type="text" id="apellido1" name="apellido1" required>
            </div>
			
            <div class="form-group">
                <label for="apellido2">Segundo Apellido:</label>
                <input type="text" id="apellido2" name="apellido2">
            </div>    
			        
			<div class="form-group">
                <label for="calle">Calle:</label>
                <input type="text" id="calle" name="calle" required>
            </div>

            <div class="form-group">
                <label for="numero">Número:</label>
                <input type="number" id="numero" name="numero" required>
            </div>
            <div class="form-group">
                <label for="codigoP">Código Postal:</label>
                <input type="text" id="codigoP" name="codigoP" required>
            </div>

            <div class="form-group">
                <label for="localidad">Localidad:</label>
                <input type="text" id="localidad" name="localidad" required>
            </div>
            <div class="form-group">
                <label for="poblacion">Población:</label>
                <input type="text" id="poblacion" name="poblacion" required>
            </div>

            <div class="form-group">
                <label for="telefono">Teléfono:</label>
                <input type="tel" id="telefono" name="telefono">
            </div>

            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
            </div>
            <div class="form-group">
                <label for="password">Contraseña:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <button type="submit" class="btn">Registrar</button>
        </form>
    </div>
</body>
</html>