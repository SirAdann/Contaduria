package uabc.edu.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import uabc.edu.app.model.Dependencia;
import uabc.edu.app.model.Documento;

public interface DependenciaRepository extends JpaRepository<Dependencia, Integer> {

}
