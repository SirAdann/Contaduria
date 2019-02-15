package uabc.edu.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "documentos")
public class DocumentoInforme {
	
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
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_informes")
	private Informe idInformes;
	
	public DocumentoInforme() {
		
	
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

	public Informe getidInformes() {
		return idInformes;
	}
	public void setidInformes(Informe idInformes) {
		this.idInformes = idInformes;
	}
	@Override
	public String toString() {
		return "DocumentoInformes [iddocumento=" + iddocumento + ", nombre=" + nombre + ", liga=" + liga
				+ ", idventana=" + idventana + ", orden=" + orden + ", idtipodocumento=" + idtipodocumento
				+ ", idInformes=" + idInformes + "]";
	}
}
