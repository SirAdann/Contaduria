package uabc.edu.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import uabc.edu.app.model.Dependencia;


@Controller
@RequestMapping("/dependencias")
public class DependenciaController {
	
	
	
	
	
	@GetMapping(value = "lista")
	public String mostrarListaUsuarios(Model modelo) {
		
		
	//	List<Dependencia> listaDependencias= metodosUsuarios.buscarTodos();
	//	modelo.addAttribute("dependencias",listaDependencias);
		
		
		
		
		
		

		return "listUsuarios";
	}
	
	
	
	
	@GetMapping(value = "nuevo")
	public String mostrarUsuarioNuevo(Model modelo,@ModelAttribute Dependencia dependencia) {
		
		
	
		
		
		
		
		

		return "formDependenciaNuevo";
	}
	
	
	
	
	

}
