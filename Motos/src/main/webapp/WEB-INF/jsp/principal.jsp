<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bienvenido</title>
	<link rel="stylesheet" type="text/css" href="/css/princ.css">
</head>
<body>

    <div class="container">
		
        <h2>Bienvenido, <%= request.getAttribute("nombreCliente") %>!</h2>
        <p>Has iniciado sesión correctamente.</p>
		
		<form action="/logout" method="POST">
		    <button type="submit">Cerrar sesión</button>
		</form>
		
    </div>

</body>
</html>
