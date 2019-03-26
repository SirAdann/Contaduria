package uabc.edu.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uabc.edu.app.model.Ventana;

@Repository
public interface VentanaRepository extends JpaRepository<Ventana, Integer> {
	

}
