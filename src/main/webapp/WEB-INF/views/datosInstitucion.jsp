<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>
<body>

	<h2>Proyecto Escuela</h2>

	<table id="tabla">
		<tr>
			<th>Nro Escuela</th>
			<th>Nombre</th>
			<th>Direccion</th>
			<th>Telefono</th>
		</tr>
		<tbody>
			<c:forEach items="${listaInstituciones}" var="institucion">
				<tr>
					<td>${institucion.nroEscuela}</td>
					<td>${institucion.nombre}</td>
					<td>${institucion.direccion}</td>
					<td>${institucion.telefono}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<br>
	<br>
	<br>

	<a href="">Volver</a>

</body>
</html>