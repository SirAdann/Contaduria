package uabc.edu.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "documentosinformes")
public class Informe {
	@Id
	@Column(name="id_informes")
	private int idInformes;
	private int categoria;
	private int mes;
	private int anio;
	
	public Informe() {
		
	}

	public int getidInformes() {
		return idInformes;
	}

	public void setidInformes(int idInformes) {
		this.idInformes = idInformes;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	@Override
	public String toString() {
		return "Informe [idInformes=" + idInformes + ", categoria=" + categoria + ", mes=" + mes + ", anio=" + anio
				+ "]";
	}
}