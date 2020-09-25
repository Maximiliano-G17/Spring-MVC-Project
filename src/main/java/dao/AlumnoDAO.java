package dao;

import java.util.List;

import models.Alumno;

public interface AlumnoDAO {	
	public void insertar(Alumno alumno);
	public List leerAlumnos();
	public void actualizar(Alumno alumno);
	public void eliminar(String dni);
}