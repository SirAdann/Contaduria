package uabc.edu.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "estatus")
public class Estatus {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_Estatus")
	private int idestatus;
	private String estatus;
	public int getIdestatus() {
		return idestatus;
	}
	public void setIdestatus(int idestatus) {
		this.idestatus = idestatus;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	@Override
	public String toString() {
		return "Estatus [idestatus=" + idestatus + ", estatus=" + estatus + "]";
	}
	
	

}
