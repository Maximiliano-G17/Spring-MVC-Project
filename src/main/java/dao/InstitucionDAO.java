package dao;

import java.util.List;


import models.Institucion;

public interface InstitucionDAO {
	
	public void insertar(Institucion institucion);
	public List leerInstituciones();
	public Institucion leerInstitucion(String NroEscuela);
	public List leerAlumnosInstitucion(String NroEscuela);
	public List leerAlumnosInstituciones();
	public Object existe(String nroEscuela);
	public void eliminar(String nroEscuela);

}
