package uabc.edu.app.service;

import java.util.List;


import uabc.edu.app.model.Documento;
import uabc.edu.app.model.Usuario;

public interface IUsuarioService {
	List<Usuario> buscarTodos();

	void insertar(Usuario usuario);

	void eliminar(int id_usuario);

	Usuario buscarporid(int id_usuario);
	
	Usuario buscarPorCorreo(String correo);

}
