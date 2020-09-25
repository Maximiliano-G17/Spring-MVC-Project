<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="UTF-8">
<title>Eliminar alumno</title>
</head>
<body>
    <form:form action="paginaConfirmarEliminacion" modelAttribute="alumnoEliminar">
        Dni: <form:input path="dni"/>
        <form:errors path="dni"></form:errors>
        <br><br>
        <input type="submit" value="Eliminar">
        <br><br>
		<a href="">Pagina Principal</a>
      </form:form> 
</body>
</html>