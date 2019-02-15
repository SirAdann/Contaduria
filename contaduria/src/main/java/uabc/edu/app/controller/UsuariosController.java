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
import uabc.edu.app.model.Documento;
import uabc.edu.app.model.Estatus;
import uabc.edu.app.model.TipoUsuario;
import uabc.edu.app.model.Usuario;
import uabc.edu.app.service.IDependenciaService;
import uabc.edu.app.service.IEstatusService;
import uabc.edu.app.service.ITipoUsuarioService;
import uabc.edu.app.service.IUsuarioService;


@Controller
@RequestMapping("/usuarios")
public class UsuariosController {
	@Autowired
	private IUsuarioService metodosUsuarios;
	@Autowired
	private ITipoUsuarioService metodosTipoUsuario;
	
	@Autowired
	private IDependenciaService metodosDependencia;
	
	@Autowired
	private IEstatusService metodosEstatus;
	
	
	
	
	@GetMapping(value = "lista")
	public String mostrarListaUsuarios(Model modelo) {
		
		
		List<Usuario> listaUsuarios= metodosUsuarios.buscarTodos();
		modelo.addAttribute("usuarios",listaUsuarios);
		
		
		
		
		
		

		return "listas/listUsuarios";
	}
	
	
	
	
	@GetMapping(value = "nuevo")
	public String mostrarUsuarioNuevo(Model modelo,@ModelAttribute Usuario usuario) {
		
		
		List<Usuario> listaUsuarios= metodosUsuarios.buscarTodos();
		modelo.addAttribute("usuarios",listaUsuarios);
		
		
		List<TipoUsuario> listaTipoUsuarios= metodosTipoUsuario.buscarTodos();
		modelo.addAttribute("tipoUsuarios",listaTipoUsuarios);
		
		List<Dependencia> listaDependencias= metodosDependencia.buscarTodos();
		modelo.addAttribute("dependencias",listaDependencias);
		
		List<Estatus> listaEstatus= metodosEstatus.buscarTodos();
		modelo.addAttribute("estatus",listaEstatus);
		
		
		
		
		
		
		

		return "formularios/formUsuariosNuevo";
	}
	
	
	@PostMapping("/guardar")
	public String guardar(@ModelAttribute Usuario usuario, BindingResult result, RedirectAttributes attribute, HttpServletRequest request) {
		
		if (result.hasErrors()) {
			System.out.println("Existieron errores");
			
			return "usuarios/formUsuariosNuevo";
		}
		
		System.out.println("Recibiendo objeto película: " + usuario);
		
		metodosUsuarios.insertar(usuario);
		
		attribute.addFlashAttribute("mensaje", "EL registro fue guardado");
		return "redirect:/usuarios/lista";
	}
	
	
	@GetMapping(value="eliminar/{id}")
	public String eliminar(@PathVariable("id") int id_usuario, RedirectAttributes attributes) {
		
		metodosUsuarios.eliminar(id_usuario);
		attributes.addFlashAttribute("mensaje", "El usuario fue eliminado");
		return "redirect:/usuarios/lista";
	}
	
	
	@GetMapping(value="/editar/{id}")
	public String editar(@PathVariable("id") int id_usuario, Model modelo) {
		System.out.println("1");
		
		List<TipoUsuario> listaTipoUsuarios= metodosTipoUsuario.buscarTodos();
		modelo.addAttribute("tipoUsuarios",listaTipoUsuarios);
		System.out.println("2");
		List<Dependencia> listaDependencias= metodosDependencia.buscarTodos();
		modelo.addAttribute("dependencias",listaDependencias);
		System.out.println("3");
		List<Estatus> listaEstatus= metodosEstatus.buscarTodos();
		modelo.addAttribute("estatus",listaEstatus);
		System.out.println("4");
		
		Usuario usuario= metodosUsuarios.buscarporid(id_usuario);
		modelo.addAttribute("usuario",usuario);
		System.out.println("5");
	
		return "formularios/formUsuariosNuevo";
	}
	
	
	
	
	
	

}
