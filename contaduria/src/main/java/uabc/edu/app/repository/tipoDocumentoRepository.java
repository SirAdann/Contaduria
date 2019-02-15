package uabc.edu.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import uabc.edu.app.model.tipoDocumento;

public interface tipoDocumentoRepository extends JpaRepository<tipoDocumento, Integer> {
	
	// select * from Tipo_Documento
		List<tipoDocumento>findBy();
		
		
		

}
