package uabc.edu.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uabc.edu.app.model.Dependencia;
import uabc.edu.app.model.Documento;

@Repository
public interface DependenciaRepository extends JpaRepository<Dependencia, Integer> {

}
