package uabc.edu.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="ventanas")
public class Ventana {
	
    @Id
    @Column(name="id_ventana")
	private int idventana;
    private String nombre;
	private String liga;
	@Column(name="id_nivel")
	private int idNivel;
	private String estatus;
	@Column(name="id_subMenu")
	private int idsubMenu;
	@Column(name="id_referencia")
	private int idReferencia;
	
	
	
	public Ventana() {
		
	}



	public int getIdventana() {
		return idventana;
	}



	public void setIdventana(int idventana) {
		this.idventana = idventana;
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



	public int getIdNivel() {
		return idNivel;
	}



	public void setIdNivel(int idNivel) {
		this.idNivel = idNivel;
	}



	public String getEstatus() {
		return estatus;
	}



	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}



	public int getIdsubMenu() {
		return idsubMenu;
	}



	public void setIdsubMenu(int idsubMenu) {
		this.idsubMenu = idsubMenu;
	}



	public int getIdReferencia() {
		return idReferencia;
	}



	public void setIdReferencia(int idReferencia) {
		this.idReferencia = idReferencia;
	}



	@Override
	public String toString() {
		return "Ventana [idventana=" + idventana + ", nombre=" + nombre + ", liga=" + liga + ", idNivel=" + idNivel
				+ ", estatus=" + estatus + ", idsubMenu=" + idsubMenu + ", idReferencia=" + idReferencia + "]";
	}





}