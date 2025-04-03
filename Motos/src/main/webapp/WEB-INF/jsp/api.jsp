<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %> <!-- JSTL actualizado -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestión de Usuarios</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/estiloApi.css'/>">
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>



<script>
			    // Manejo del clic en las filas para llenar la modal
			    $(document).on("click", ".clickable-row", function () {
			        const id = $(this).data("id");
			        const firstName = $(this).data("firstname");
			        const lastName = $(this).data("lastname");
			        const image = $(this).data("image");

			        // Rellenar el formulario dentro del modal
			        $("#modal-id").val(id);
			        $("#modal-firstname").val(firstName);
			        $("#modal-lastname").val(lastName);
			        $("#modal-image").val(image);
			    });

			    // Enviar los datos editados al controlador vía AJAX
			    $(document).on("click", "#saveChanges", function () {
			        console.log("Botón clickeado.");
			        
			        // Obtener los datos del formulario
			        const id = $("#modal-id").val();
			        const firstName = $("#modal-firstname").val();
			        const lastName = $("#modal-lastname").val();
			        const image = $("#modal-image").val();

			        // Crear el objeto JSON con los datos del formulario
			        const jsonData = {
			            id: id,
			            firstName: firstName,
			            lastName: lastName,
			            image: image
			        };

			        console.log("Enviando datos:", jsonData); // Verificar que los datos estén correctos

			        $.ajax({
			            url: "/usuario/updateUsuario", // URL del controlador (ControladorUsuario)
			            type: "POST",
			            contentType: "application/json", // Asegúrate de enviar JSON
			            data: JSON.stringify(jsonData), // Enviar los datos como JSON
			            success: function (response) {
			                alert("Usuario actualizado correctamente.");
			                location.reload(); // Recargar la página para ver los cambios
			            },
			            error: function (error) {
			                alert("Error al actualizar el usuario.");
			                console.error(error);
			            }
			        });

			        // Cierra el modal después de enviar los datos
			        $("#detalleModal").modal("hide");
			    });

			    // Filtrar la tabla en vivo
			    document.addEventListener("DOMContentLoaded", function () {
			        document.getElementById("searchInput").addEventListener("keyup", function () {
			            const filter = this.value.toLowerCase(); // Convierte el texto a minúsculas para comparación
			            const rows = document.querySelectorAll("#tableBody tr"); // Obtiene todas las filas de la tabla

			            rows.forEach(row => {
			                const cells = row.getElementsByTagName("td");
			                let match = false;

			                // Verifica si alguna celda de la fila contiene el texto buscado
			                for (const cell of cells) {
			                    if (cell.textContent.toLowerCase().includes(filter)) {
			                        match = true;
			                        break;
			                    }
			                }

			                // Muestra u oculta la fila según si hay coincidencias
			                row.style.display = match ? "" : "none";
			            });
			        });
			    });

</script>

</head>
<body>

<div class="container mt-3">
    <h2>Gestión de Usuarios</h2>

    <!-- Botón para cargar datos desde la API -->
    <button id="loadApiData" class="btn btn-primary mb-3">Cargar Datos desde API</button>

    <!-- Campo de búsqueda -->
    <input type="text" id="searchInput" class="form-control mb-3" placeholder="Buscar en la tabla...">

    <!-- Tabla de usuarios -->
    <table class="table table-bordered table-striped text-center">
        <thead>
            <tr>
                <th>#</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Imagen</th>
            </tr>
        </thead>
        <tbody id="tableBody">
            <c:forEach var="usuario" items="${lista}">
                <tr class="clickable-row" data-bs-toggle="modal" data-bs-target="#detalleModal"
                    data-id="${usuario.id}"
                    data-firstname="${usuario.firstName}"
                    data-lastname="${usuario.lastName}"
                    data-image="${usuario.image}">
                    <td>${usuario.id}</td>
                    <td>${usuario.firstName}</td>
                    <td>${usuario.lastName}</td>
                    <td><img src="${usuario.image}" style="width: 50px;"></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<!-- Modal para editar usuario -->
<!-- Modal editable -->
<div class="modal fade" id="detalleModal" tabindex="-1" aria-labelledby="modalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="modalLabel">Editar Fila</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form id="editForm">
                    <input type="hidden" id="modal-id" name="id">  <!-- Campo oculto para id -->

                    <div class="mb-3">
                        <label for="modal-firstname" class="form-label">Nombre</label>
                        <input type="text" class="form-control" id="modal-firstname" name="firstName">
                    </div>

                    <div class="mb-3">
                        <label for="modal-lastname" class="form-label">Apellido</label>
                        <input type="text" class="form-control" id="modal-lastname" name="lastName">
                    </div>

                    <div class="mb-3">
                        <label for="modal-image" class="form-label">URL Imagen</label>
                        <input type="text" class="form-control" id="modal-image" name="image">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                <button type="button" id="saveChanges" class="btn btn-primary">Guardar Cambios</button>  <!-- Botón que dispara el AJAX -->
            </div>
        </div>
    </div>
</div>


<!-- Botón para cerrar sesión y guardar datos -->
<div class="container mt-3">
    <form action="/logout" method="post">
        <button type="submit" class="btn btn-danger">Cerrar sesión</button>
    </form>

</div>

</body>
</html>
