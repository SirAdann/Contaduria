package uabc.edu.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "dependencias")
public class Dependencia {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_dependencia")
	private int iddependencia;
	private int campus;
	private String dependencia;
	
	public int getIddependencia() {
		return iddependencia;
	}
	
	public void setIddependencia(int iddependencia) {
		this.iddependencia = iddependencia;
	}
	
	public int getCampus() {
		return campus;
	}
	
	public void setCampus(int campus) {
		this.campus = campus;
	}
	
	public String getDependencia() {
		return dependencia;
	}
	
	public void setDependencia(String dependencia) {
		this.dependencia = dependencia;
	}
	
	@Override
	public String toString() {
		return "Dependencia [iddependencia=" + iddependencia + ", campus=" + campus + ", dependencia=" + dependencia
				+ "]";
	}
}
