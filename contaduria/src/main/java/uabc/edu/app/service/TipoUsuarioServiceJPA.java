package uabc.edu.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uabc.edu.app.model.TipoUsuario;
import uabc.edu.app.model.Usuario;
import uabc.edu.app.repository.TipoUsuariosRepository;
import uabc.edu.app.repository.tipoDocumentoRepository;

@Service
public class TipoUsuarioServiceJPA implements ITipoUsuarioService {
	
	
	@Autowired
	private TipoUsuariosRepository tipoUsuariosRepo;
	
	
	
	@Override
	public List<TipoUsuario> buscarTodos() {
		List<TipoUsuario> lista = tipoUsuariosRepo.findAll();		
		return lista;
	}
	

}
