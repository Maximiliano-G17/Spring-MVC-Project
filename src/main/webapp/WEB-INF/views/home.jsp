<!DOCTYPE html>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
    <th>Dni</th>
    <th>Nombre</th>
    <th>Apellido</th>
    <th>Email</th>
    <th>Direccion</th>
    <th>Materia</th>
  </tr>
  <tbody>
  	<c:forEach items = "${listaAlumnos}" var = "alumno" >
         <tr>
         	<td>${alumno.dni}</td>
         	<td>${alumno.nombre}</td>
         	<td>${alumno.apellido}</td>
         	<td>${alumno.email}</td>
         	<td>${alumno.direccion}</td>
         	<td>${alumno.materia}</td>
         </tr>
    </c:forEach>
  </tbody>
</table>

<br><br><br>

<a href="paginaRegistro">Registrar alumno</a>
<br><br>
<a href="paginaActualizar">Actualizar alumno</a>
<br><br>
<a href="paginaEliminar">Eliminar alumno</a>

</body>
</html>