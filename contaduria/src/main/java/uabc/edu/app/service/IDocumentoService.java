package uabc.edu.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;

import uabc.edu.app.model.Documento;

public interface IDocumentoService {

	List<Documento> buscarTodos();

	Documento BuscarDocumento(String nombre);

	void insertar(Documento documento);
	
	void insertar2(int id,String nombre,String liga,int idventana,int orden,int idtipodocumento,int idinformes);
	
	List<Documento>BuscarDocumentos(int id);
	
	Documento BuscarDocumento(int id);
	
	List<Documento>BuscarDocumentoVentana(int id);
	
	List<Documento>BuscarDocumentoVentanaOrdenarporOrden(int id,Sort sort);


	void eliminar(int id_documento);


	void actualizarOrdenNuevo(int orden, List<Documento> listaDocs);

	void actualizarOrdenEliminar(int orden, List<Documento> listaDocs);
	
	
	List<Documento> BuscarDocumentosPorNombre(String nombre);
	
	
	

	

	
}
