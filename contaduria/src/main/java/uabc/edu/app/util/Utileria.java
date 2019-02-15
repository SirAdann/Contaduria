package uabc.edu.app.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import uabc.edu.app.model.Documento;
import uabc.edu.app.model.Ventana;
import uabc.edu.app.model.tipoDocumento;
import uabc.edu.app.repository.DocumentoRepository;
import uabc.edu.app.service.DocumentoServiceJPA;
import uabc.edu.app.service.IDocumentoService;

public class Utileria {
	
	

	@Autowired
	 public  IDocumentoService m;
	
public static String guardarDocumento(MultipartFile multiPart, HttpServletRequest request, String extension, String ventana) {
		
		//Se obtiene el nombre del archivo
		String nombreArchivo = multiPart.getOriginalFilename();
		
		System.out.println("Nombre del archivo original: " +nombreArchivo);
		nombreArchivo = nombreArchivo.replaceAll(" ", "-");
		System.out.println("Nombre del archivo sin espacios: "+nombreArchivo);

		
		String liga = null;
		
		
		
		//nombreFinal = nombreFinal.concat(extension);
				// Obtenemos la ruta ABSOLUTA del directorio images
		// Apache-tomcat/webapps/sgc/resources/docs/
		//String rutaFinal = request.getServletContext().getRealPath("/resources/docs/"+tipoDocumento+"/"+ventana+"/");
		String rutaFinal = request.getServletContext().getRealPath("/resources/docs/"+ventana+"/");

		//String rutaFinal = "C:/Documents/workspace-sts-3.9.1.RELEASE/contaduria/webapp/resources/docs/"+ventana+"/";
		System.out.println("Ruta final: " + rutaFinal);
		System.out.println("Nombre final: " + liga);
		//rutaFinal = rutaFinal.concat(nombreFinal);
		try {
			// Formamos el nombre del archivo para guardarlo en el disco duro
			File imageFile = new File(rutaFinal + nombreArchivo);
			System.out.println(imageFile.getAbsolutePath());
			// Aquì se guarda fìsicamente el archivo en el disco duro
			liga="docs/"+ventana+"/"+nombreArchivo;
			System.out.println(liga);
			multiPart.transferTo(imageFile);
			return liga;
		} catch (IOException e) {
			System.out.println("Error " + e.getMessage());
			return null;
		}
	}

	//Método para generar una cadena de longitud N de caracteres aleatorios
	public static String randomAlphaNumeric(int count) {
		String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * CARACTERES.length());
			builder.append(CARACTERES.charAt(character));
		}
		return builder.toString();
	}
	
	//Método para generar la fecha actual
	public static Date generarFecha() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
		Calendar calendar = Calendar.getInstance();
		Date current = Calendar.getInstance().getTime();
		System.out.println("Prueba uno: " + dateFormat.format(calendar.getTime()));
		System.out.println("Prueba dos: " + current);
		return current;
	}
	
	
	
	
		
	
	
	
	
	//Método para identificar y agregar las extensiones al nombre de los archivos
	public static String agregarExtensionArchivos(MultipartFile multiPart) {
		
		// Se obtiene el nombre original del archivo
		String nombreOriginal = multiPart.getOriginalFilename();		
		nombreOriginal = nombreOriginal.replace(" ", "-");
		System.out.println(nombreOriginal);
		String extension = "";
		
		int contador = nombreOriginal.lastIndexOf(".");
		if(contador > 0) {
			int largoExtension = nombreOriginal.length();
			extension = nombreOriginal.substring(contador, largoExtension);
			extension.toLowerCase();
	
		}
		return extension;
	}
	
	//Método para identificar y eliminar las extensiones al nombre de los archivos
	public static String eliminarExtensionArchivos(MultipartFile multiPart) {
		// Se obtiene el nombre del archivo que aparece en ruta
		String ruta = "";
		return ruta;
	}
	
	//Método para identificar el tipo de archivo que se guardará en la base de datos
	public static int identificarExtensionArchivos(String extension, List<tipoDocumento> listatipoDocumento) {
		int id_tipo_documento = 0;
		int contador = 0;
		extension = extension.toLowerCase();
		
		while(contador<5) {
			tipoDocumento tipoDocumento = listatipoDocumento.get(contador);
			String ruta = tipoDocumento.getDocumento();
			System.out.println("Ruta: " + ruta);
			System.out.println("Extension: " + extension);
			if(ruta.equals(extension)) {
				id_tipo_documento = tipoDocumento.getIdtipodocumento();
				System.out.println("id_tipo_archivo: " + id_tipo_documento);
			}
			contador++;
		}
		System.out.println("id_tipo_archivo: " + id_tipo_documento);
		
		return id_tipo_documento;
	}
	
	//Método para identificar la clasificación de los documentos
	public static List<Documento> identificarDocumento(List<Documento> lista) {
		
		return lista;
	}
	
	//Método para identificar los documentos que corresponden a una vista
	//public static List<Documento> identificarDocumentosPorDepartamento(List<Documento> listaDocumento, int id_departamento, int id_tipo_documento) {
	//	List<Documento> documento = new ArrayList<Documento>();
	//	for (int index=0; index < listaDocumento.size(); index++) {
			//Documento doc = listaDocumento.get(index);
			//if((doc.getId_departamento() == id_departamento) && (doc.getId_tipo_documento() == id_tipo_documento) && (doc.getEstatus().equals("Activo"))){
			//	documento.add(doc);
			//}
	//	}
	//	return documento;
	//}
	
	
	
	//Método para obtener la nomenclatura de la ventana
	//	public static String nomenclaturaVentana(Documento documento, List<Ventana> listaVentana) {
		//	int id_ventana = documento.getId_ventana();
			
		//	int cont = 0;
		//	String nomenclaturaVentana = "";
		//	while(cont<4) {
		//		Ventana vent = listaVentana.get(cont);
		//		int id = vent.getId_ventana();
		//		if(id_ventana == id) {
		//			nomenclaturaVentana = vent.getnomenclatura();
		//		}
		//		cont++;
		//	}
			
		//	System.out.println("   ");
		//	System.out.println("Nomenclatura: " + nomenclaturaVentana);
		//	System.out.println("   ");
			
		//	return nomenclaturaVentana;
	//	}
		//Método para obtener el nombre de la ventana
				public static String obtenerVentana(Documento documento, List<Ventana> listaVentana) {
					int id_ventana = documento.getIdventana();
					
					int cont = 0;
					String ventana = "";
					while(cont<14) {
						Ventana vent = listaVentana.get(cont);
						int id = vent.getIdventana();
						if(id_ventana == id) {
							ventana = vent.getLiga();
						}
						cont++;
					}
					
			
					
					return ventana;
			}
				
				
			
				
				
				
				
}
