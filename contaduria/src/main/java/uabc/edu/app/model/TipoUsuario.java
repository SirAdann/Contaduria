package uabc.edu.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipousuario")
public class TipoUsuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_usuario")
	private int idtipousuario;
	private String tipo;
	
	
	public int getIdtipousuario() {
		return idtipousuario;
	}
	public void setIdtipousuario(int idtipousuario) {
		this.idtipousuario = idtipousuario;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		return "TipoUsuario [idtipousuario=" + idtipousuario + ", tipo=" + tipo + "]";
	}
	

}
