package uabc.edu.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import uabc.edu.app.model.Ventana;

public interface VentanaRepository extends JpaRepository<Ventana, Integer> {
	
		List<Ventana> findBy();

}
