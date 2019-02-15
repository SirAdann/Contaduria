package uabc.edu.app.service;

import java.util.List;

import uabc.edu.app.model.tipoDocumento;

public interface ItipoDocumentoService {
	List<tipoDocumento> buscarTodas();
	tipoDocumento buscarPorId(int id_tipo_documento);

}
