package repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Repository;

import dao.InstitucionDAO;
import models.Alumno;
import models.Institucion;


@Repository
public class InstitucionRepo implements InstitucionDAO{
	
	private SessionFactory miFactory;
	private Session miSession;

	public void insertar(Institucion institucion) {	
		obtenerSession();
		System.out.println("registrando..");
		try{
			Institucion institucionInsertar=new Institucion(institucion.getNroEscuela(),institucion.getNombre(),institucion.getDireccion()
					,institucion.getTelefono());
			miSession.beginTransaction();
			miSession.save(institucionInsertar);
			miSession.getTransaction().commit();
			System.out.println("Registro insertado correctamente en BBDD");			
		}catch(Exception e){
			System.out.println("error");
			miSession.getTransaction().rollback();
			e.printStackTrace();		
		}finally{
			miSession.close();
			miFactory.close();
		}
	}

	public List leerInstituciones() {
		obtenerSession();
		List<Institucion> listaInstituciones=new ArrayList<Institucion>();
		try{		
			miSession.beginTransaction();
			listaInstituciones = miSession.createQuery("from Institucion").list();	
		}catch(Exception e){
			System.out.println("error");
			miSession.getTransaction().rollback();
			e.printStackTrace();
		}finally{
			miSession.close();
			miFactory.close();
		}		
		return listaInstituciones;
	}

	public Institucion leerInstitucion(String nroEscuela) {
		obtenerSession();	
		Institucion institucion = null;
		try{		
			miSession.beginTransaction();
			Query query = miSession.createQuery("from Institucion i where i.nroEscuela = :nroEscuela");
			query.setParameter("nroEscuela", nroEscuela);
			institucion = (Institucion) query.uniqueResult();
		}catch(Exception e){
			System.out.println("error");
			miSession.getTransaction().rollback();
			e.printStackTrace();
		}finally{
			miSession.close();
			miFactory.close();
		}		
		return institucion;
	}

	public List leerAlumnosInstitucion(String nroEscuela) {
		obtenerSession();
		Query query = null;
		
		try{		
			miSession.beginTransaction();
			query = miSession.createQuery("from Alumno a where a.NroEscuela_ID = :nroEscuela");	
			query.setParameter("nroEscuela", nroEscuela);
			
		}catch(Exception e){
			System.out.println("error");
			miSession.getTransaction().rollback();
			e.printStackTrace();
		}finally{
			miSession.close();
			miFactory.close();
		}		
		return query.list();
	}
	
	public List cantAlumnosPorInstitucion() {
		obtenerSession();
		
		List<Long> listaAlumnos=new ArrayList<Long>();
		try{		
			miSession.beginTransaction();
			listaAlumnos = miSession.createQuery("select count(a.institucion.nroEscuela) from Alumno a group by a.institucion.nroEscuela").list();
		}catch(Exception e){
			System.out.println("error");
			miSession.getTransaction().rollback();
			e.printStackTrace();
		}finally{
			miSession.close();
			miFactory.close();
		}
		return listaAlumnos;
	}
	
	public Object existe(String nroEscuela){
		obtenerSession();
		Object institucion=null;
		try{		
			miSession.beginTransaction();
			institucion = miSession.createQuery("from Institucion i where i.nroEscuela = " + nroEscuela).uniqueResult();	
		}catch(HibernateException e){
			System.out.println("error 1");
			e.printStackTrace();
		}finally{
			miSession.close();
			miFactory.close();
		}
		return institucion;
	}

	public void eliminar(String nroEscuela) {
		obtenerSession();
		try{		
			miSession.beginTransaction();
			Query query=miSession.createQuery("delete Institucion i where i.nroEscuela=:nroEscuela");
			query.setParameter("nroEscuela", nroEscuela);
			query.executeUpdate();
			miSession.getTransaction().commit();
		}catch(Exception e){
			System.out.println("error");
			miSession.getTransaction().rollback();
			e.printStackTrace();
		}finally{
			miSession.close();
			miFactory.close();
		}	
	}
	
	private Session obtenerSession() {
		miFactory=new AnnotationConfiguration().configure("database/hibernate.cfg.xml").addAnnotatedClass(Alumno.class)
				.addAnnotatedClass(Institucion.class)
				.buildSessionFactory();
		miSession =miFactory.openSession();
		return miSession;
	}
}