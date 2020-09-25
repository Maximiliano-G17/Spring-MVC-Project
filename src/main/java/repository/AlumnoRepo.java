package repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Repository;

import dao.AlumnoDAO;
import models.Alumno;

@Repository
public class AlumnoRepo implements AlumnoDAO{

	private SessionFactory miFactory;
	private Session miSession;
	
	private Session obtenerSession() {
		miFactory=new AnnotationConfiguration().configure("database/hibernate.cfg.xml").addAnnotatedClass(Alumno.class).buildSessionFactory();
		miSession =miFactory.openSession();
		return miSession;
	}
		
	public void insertar(Alumno alumnoRegistrar) {
		obtenerSession();
		System.out.println("registrando..");
		try{
			Alumno alumno=new Alumno(alumnoRegistrar.getDni(),alumnoRegistrar.getNombre(),alumnoRegistrar.getApellido()
			,alumnoRegistrar.getEmail(),alumnoRegistrar.getDireccion(),alumnoRegistrar.getMateria());
			miSession.beginTransaction();
			miSession.save(alumno);
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

	public List leerAlumnos() {
		obtenerSession();
		List<Alumno> listaAlumnos=new ArrayList<Alumno>();
		try{		
			miSession.beginTransaction();
			listaAlumnos = miSession.createQuery("from Alumno").list();	
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

	public void eliminar(String dni) {
		obtenerSession();
		try{		
			miSession.beginTransaction();
			Query query=miSession.createQuery("delete Alumno where Dni=:dni");
			query.setParameter("dni", dni);
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

	public void actualizar(Alumno alumnoActualizado) {
		obtenerSession();
		try{
			miSession.beginTransaction();
			Query query=miSession.createQuery("update Alumno set Nombre=:nombre,Apellido=:apellido,Email=:email"
					+ ",Direccion=:direccion,Materia=:materia where Dni=:dni");
			query.setParameter("nombre", alumnoActualizado.getNombre());
			query.setParameter("apellido", alumnoActualizado.getApellido());
			query.setParameter("email", alumnoActualizado.getEmail());
			query.setParameter("direccion", alumnoActualizado.getDireccion());
			query.setParameter("materia", alumnoActualizado.getMateria());
			query.setParameter("dni", alumnoActualizado.getDni());
			query.executeUpdate();
		}catch(Exception e){
			System.out.println("error");
			miSession.getTransaction().rollback();
			e.printStackTrace();
		}finally{
			miSession.close();
			miFactory.close();
		}		
	}
}