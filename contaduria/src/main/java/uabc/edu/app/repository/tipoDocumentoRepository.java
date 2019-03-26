package uabc.edu.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uabc.edu.app.model.tipoDocumento;

@Repository
public interface tipoDocumentoRepository extends JpaRepository<tipoDocumento, Integer> {
	
	// select * from Tipo_Documento
		List<tipoDocumento>findBy();
		
		
		

}
