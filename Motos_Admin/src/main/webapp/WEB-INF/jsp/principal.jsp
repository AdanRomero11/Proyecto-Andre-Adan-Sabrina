<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Bienvenido</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body class="principal-page">
    <div class="container principal-container">
        <h2>Bienvenido, <%= request.getAttribute("nombreCliente") %>!</h2>
        <p>Has iniciado sesión correctamente.</p>

        <form action="/logout" method="POST">
            <button type="submit" class="btn">Cerrar sesión</button>
        </form>

        <c:if test="${usuarioLogueado.rol eq 'ADMIN'}">
            <a href="/admin" class="btn-secondary">Ir al panel de administración</a>
        </c:if>
    </div>
</body>
</html>
