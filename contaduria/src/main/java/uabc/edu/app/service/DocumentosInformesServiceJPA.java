package uabc.edu.app.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uabc.edu.app.model.Documento;
import uabc.edu.app.model.DocumentosInformes;
import uabc.edu.app.repository.DocumentoRepository;
import uabc.edu.app.repository.DocumentosInformesRepository;


@Service
public class DocumentosInformesServiceJPA implements IDocumentosInformesService {
	@Autowired
	private DocumentosInformesRepository DocumentosInfRepo;

	@Override
	public List<DocumentosInformes> buscardocumentos_informes(int anio) {
		List<DocumentosInformes> lista = DocumentosInfRepo.findAllDocumentos_documentosInformes(anio);

		return lista;
	}

	@Override
	public List<DocumentosInformes> buscardocumentos_informes() {
		List<DocumentosInformes> lista = DocumentosInfRepo.findAllDocumentos_documentosInformes();
		return lista;
	}

	@Override
	public void insertar(DocumentosInformes documentosinformes) {
		
		DocumentosInfRepo.save(documentosinformes);
		
	}

	

	

}
