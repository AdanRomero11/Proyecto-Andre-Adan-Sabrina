<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registro de Cliente - New Wave</title>
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>
<body>
    <div class="brand">Proyecto AAS</div>

    <div class="container">
        <form class="auth-form" action="/crearCliente" method="post">
            <h1>Registro de Cliente</h1>

            <div class="form-group"><label for="nombre">Nombre</label><input type="text" id="nombre" name="nombre" required></div>
            <div class="form-group"><label for="apellido1">Primer Apellido</label><input type="text" id="apellido1" name="apellido1" required></div>
            <div class="form-group"><label for="apellido2">Segundo Apellido</label><input type="text" id="apellido2" name="apellido2"></div>
            <div class="form-group"><label for="email">Email</label>
                <div class="input-icon">
                    <i class="fa fa-envelope"></i>
                    <input type="email" id="email" name="email" required>
                </div>
            </div>
            <div class="form-group"><label for="telefono">Teléfono</label><input type="tel" id="telefono" name="telefono" required></div>
            <div class="form-group"><label for="password">Contraseña</label>
                <div class="input-icon">
                    <i class="fa fa-lock"></i>
                    <input type="password" id="password" name="password" required>
                </div>
            </div>
            <div class="form-group"><label for="calle">Calle</label><input type="text" id="calle" name="calle" required></div>
            <div class="form-group"><label for="numero">Número</label><input type="text" id="numero" name="numero" required></div>
            <div class="form-group"><label for="localidad">Localidad</label><input type="text" id="localidad" name="localidad"></div>
            <div class="form-group"><label for="poblacion">Población</label><input type="text" id="poblacion" name="poblacion" required></div>
            <div class="form-group"><label for="codigoP">Código Postal</label><input type="text" id="codigoP" name="codigoP" required></div>

            <button type="submit" class="btn">Registrar</button>

            <div class="auth-link">
                <a href="/" class="auth-text">¿Ya tienes cuenta? <strong>Inicia sesión</strong></a>
            </div>
        </form>
    </div>
</body>
</html>
