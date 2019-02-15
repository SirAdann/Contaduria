package uabc.edu.app.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import uabc.edu.app.model.CategoriasInformes;
import uabc.edu.app.model.Documento;
import uabc.edu.app.model.DocumentoInforme;
import uabc.edu.app.model.DocumentosInformes;
import uabc.edu.app.model.Ventana;
import uabc.edu.app.model.tipoDocumento;
import uabc.edu.app.service.ICategoriasInformesService;
import uabc.edu.app.service.IDocumentoService;
import uabc.edu.app.service.IDocumentosInformesService;
import uabc.edu.app.service.ItipoDocumentoService;
import uabc.edu.app.util.Utileria;
import sun.util.BuddhistCalendar;

@Controller
@RequestMapping("/cierre")
public class CierresController {

	

	@Autowired
	private ItipoDocumentoService serviceTipoDocumento;

	@Autowired
	private IDocumentosInformesService metodosInformesDocumentos;
	

	@Autowired
	private IDocumentoService metodosDocumentos;

	@Autowired
	private ICategoriasInformesService metodosCategoriasInformes;

	@GetMapping(value = "/principal")
	public String mostrarPrincipal(Model modelo) {

		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		modelo.addAttribute("anio", year);

		List<DocumentosInformes> listadocs = metodosInformesDocumentos.buscardocumentos_informes(year);
		modelo.addAttribute("documentos", listadocs);

		System.out.println("lista de los docs " + listadocs);
		return "cierre/cierres";
	}

	@GetMapping(value = "/anio")
	public String mostrarAnio(Model modelo, @RequestParam("anio") int anio) {

		modelo.addAttribute("anio", anio);

		List<DocumentosInformes> listadocs = metodosInformesDocumentos.buscardocumentos_informes(anio);
		modelo.addAttribute("documentos", listadocs);

		System.out.println("lista de los docs " + listadocs);
		return "cierre/cierres";
	}

	@GetMapping("/crear")
	public String crear(@ModelAttribute DocumentoInforme documentoinforme, Model model) {

		List<CategoriasInformes> listaCategorias = metodosCategoriasInformes.buscarTodas();

		model.addAttribute("Categorias", listaCategorias);

		return "formularios/formDocumentosNuevoInforme";

	}

	@PostMapping("/guardar")
	public String guardar(@ModelAttribute DocumentosInformes documentosInformes, BindingResult result, RedirectAttributes attribute,
			@RequestParam("archivo") MultipartFile multiPart, HttpServletRequest request) {
		
		
		
		
		
		if (result.hasErrors()) {
			System.out.println(documentosInformes);
			System.out.println("Existieron errores");

			return "Documentos/formDocumentosNuevo";
		}
		
		//LISTA DE DOCUMENTOS INFORMES
		List<DocumentosInformes> listaDocsInformes = metodosInformesDocumentos.buscardocumentos_informes();
		
		// imprimir lista de los documentos
		//System.out.println("lista  de documentos informes ordenados por orden " + listaDocsInformes);
		
		
		// pasar el ultimo elemento de la lista a un objeto
		
		int ordenfinal=0;
		
		for (DocumentosInformes docinf: listaDocsInformes) {
			
			
						
			ordenfinal++;
			


			
		}
		ordenfinal++;
		System.out.println("Orden final "+ordenfinal);
		documentosInformes.setOrden(ordenfinal);
		documentosInformes.setIdinformes(ordenfinal);
		
		System.out.println("datos del formulario "+documentosInformes);

		String ventana = "Cierres";

		
		System.out.println("ENTRANDO AL METODOOO");

		////////////////////////////////////////////////////////////////////////////////////////////


		// Se identifica la extensión del archivo que se va a guardar y se inserta en la
		// variable
		
		System.out.println("Metodo Extension de archivo " );

		
		String extension = Utileria.agregarExtensionArchivos(multiPart);

		System.out.println("Extension: " + extension);
		
		
		System.out.println("FIN Metodo Extension de archivo " );

		

		// verificado
		List<tipoDocumento> listaTipoArchivo = serviceTipoDocumento.buscarTodas();
	//	System.out.println("lista de tipo documento: " + listaTipoArchivo);

		
		System.out.println("Metodo tipo de archivo " );


		int id_tipo_archivo = Utileria.identificarExtensionArchivos(extension, listaTipoArchivo);

		System.out.println("FIN Metodo tipo de archivo " );

		

		extension = extension.toLowerCase();

		documentosInformes.setIdtipodocumento(id_tipo_archivo);

		if (!multiPart.isEmpty()) {
			System.out.println("Metodo de liga de ducumento" );

			String nombreDocumento = Utileria.guardarDocumento(multiPart, request, extension, ventana);
			documentosInformes.setLiga(nombreDocumento);
			
			System.out.println("FIN Metodo de liga de ducumento" );

		}

		System.out.println(documentosInformes);
		// Se insertan los datos del documento en la base de datos
		metodosInformesDocumentos.insertar(documentosInformes);
		//metodosDocumentos.insertar2(documentosInformes.getIddocumento(), documentosInformes.getNombre(), documentosInformes.getLiga(), documentosInformes.getIdventana(), documentosInformes.getOrden(), documentosInformes.getIdtipodocumento(), documentosInformes.getIdinformes());
		
		//attribute.addFlashAttribute("mensaje", "El registro fue guardado");
		return "redirect:/documentos/index";
	}

	
	
	
	
	

	

}	
	

	
