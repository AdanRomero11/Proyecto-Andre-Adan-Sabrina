<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %> <!-- Importar JSTL es usado actualmente -->
    
<!-- <%//String texto = (String) request.getAttribute("texto");%>  Forma antigua habia que recoger los datos
																   desde request y almacenarlo en una variable -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<style>
  .form-control {
    width: 100%; /* Forzar ancho completo */
    max-width: 300px; /* Opcional: límite de ancho */
  }
</style>
<title>Insert title here</title>
</head>
<body>
	<h2>Pagina principal</h2>
	<div style="padding: 2% 0 0 2%">
	    <!-- Muestra los datos obtenidos de la API -->
	    <p><c:out value="${apiData}"/></p>
	</div>
</body>
</html>
 
	<div class="mt-3">
       	<p><a href="/login">logout</a></p>
    </div>
    
</body>
</html>
 