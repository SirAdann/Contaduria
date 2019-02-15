package uabc.edu.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uabc.edu.app.model.Dependencia;
import uabc.edu.app.model.Documento;
import uabc.edu.app.repository.DependenciaRepository;
import uabc.edu.app.repository.DocumentoRepository;

@Service
public class DependenciaServiceJPA implements IDependenciaService {
	
	@Autowired
	private DependenciaRepository DependenciaRepo;

	

	@Override
	public List<Dependencia> buscarTodos() {
		List<Dependencia> lista = DependenciaRepo.findAll();
		return lista;
	}
	
	
	
	

}
