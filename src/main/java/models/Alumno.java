package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="estudiante")
public class Alumno{
	
	@NotNull(message=" Campo Requerido!")
	@Pattern(regexp="[0-9]{8}",message="Numero de DNI no valido.")
	@Column(name="Dni")
	@Id
	private String dni;
	
	@NotNull(message=" Campo Requerido!")
	@Pattern(regexp="[a-zA-Z ]{2,254}",message=" ERROR, No puede haber ningun numero!")
	@Column(name="Nombre")
	private String nombre;
	
	@NotNull(message=" Campo Requerido!")
	@Pattern(regexp="[a-zA-Z ]{2,254}",message=" ERROR, No puede haber ningun numero!")
	@Column(name="Apellido")
	private String apellido;

	@Email(message=" Campo Requerido")
	@Pattern(regexp=".+@.+\\..+", message="Error, Email invado")
	@Column(name="Email")
	private String email;
	
	@NotNull(message=" Campo Requerido!")
	@Size(min=3, message=" Campo Requerido!")
	@Column(name="Direccion")
	private String direccion;
	
	@Column(name="Materia")
	private String materia;
	
	public Alumno(String dni, String nombre, String apellido, String email,String direccion,String materia) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.email = email;
		this.materia=materia;
	}	

	public Alumno() {
		super();
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	@Override
	public String toString() {
		return "Alumno [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", direccion=" + direccion + ", materia=" + materia + "]";
	}
}