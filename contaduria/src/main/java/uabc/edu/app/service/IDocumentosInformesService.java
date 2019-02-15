package uabc.edu.app.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import uabc.edu.app.model.Documento;
import uabc.edu.app.model.DocumentosInformes;

public interface IDocumentosInformesService {
	
	List<DocumentosInformes> buscardocumentos_informes(int anio);
	
	
	List <DocumentosInformes> buscardocumentos_informes();
	
	void insertar(DocumentosInformes documentosinformes);
	



}
