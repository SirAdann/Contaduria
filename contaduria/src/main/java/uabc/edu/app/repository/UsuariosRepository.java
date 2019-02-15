package uabc.edu.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import uabc.edu.app.model.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {
	
	

}
