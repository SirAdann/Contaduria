package uabc.edu.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import uabc.edu.app.model.Documento;
import uabc.edu.app.model.Ventana;
import uabc.edu.app.model.tipoDocumento;
import uabc.edu.app.service.IDocumentoService;
import uabc.edu.app.service.IVentanaService;
import uabc.edu.app.service.ItipoDocumentoService;
import uabc.edu.app.util.Utileria;

@Controller
@RequestMapping("/documentos")
public class DocumentosController {

	@Autowired
	private ItipoDocumentoService serviceTipoDocumento;

	@Autowired
	private IDocumentoService serviceDocumento;

	@Autowired
	private IVentanaService serviceVentana;

	@Autowired
	private IDocumentoService metodosDocumentos;

	@GetMapping("index")
	public String mostrarDocumentos(Model modelo) {
		System.out.println("Paso 1");
		//List<Documento> listadocumentos = metodosDocumentos.buscarTodos();
		System.out.println("Paso 2");
		//List<Ventana> listaVentanas = serviceVentana.buscarTodas();
		System.out.println("Paso 3");
		//modelo.addAttribute("documentos", listadocumentos);
		System.out.println("Paso 4");
		//modelo.addAttribute("ventanas", listaVentanas);
		System.out.println("Paso 5");
		return "listas/listDocumentos";

	}

	@GetMapping("busqueda")
	public String mostrarDocumentosBusqueda(Model modelo, @RequestParam("nombre") String nombre) {
		System.out.println("Cadena: " + nombre);
		String cadena2 = "%" + nombre + "%";

		System.out.println("Cadena2: " + cadena2);

		List<Documento> lista = new ArrayList<Documento>();

		lista = metodosDocumentos.BuscarDocumentosPorNombre(cadena2);
		
		if(lista.isEmpty()) {
			
		}

		System.out.println("Lista: " + lista);

		modelo.addAttribute("documentos", lista);

		return "listas/listDocumentos";

	}

	@GetMapping("/crear")
	public String crear(@ModelAttribute Documento documento, Model model) {

		int idventana = documento.getIdventana();
		System.out.println("id del imput options" + idventana);
		List<Ventana> listaVentana = serviceVentana.buscarTodas();

		model.addAttribute("ventanas", listaVentana);

		return "formularios/formDocumentosNuevo";

	}

	@PostMapping("/guardar")
	public String guardar(@ModelAttribute Documento documento, BindingResult result, RedirectAttributes attribute,
			@RequestParam("archivo") MultipartFile multiPart, HttpServletRequest request) {
		System.out.println(documento);
		if (result.hasErrors()) {
			System.out.println(documento);
			System.out.println("Existieron errores");

			return "formularios/formDocumentosNuevo";
		}

		System.out.println(documento.getOrden());

		List<Ventana> listaVentana = serviceVentana.buscarTodas();
		
		String ventana = Utileria.obtenerVentana(documento, listaVentana);
		System.out.println("ventana: " + ventana);

		// INICIO
		int orden = documento.getOrden();

		List<Documento> listaDocs = metodosDocumentos.BuscarDocumentoVentanaOrdenarporOrden(documento.getIdventana(),Sort.by("orden").descending());
		if (listaDocs.isEmpty()) {
			orden = 1;
			documento.setOrden(orden);
		}

		// imprimir lista de los documentos
		System.out.println("lista de documentos por id ventana: " + listaDocs);

		System.out.println("ENTRANDO AL METODOOO");

		// enviar la lista de documentos de la ventana y el orden de insercion de el
		// archivo

		metodosDocumentos.actualizarOrdenNuevo(orden, listaDocs);
		// FIN ORDENADO

		// Se identifica la extensión del archivo que se va a guardar y se inserta en la
		// variable
		String extension = Utileria.agregarExtensionArchivos(multiPart);

		System.out.println("Extension1: " + extension);

		// verificado
		List<tipoDocumento> listaTipoArchivo = serviceTipoDocumento.buscarTodas();
		System.out.println("lista de tipo documento: " + listaTipoArchivo);

		// verificado!

		int id_tipo_archivo = Utileria.identificarExtensionArchivos(extension, listaTipoArchivo);

		System.out.println("sin verificar lo de abajo");

		extension = extension.toLowerCase();

		documento.setIdtipodocumento(id_tipo_archivo);

		if (!multiPart.isEmpty()) {
			String nombreDocumento = Utileria.guardarDocumento(multiPart, request, extension, ventana);
			documento.setLiga(nombreDocumento);
		}

		// Se insertan los datos del documento en la base de datos
		System.out.println(documento);
		serviceDocumento.insertar(documento);

		attribute.addFlashAttribute("mensaje", "El registro fue guardado");
		return "redirect:/documentos/index";
	}

	@GetMapping(value = "editar/{id}")
	public String editar(@PathVariable("id") int id_documento, Model model) {
		List<tipoDocumento> listaTipoDocumento = serviceTipoDocumento.buscarTodas();
		model.addAttribute("tipo_documento", listaTipoDocumento);

		List<Ventana> listaVentana = serviceVentana.buscarTodas();
		model.addAttribute("ventanas", listaVentana);
		Documento documento = serviceDocumento.BuscarDocumento(id_documento);
		model.addAttribute("documento", documento);
		
		System.out.println(documento);
		
		
		return "formularios/formDocumentosNuevo";
	}

	@GetMapping(value = "eliminar/{id}")
	public String eliminar(@PathVariable("id") int id_documento, RedirectAttributes attributes) {

		Documento documento = metodosDocumentos.BuscarDocumento(id_documento);
		int orden = documento.getOrden();

		List<Documento> listaDocs = metodosDocumentos.BuscarDocumentoVentanaOrdenarporOrden(documento.getIdventana(),
				Sort.by("orden").descending());
		int elementosEnLista = 0;
		for (Documento doc : listaDocs) {
			elementosEnLista++;

		}

		if (elementosEnLista > 1) {
			serviceDocumento.eliminar(id_documento);
			metodosDocumentos.actualizarOrdenEliminar(orden, listaDocs);
			attributes.addFlashAttribute("mensaje", "El documento fue eliminado");

		} else {
			serviceDocumento.eliminar(id_documento);
			attributes.addFlashAttribute("mensaje", "El documento fue eliminado");

		}

		return "redirect:/documentos/index";
	}
	
	
	
	

}
