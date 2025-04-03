<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Panel de Administración</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .admin-page {
            padding: 2rem;
        }
        .admin-table {
            width: 100%;
            margin-top: 20px;
        }
        .admin-action {
            margin-right: 10px;
        }
    </style>
</head>
<body class="admin-page">

    <h1 class="mb-4">🛠️ Panel de Administración</h1>

    <p>Bienvenido, admin. Aquí puedes gestionar los clientes.</p>

    <!-- 🔗 Botón para ir a vista de usuarios desde API -->
    <a href="/api/data" class="btn btn-info mb-3">🌐 Ver usuarios desde API</a>

    <table class="table table-bordered table-striped admin-table">
        <thead class="table-dark">
            <tr>
                <th>Nombre</th>
                <th>Email</th>
                <th>Rol</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="cliente" items="${clientes}">
                <tr>
                    <td>${cliente.nombre}</td>
                    <td>${cliente.email}</td>
                    <td>${cliente.rol}</td>
                    <td>
                        <a href="/admin/editar/${cliente.id_cliente}" class="btn btn-sm btn-warning admin-action">Editar</a>
                        <a href="/admin/eliminar/${cliente.id_cliente}" class="btn btn-sm btn-danger admin-action">Eliminar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>

