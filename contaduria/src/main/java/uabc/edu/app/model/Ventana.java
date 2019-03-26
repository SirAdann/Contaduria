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
		private String tipo;
		private String estatus;
		
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
		public String getTipo() {
			return tipo;
		}
		public void setTipo(String tipo) {
			this.tipo = tipo;
		}
		public String getEstatus() {
			return estatus;
		}
		public void setEstatus(String estatus) {
			this.estatus = estatus;
		}
		@Override
		public String toString() {
			return "Ventana [idventana=" + idventana + ", nombre=" + nombre + ", liga=" + liga + ", tipo=" + tipo
					+ ", estatus=" + estatus + "]";
		}

		
		
		

}
