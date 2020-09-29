package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import models.Institucion;
import service.InstitucionService;

@Controller
@RequestMapping("/institucion")
public class InstiController {
	
	@Autowired
	private InstitucionService intitucionService;
	
	@RequestMapping("/leerInsti")
	public void insertarInstitucion(){
//		Institucion insti=new Institucion("105","Escuela Yrigoyen","Maipu","424242");
		intitucionService.leerInstitucion("28");
	}
}