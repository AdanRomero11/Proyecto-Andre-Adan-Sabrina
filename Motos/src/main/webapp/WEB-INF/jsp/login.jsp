<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="jakarta.tags.core" %>
 
 
 <!DOCTYPE html>
 <html>
     <head>
         <meta charset="UTF-8">
         <title> Formulario Login </title>
		 <link rel="stylesheet" type="text/css" href="<c:url value='/static/css/styles.css'/>">

     </head>
     <body>
         <h2><c:out value="${texto}" /></h2>

         <h1>Iniciar sesión</h1>

         <!-- Formulario para login -->
         <form action="/login" method="post">

             <label for="email"> Email: </label>
             <input type="email" id="email" name="email" required />

             <br>

             <label for="password"> Contraseña: </label>
             <input type="password" id="password" name="password" required />

             <br>

             <button type="submit">Enviar</button>
         </form>

         <!-- Mostrar mensaje si los datos fueron enviados -->
         <h2>Datos enviados:</h2>
         <p>Email: <c:out value="${email}" /></p>
         <p>Contraseña: <c:out value="${password}" /></p>
     </body>
 </html>
 