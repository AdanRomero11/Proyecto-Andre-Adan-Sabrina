<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Usuarios desde API</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

    <style>
        tbody tr:nth-child(odd) {
            background-color: rgba(0, 0, 0, 0.05);
            transition: background-color 0.3s ease;
        }
        tbody tr:hover {
            background-color: rgba(0, 123, 255, 0.2);
        }
    </style>

    <script>
        $(document).on("click", ".clickable-row", function () {
            const id = $(this).data("id");
            const firstName = $(this).data("firstname");
            const lastName = $(this).data("lastname");
            const image = $(this).data("image");

            $("#modal-id").val(id);
            $("#modal-firstname").val(firstName);
            $("#modal-lastname").val(lastName);
            $("#modal-image").val(image);
        });

        $(document).on("click", "#saveChanges", function () {
            const formData = $("#editForm").serialize();

            $.ajax({
                url: "/usuario/updateUsuario",
                type: "POST",
                data: formData,
                success: function (response) {
                    alert("Usuario actualizado correctamente.");
                    location.reload();
                },
                error: function (error) {
                    alert("Error al actualizar el usuario.");
                    console.error(error);
                }
            });

            $("#detalleModal").modal("hide");
        });

        document.addEventListener("DOMContentLoaded", function () {
            document.getElementById("searchInput").addEventListener("keyup", function () {
                const filter = this.value.toLowerCase();
                const rows = document.querySelectorAll("#tableBody tr");

                rows.forEach(row => {
                    const cells = row.getElementsByTagName("td");
                    let match = false;
                    for (const cell of cells) {
                        if (cell.textContent.toLowerCase().includes(filter)) {
                            match = true;
                            break;
                        }
                    }
                    row.style.display = match ? "" : "none";
                });
            });
        });
    </script>
</head>
<body>
    <div class="container mt-4">
        <h2 class="mb-4">Usuarios obtenidos desde la API</h2>

        <input type="text" id="searchInput" class="form-control mb-3" placeholder="Buscar en la tabla...">

        <table class="table table-bordered table-striped table-hover text-center">
            <thead class="table-dark">
                <tr>
                    <th>#</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Imagen</th>
                </tr>
            </thead>
            <tbody id="tableBody">
                <c:forEach var="usuario" items="${lista}" varStatus="status">
                    <tr class="clickable-row"
                        data-bs-toggle="modal"
                        data-bs-target="#detalleModal"
                        data-id="${usuario.id}"
                        data-firstname="${usuario.firstName}"
                        data-lastname="${usuario.lastName}"
                        data-image="${usuario.image}">
                        <td>${status.index + 1}</td>
                        <td>${usuario.firstName}</td>
                        <td>${usuario.lastName}</td>
                        <td><img src="${usuario.image}" style="width: 40px; height: 40px; border-radius: 50%;"></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <form action="/logout" method="post">
            <button type="submit" class="btn btn-danger">Cerrar sesión</button>
        </form>
		<form action="/guardarApi" method="post">
		    <button type="submit" class="btn btn-danger">Guardar Datos</button>
		</form>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="detalleModal" tabindex="-1" aria-labelledby="modalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="modalLabel">Editar Usuario</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Cerrar"></button>
                </div>
                <div class="modal-body">
                    <form id="editForm">
                        <input type="hidden" id="modal-id" name="id">
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
                    <button type="button" class="btn btn-primary" id="saveChanges">Guardar Cambios</button>
                </div>
            </div>
        </div>
    </div>
</body>
</html>

