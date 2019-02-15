package uabc.edu.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uabc.edu.app.model.Documento;
import uabc.edu.app.service.IDocumentoService;

@Controller
public class HomeController {
	
	@Autowired
	private IDocumentoService metodosDocumentos;

	@GetMapping("/")
	public String mostrarPrincipal(Model model) {

		return "home";

	}

	@GetMapping(value = "oficios")
	public String mostrarOficios(@RequestParam String idParam1, Model modelo) {
		int id = Integer.parseInt(idParam1);

		List<Documento> listadocs = metodosDocumentos.BuscarDocumentoVentanaOrdenarporOrden(id,
				Sort.by("orden").descending());

		Documento documento = metodosDocumentos
				.BuscarDocumento("CONCEPTOS DE GASTO NO APROBADOS POR LA SEP PARA COMPROBACION DEL PFCE");
		modelo.addAttribute("documento", documento);
		modelo.addAttribute("documentos", listadocs);

		System.out.println(documento.getLiga());
		return "secciones/oficios";
	}
	
	@GetMapping(value = "cont_gob")
	public String mostrarContGob(@RequestParam String idParam1,Model modelo) {
		
		int id = Integer.parseInt(idParam1);

		List<Documento> listadocs = metodosDocumentos.BuscarDocumentoVentanaOrdenarporOrden(id, Sort.by("orden").descending());

		Documento documento = metodosDocumentos.BuscarDocumento("PLAN DE CUENTAS UABC");
		modelo.addAttribute("documento", documento);
		modelo.addAttribute("documentos", listadocs);

		return "secciones/cont_gob";
	}
	
	
	
	
	

	@GetMapping(value = "LineamientosContables")
	public String mostrarLinCont(@RequestParam String idParam1,Model modelo) {
		
		int id = Integer.parseInt(idParam1);

		List<Documento> listadocs = metodosDocumentos.BuscarDocumentoVentanaOrdenarporOrden(id, Sort.by("orden").descending());

		Documento documento = metodosDocumentos.BuscarDocumento("Criterios contables, fiscales y lineamientos operativos.");
		modelo.addAttribute("documento", documento);
		modelo.addAttribute("documentos", listadocs);

		return "secciones/LineamientosContables";
	}

	@GetMapping(value = "politicas")
	public String mostrarPoliticas(@RequestParam String idParam1,Model modelo) {
		
		int id = Integer.parseInt(idParam1);
		
		
		Documento documento = metodosDocumentos.BuscarDocumento("CONCEPTOS DE GASTO NO APROBADOS POR LA SEP PARA COMPROBACION DEL PFCE");
		System.out.println("documento: "+documento);
		modelo.addAttribute("documento", documento);

		List<Documento> listadocs = metodosDocumentos.BuscarDocumentoVentanaOrdenarporOrden(id, Sort.by("orden").descending());

		modelo.addAttribute("documentos", listadocs);

		return "secciones/Politicas";
	}
	
	
	@GetMapping(value = "capacitaciones")
	public String mostrarCapacitaciones(@RequestParam String idParam1,Model modelo) {
		
		int id = Integer.parseInt(idParam1);
		
		
		//Documento documento = metodosDocumentos.BuscarDocumento("CONCEPTOS DE GASTO NO APROBADOS POR LA SEP PARA COMPROBACION DEL PFCE");
		//modelo.addAttribute("documento", documento);

		List<Documento> listadocs = metodosDocumentos.BuscarDocumentoVentanaOrdenarporOrden(id, Sort.by("orden").descending());

		modelo.addAttribute("documentos", listadocs);

		return "secciones/capacitaciones";
	}

}
