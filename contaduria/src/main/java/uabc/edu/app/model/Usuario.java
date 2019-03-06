package uabc.edu.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
	
	@Id
	@Column(name="id_usuarios")
	private int idusuario;
	private String nombre;
	private String apellidos;
	private String correo;
	private String password;
	@Column(name="id_dependencia")
	private int iddependencia;
	@Column(name="id_estatus")
	private int idestatus;
	
	
	
	
	

	
	public Usuario() {
		
	}
	public int getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getIddependencia() {
		return iddependencia;
	}
	public void setIddependencia(int iddependencia) {
		this.iddependencia = iddependencia;
	}
	public int getIdtipousuario() {
		return idtipousuario;
	}
	public void setIdtipousuario(int idtipousuario) {
		this.idtipousuario = idtipousuario;
	}
	public int getIdestatus() {
		return idestatus;
	}
	public void setIdestatus(int idestatus) {
		this.idestatus = idestatus;
	}
	@Override
	public String toString() {
		return "Usuario [idusuario=" + idusuario + ", nombre=" + nombre + ", apellidos=" + apellidos + ", correo="
				+ correo + ", password=" + password + ", iddependencia=" + iddependencia + ", idtipousuario="
				+ idtipousuario + ", idestatus=" + idestatus + "]";
	}

}
