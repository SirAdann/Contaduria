package uabc.edu.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uabc.edu.app.model.Estatus;

@Repository
public interface EstatusRepository extends JpaRepository<Estatus, Integer> {

}
