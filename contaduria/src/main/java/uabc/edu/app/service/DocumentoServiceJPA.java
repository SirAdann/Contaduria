package uabc.edu.app.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import uabc.edu.app.model.Documento;
import uabc.edu.app.repository.DocumentoRepository;


@Service
public class DocumentoServiceJPA implements IDocumentoService {

	@Autowired
	private DocumentoRepository DocumentosRepo;

	@Override
	public List<Documento> buscarTodos() {
		List<Documento> lista = DocumentosRepo.findAll();
		return lista;
	}
	
	
	//Revisar
	@Override
	public Documento BuscarDocumento(String nombre) {
		Documento doc= DocumentosRepo.findByNombre(nombre);

		return doc;
	}

	@Override
	public void insertar(Documento documento) {
		DocumentosRepo.save(documento);
		
	}

	@Override
	public List<Documento> BuscarDocumentos(int id) {
		List<Integer> ids= new LinkedList<Integer>();
		ids.add(id);
		Iterable<Documento> it =DocumentosRepo.findAllById(ids);
		
		
		List<Documento> lista=new ArrayList<Documento>();
		
		for(Documento doc: it) {
			System.out.println(doc);
		lista.add(doc);
		}
		
		return lista;
	}
	
	
	@Override
	public List<Documento> BuscarDocumentosPorNombre(String nombre) {
		List<String> names= new LinkedList<String>();
		
		
		

		List<Documento> lista=new ArrayList<Documento>();
		
		lista= DocumentosRepo.findByNombreContaining(nombre);
		
		
		
		
		return lista;
	}

	@Override
	public List<Documento> BuscarDocumentoVentana(int id) {
		List<Integer> ids= new LinkedList<Integer>();
		ids.add(id);
	Iterable<Documento> it =DocumentosRepo.findAllByIdventana(ids);
		
		
	List<Documento> lista=new ArrayList<Documento>();
		
	for(Documento doc: it) {
		System.out.println(doc);
	lista.add(doc);
		}
		
	return lista;
	}

	@Override
	public Documento BuscarDocumento(int id) {
		Optional<Documento> optional = DocumentosRepo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void eliminar(int id_documento) {
		DocumentosRepo.deleteById(id_documento);
		
	}

	@Override
	public List<Documento> BuscarDocumentoVentanaOrdenarporOrden(int id, Sort id2) {
		List<Integer> ids= new LinkedList<Integer>();
		ids.add(id);
	Iterable<Documento> it =DocumentosRepo.findAllByIdventanaOrderByOrden(ids, id2);
		
		
	List<Documento> lista=new ArrayList<Documento>();
		
	for(Documento doc: it) {
		System.out.println(doc);
	lista.add(doc);
	}
	
	
	return lista;

	}


	
	//Metodo donde Se reciben parametros de el orden del documento y la lista de los documentos de su ventana
	@Override
	public void actualizarOrdenNuevo(int orden,List <Documento> listaDocs) {
		
		//se pasa el valor del orden a una nueva variable
		int ordenIncremento= orden;
		
		//se recorre la lista visualizando cada documento
		for(Documento doc : listaDocs) {
			
			System.out.println("documento "+doc.getOrden()+ " orden "+ordenIncremento);

			if(doc.getOrden()==ordenIncremento) {
				

			int nuevoOrden=doc.getOrden();
			nuevoOrden++;
				
				int idDocumento=doc.getIddocumento();

				Documento documento=BuscarDocumento(idDocumento);
				System.out.println("documento que se va actualizar "+documento);
				documento.setOrden(nuevoOrden);
				
				System.out.println("documento con nuevo orden en modelo "+documento);

				DocumentosRepo.save(documento);
								
			
				ordenIncremento++;
			}
			
			
		}
		
	
		
	}

	@Override
	public void actualizarOrdenEliminar(int orden, List<Documento> listaDocs) {
		
		
		for(Documento doc : listaDocs) {
			if(doc.getOrden()>orden) {
				
				int nuevoOrden= doc.getOrden();
				nuevoOrden--;
				int idDocumento=doc.getIddocumento();
				Documento documento=BuscarDocumento(idDocumento);
				documento.setOrden(nuevoOrden);


				System.out.println("documento con nuevo orden en modelo "+documento);

				DocumentosRepo.save(documento);
				
				
				
				
			}
			
			
			
			
		}
		
		
		
		
		
	}


	@Override
	public void insertar2(int id,String nombre,String liga,int idventana,int orden,int idtipodocumento,int idinformes) {
		
		DocumentosRepo.GrabarDocumento(id, nombre, liga, idventana, orden, idtipodocumento, idinformes);

		
	}


	


	
	
	
}
