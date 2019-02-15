package uabc.edu.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uabc.edu.app.model.CategoriasInformes;
import uabc.edu.app.model.Ventana;
import uabc.edu.app.repository.CategoriasInformesRepository;

@Service
public class CategoriasInformesServiceJPA implements ICategoriasInformesService {
	
	@Autowired
	CategoriasInformesRepository categoriasRepo;
	

	@Override
	public List<CategoriasInformes> buscarTodas() {
		List<CategoriasInformes> lista = categoriasRepo.findBy();
		return lista;
	}

}
