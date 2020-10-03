package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="institucion")
public class Institucion {
	
	@Column(name="NroEscuela")
	@Id
	private String nroEscuela;
	
	@Column(name="Nombre")
	private String nombre;
	
	@Column(name="Direccion")
	private String direccion;
	
	@Column(name="Telefono")
	private String telefono;
	
	@OneToMany(mappedBy="institucion")
	private List<Alumno> alumnos;
	
	public Institucion(String nroEscuela, String nombre, String direccion, String telefono) {
		this.nroEscuela = nroEscuela;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	
	public Institucion() {
	}
	public Institucion(String nroEscuela) {
		this.nroEscuela = nroEscuela;
	}

	public String getNroEscuela() {
		return nroEscuela;
	}

	public void setNroEscuela(String nroEscuela) {
		this.nroEscuela = nroEscuela;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public List<Alumno> getAlumnos() {
		return alumnos;
	}
	
	public void agregarAlumnos(Alumno alumno){
		if(alumnos==null){
			alumnos=new ArrayList<Alumno>();
		}
		alumnos.add(alumno);
		alumno.setInstitucion(this);
	}

	@Override
	public String toString() {
		return "Institucion [nroEscuela=" + nroEscuela + ", nombre=" + nombre + ", direccion=" + direccion
				+ ", telefono=" + telefono + "]";
	}
}