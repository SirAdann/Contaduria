package uabc.edu.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uabc.edu.app.model.Estatus;
import uabc.edu.app.repository.DocumentoRepository;
import uabc.edu.app.repository.EstatusRepository;


@Service
public class EstatusServiceJPA implements IEstatusService {
	
	@Autowired
	private EstatusRepository EstatusRepo;
	
	
	

	@Override
	public List<Estatus> buscarTodos() {
		List<Estatus> lista =EstatusRepo.findAll();
		
		
		return lista;
	}

}
