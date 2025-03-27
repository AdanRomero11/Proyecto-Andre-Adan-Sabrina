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
        <form>
            <div class="form-group">
                <label for="nombre">Nombre:</label>
                <input type="text" id="nombre" name="nombre" required>
            </div> 
			
           <div class="form-group">
	            <label for="primer_apellido">Primer Apellido:</label>
	            <input type="text" id="primer_apellido" name="primer_apellido" required>
            </div>
			
            <div class="form-group">
                <label for="segundo_apellido">Segundo Apellido:</label>
                <input type="text" id="segundo_apellido" name="segundo_apellido">
            </div>    
			        
			<div class="form-group">
                <label for="calle">Calle:</label>
                <input type="text" id="calle" name="calle" required>
            </div>

            <div class="form-group">
                <label for="numero">Número:</label>
                <input type="text" id="numero" name="numero" required>
            </div>
            <div class="form-group">
                <label for="codigo_postal">Código Postal:</label>
                <input type="text" id="codigo_postal" name="codigo_postal" required>
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
                <label for="contrasena">Contraseña:</label>
                <input type="password" id="contrasena" name="contrasena" required>
            </div>
            <button type="submit" class="btn">Registrar</button>
        </form>
    </div>
</body>
</html>