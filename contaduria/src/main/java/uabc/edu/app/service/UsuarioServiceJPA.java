package uabc.edu.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uabc.edu.app.model.Documento;
import uabc.edu.app.model.Usuario;
import uabc.edu.app.repository.UsuariosRepository;

@Service
public class UsuarioServiceJPA implements IUsuarioService {
	
	@Autowired
	private UsuariosRepository UsuariosRepo; 

	@Override
	public List<Usuario> buscarTodos() {
		List<Usuario> lista = UsuariosRepo.findAll();		
		return lista;
	}

	@Override
	public void insertar(Usuario usuario) {
		UsuariosRepo.save(usuario);		
	}

	@Override
	public void eliminar(int id_usuario) {
		UsuariosRepo.deleteById(id_usuario);
		
	}

	@Override
	public Usuario buscarporid(int id_usuario) {
		Optional<Usuario> optional = UsuariosRepo.findById(id_usuario);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public Usuario buscarPorCorreo(String correo) {
		Usuario usuario = UsuariosRepo.findByCorreo(correo);
		return usuario;
	}
}
