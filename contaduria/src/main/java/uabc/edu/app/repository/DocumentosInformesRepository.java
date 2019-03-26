package uabc.edu.app.repository;
 
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import uabc.edu.app.model.Documento;
import uabc.edu.app.model.DocumentosInformes;

@Repository
public interface DocumentosInformesRepository extends JpaRepository<DocumentosInformes, Integer> {
	
	@Query (value="SELECT * FROM documentos INNER JOIN documentosinformes ON documentos.id_informes = documentosinformes.id_informes where documentosinformes.anio = :anio  order by  documentos.orden", nativeQuery = true)
	List<DocumentosInformes>findAllDocumentos_documentosInformes(@Param("anio") Integer anio);
	
	
	@Query (value="SELECT * FROM documentos INNER JOIN documentosinformes ON documentos.id_informes = documentosinformes.id_informes  order by  documentosinformes.id_informes", nativeQuery = true)
	List<DocumentosInformes>findAllDocumentos_documentosInformes();
	
	 
}
