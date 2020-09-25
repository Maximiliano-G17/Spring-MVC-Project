<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrar</title>
</head>
<body>
	<h2>Registrar alumno</h2>
    
    <form:form action="paginaConfirmarRegistro" modelAttribute="alumno">
        Dni: <form:input path="dni"/>
        <form:errors path="dni"></form:errors>
        <br><br>
        Nombre: <form:input path="nombre"/>
        <form:errors path="nombre"></form:errors>
        <br><br>
        Apellido: <form:input path="apellido"/>
        <form:errors path="apellido"></form:errors>
        <br><br>
        E-mail: <form:input path="email"/>
        <form:errors path="email"></form:errors>
        <br><br>
        Direccion: <form:input path="direccion"/>
        <form:errors path="direccion"></form:errors>
        <br><br>
        Materia: <form:select path="materia">
              <form:option value="Programacion"/>
              <form:option value="Ingles"/>
              <form:option value="Matematica"/>
              <form:option value="Fotografia"/>
          </form:select>
        <br><br>
        <input type="submit" value="Registrar">
        <br><br>
		<a href="">Pagina Principal</a>
      </form:form>
</body>
</html>