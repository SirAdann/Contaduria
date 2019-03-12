package uabc.edu.app.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uabc.edu.app.model.Documento;

public interface DocumentoRepository extends JpaRepository<Documento, Integer> {

	List<Documento> findAll();

	Documento findByNombre(String nombre);
	
	Iterable<Documento>findAllByIdventana(Iterable<Integer> id);
	
	
	List<Documento>findByNombreContaining(String nombre);
	
	
	Iterable<Documento>findAllByIdventanaOrderByOrden(Iterable<Integer> id,Sort id2);
	
	@Query (value="INSERT INTO documentos d (d.id_documento,d.nombre,d.liga,d.id_ventana,d.orden,d.id_tipo_documento,d.id_informes) VALUES (?id,?nombre,?liga,?idventana,?orden,?idtipodocumento,?idinforme)", nativeQuery = true)
	void GrabarDocumento(@Param("iddocumento") Integer id,@Param("nombre") String nombre,@Param("liga") String liga,@Param("idventana") Integer idventana,@Param("orden") Integer orden,@Param("idtipodocumento") Integer idtipodocumento,@Param("idinforme") Integer idinforme);
	
	
	
	



	
	
	
	
	
	
	
	


	
	
	
	
	
	
	

}
