package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AlumnoDAO;
import models.Alumno;

@Service
public class AlumnoService {
	
	@Autowired
	private AlumnoDAO alumnoDAO;
	
	@Autowired
	private InstitucionService intitucionService;
	
	public List leerAlumnos(){
		return alumnoDAO.leerAlumnos();
	}
	
	public void registrarAlumno(Alumno alumno){
		alumnoDAO.insertar(alumno);
	}
	
	public void actualizarAlumno(Alumno alumno){
		alumnoDAO.actualizar(alumno);
	}
	
	public void eliminarAlumno(String dni){
		alumnoDAO.eliminar(dni);
	}
}