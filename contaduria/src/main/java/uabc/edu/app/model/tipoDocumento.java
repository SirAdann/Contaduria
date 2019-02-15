package uabc.edu.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipodocumento")
public class tipoDocumento {
	
	@Id
	@Column(name="id_tipo_documento")
	private int idtipodocumento;
	private String icono;
	private String documento;
	
	public tipoDocumento(){
		
	}

	
	public int getIdtipodocumento() {
		return idtipodocumento;
	}


	public void setIdtipodocumento(int idtipodocumento) {
		this.idtipodocumento = idtipodocumento;
	}


	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}


	@Override
	public String toString() {
		return "tipoDocumento [idtipodocumento=" + idtipodocumento + ", icono=" + icono + ", documento=" + documento
				+ "]";
	}

	
	
	

}
