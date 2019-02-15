package uabc.edu.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uabc.edu.app.model.tipoDocumento;
import java.util.Optional;
import uabc.edu.app.repository.tipoDocumentoRepository;

@Service
public class tipoDocumentoServiceJPA implements ItipoDocumentoService {
	
	
	
	@Autowired
	private tipoDocumentoRepository tipoDocumentoRepo;

	@Override
	public List<tipoDocumento> buscarTodas() {
		List<tipoDocumento> lista = tipoDocumentoRepo.findAll();
		return lista;
	}

	
	@Override
	public tipoDocumento buscarPorId(int id_tipo_documento) {
		Optional<tipoDocumento> optional = tipoDocumentoRepo.findById(id_tipo_documento);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	

}
