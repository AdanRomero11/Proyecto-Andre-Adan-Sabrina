<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>
<body class="login-page">
    <div class="brand">Proyecto AAS</div>

    <div class="container">
        <form class="auth-form" action="/login" method="post">
            <h1>Iniciar Sesión</h1>

            <div class="form-group">
                <label for="email">Email</label>
                <div class="input-icon">
                    <i class="fa fa-envelope"></i>
					<input type="email" id="email" name="email" placeholder="ejemplo@email.com" required>
                </div>
            </div>

            <div class="form-group">
                <label for="password">Contraseña</label>
                <div class="input-icon">
                    <i class="fa fa-lock"></i>
					<input type="password" id="password" name="password" placeholder="********" required>
                </div>
            </div>

            <button type="submit" class="btn">Login</button>

            <div class="auth-link">
                <a href="/registro" class="auth-text">¿No tienes cuenta? Regístrate</a>
            </div>
        </form>
    </div>
</body>
</html>

