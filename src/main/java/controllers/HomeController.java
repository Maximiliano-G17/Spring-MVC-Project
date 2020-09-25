package controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import models.Alumno;
import service.AlumnoService;

@Controller
public class HomeController {
	
	@Autowired
	private AlumnoService alumnoService;

	@GetMapping("/")
	public ModelAndView paginaPrincipal(){
		ModelAndView mav=new ModelAndView();	
		List alumnos=alumnoService.leerAlumnos();
		mav.addObject("listaAlumnos", alumnos);
		mav.setViewName("home");
		return  mav;
	}
	
//--------------------------METODOS NECESARIOS PARA REGISTRAR A UN ALUMNO--------------------------	
	@GetMapping("/paginaRegistro")
	public String paginaRegistro(Model modelo){
		modelo.addAttribute("alumno", new Alumno());
		return "registrar";
	}
	
	@PostMapping("/paginaConfirmarRegistro")
	public String confirmarRegistro(@Valid @ModelAttribute("alumno") Alumno alumno,BindingResult resultado){
		if(resultado.hasErrors()){
			return "registrar";			
		}else{
			alumnoService.registrarAlumno(alumno);
			return "confirmacion";
		}		
	}

//--------------------------METODOS NECESARIOS PARA ACTUALIZAR A UN ALUMNO--------------------------	
	@GetMapping("/paginaActualizar")
	public String paginaActualizar(Model modelo){
		modelo.addAttribute("alumnoActualizar", new Alumno());
		return "actualizar";
	}
	
	@PostMapping("/paginaConfirmarActualizacion")
	public String alumnoActualizado(@Valid @ModelAttribute("alumnoActualizar") Alumno alumnoActualizado,BindingResult resultado){
		if(resultado.hasErrors()){
			return "actualizar";
		}else{
			alumnoService.actualizarAlumno(alumnoActualizado);
			return "confirmarActualizacion";
		}			
	}

//--------------------------METODOS NECESARIOS PARA ELIMINAR A UN ALUMNO--------------------------	
	@GetMapping("/paginaEliminar")
	public String paginaEliminar(Model modelo){
		modelo.addAttribute("alumnoEliminar",new Alumno());
		return "eliminar";
	}
	
	@PostMapping("/paginaConfirmarEliminacion")
	public String confirmarAlumnoEliminado(@ModelAttribute("alumnoEliminar") Alumno alumnoDNI){
		if(alumnoDNI.getDni()!=null && alumnoDNI.getDni().length()==8){
			alumnoService.eliminarAlumno(alumnoDNI.getDni());
			return "eliminacion";		
		}else{	
			return "eliminar";
		}	
	}
	
//metodo que sirve para verificar que no haya ningun campo con espacios en blanco
	@InitBinder
	public void recortaEspaciosEnBlanco(WebDataBinder binder){
		StringTrimmerEditor recorta =new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, recorta);
	}
}