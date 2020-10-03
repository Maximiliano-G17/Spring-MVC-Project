package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.InstitucionDAO;
import models.Institucion;


@Service
public class InstitucionService {
	
	@Autowired
	private InstitucionDAO institucionDAO;
	
	public void insertarInstitucion(Institucion institucion){
		institucionDAO.insertar(institucion);
	}
	
	public boolean existeInsticion(String nroEscuela){
		System.out.println(nroEscuela);
		boolean bandera;
		if(institucionDAO.existe(nroEscuela)!=null){
			return bandera=true;
		}else{
			return bandera=false;
		}
	}
	
	public void eliminar(String nroEscuela){
		institucionDAO.eliminar(nroEscuela);
	}
	
	public Institucion leerInstitucion(String nroEscuela){
		return institucionDAO.leerInstitucion(nroEscuela);
	}
	public List leerInstituciones(){
		return institucionDAO.leerInstituciones();
	}
	
	public List cantAlumnosPorInstitucion(){
		return institucionDAO.cantAlumnosPorInstitucion();
	}
}