package uabc.edu.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;


@Entity
@Table(name = "documentos")
@SecondaryTable(name="documentosinformes")
public class DocumentosInformes {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_documento", table="documentos")
	private int iddocumento;
	@Column(table="documentos")
	private String nombre;
	@Column(table="documentos")
    private String liga;
	@Column(name="id_ventana", table="documentos")
	private int idventana;
	@Column(table="documentos")
	private int orden;
	@Column(name="id_tipo_documento", table="documentos")
	private int idtipodocumento;
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_informes", table="documentos")
	private int idinformes;
	@Column(table = "documentosinformes")
	private int anio;
	@Column(table = "documentosinformes")
	private String mes;
	@Column(table = "documentosinformes")
	private int categoria;
	


	
	
	
	
	

	public DocumentosInformes() {

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


	public int getAnio() {
		return anio;
	}


	public void setAnio(int anio) {
		this.anio = anio;
	}


	public String getMes() {
		return mes;
	}


	public void setMes(String mes) {
		this.mes = mes;
	}


	public int getCategoria() {
		return categoria;
	}


	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}


	@Override
	public String toString() {
		return "DocumentosInformes [iddocumento=" + iddocumento + ", nombre=" + nombre + ", liga=" + liga
				+ ", idventana=" + idventana + ", orden=" + orden + ", idtipodocumento=" + idtipodocumento
				+ ", idinformes=" + idinformes + ", anio=" + anio + ", mes=" + mes + ", categoria=" + categoria + "]";
	}


	
	
	




	

}


