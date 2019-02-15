package uabc.edu.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categorias_informes")
public class CategoriasInformes {
	
@Id
@Column(name="id_categoria")
private int idcategoria;
private String nombre;
public int getIdcategoria() {
	return idcategoria;
}
public void setIdcategoria(int idcategoria) {
	this.idcategoria = idcategoria;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
@Override
public String toString() {
	return "CategoriasInformes [idcategoria=" + idcategoria + ", nombre=" + nombre + "]";
}



}
