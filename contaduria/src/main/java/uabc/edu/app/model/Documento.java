package uabc.edu.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.validation.constraints.Null;

import uabc.edu.app.util.Utileria;

@Entity
@Table(name = "documentos")
public class Documento {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_documento")
	private int iddocumento;
	private String nombre;
	private String liga;
	@Column(name="id_ventana")
	private int idventana;
	private int orden;
	@Column(name="id_tipo_documento")
	private int idtipodocumento;
	@Column(name="id_informes")
	private int idinformes;
	
	
	
	
	

	public Documento() {
		
		idinformes=0;

	}


	public int getIddocumento() {
		return iddocumento;
	}


	public void setIddocumento(int iddocumento) {
		this.iddocumento = iddocumento;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getLiga() {
		return liga;
	}


	public void setLiga(String liga) {
		this.liga = liga;
	}


	public int getIdventana() {
		return idventana;
	}


	public void setIdventana(int idventana) {
		this.idventana = idventana;
	}


	public int getOrden() {
		return orden;
	}


	public void setOrden(int orden) {
		this.orden = orden;
	}


	public int getIdtipodocumento() {
		return idtipodocumento;
	}


	public void setIdtipodocumento(int idtipodocumento) {
		this.idtipodocumento = idtipodocumento;
	}
	
	


	public int getIdinformes() {
		return idinformes;
	}


	public void setIdinformes(int idinformes) {
		this.idinformes = idinformes;
	}


	@Override
	public String toString() {
		return "Documento [iddocumento=" + iddocumento + ", nombre=" + nombre + ", liga=" + liga + ", idventana="
				+ idventana + ", orden=" + orden + ", idtipodocumento=" + idtipodocumento + ", idinformes=" + idinformes
				+ "]";
	}


	


	



}
