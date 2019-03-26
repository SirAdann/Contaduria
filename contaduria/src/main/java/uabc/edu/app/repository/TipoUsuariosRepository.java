package uabc.edu.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uabc.edu.app.model.TipoUsuario;

@Repository
public interface TipoUsuariosRepository extends JpaRepository<TipoUsuario, Integer> {

}
