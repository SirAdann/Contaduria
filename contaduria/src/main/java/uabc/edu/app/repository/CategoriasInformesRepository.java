package uabc.edu.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import uabc.edu.app.model.CategoriasInformes;


public interface CategoriasInformesRepository extends JpaRepository<CategoriasInformes, Integer> {

	List<CategoriasInformes> findBy();
}
