package com.generation.ourClub.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idusu", unique = true, nullable = false)

	// propiedades del usuario
	private Long id;
	private String nombre;
	private String correo;
	private String contrasena;
	private String telefono;
	private int rol_idrol;
	

	// CONSTRUCTOR
	public Usuario(Long id, String nombre, String correo, String contrasena, String telefono, int idrol) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.contrasena = contrasena;
		this.telefono = telefono;
		this.id=id; 
		this.rol_idrol=rol_idrol;
	}// constructor

	// CONSTRUCTOR VACIO
	public Usuario() {

	}// constructor

	// GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}// getNombre

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}// SetNombre

	public String getCorreo() {
		return correo;
	}// getCorreo

	public void setCorreo(String correo) {
		this.correo = correo;
	}// setCorreo

	public String getContrasena() {
		return contrasena;
	}// getContrasena

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}// setContrasena

	public String getTelefono() {
		return telefono;
	}// getTelefono

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}// setTelefono

	public Long getId() {
		return id;
		
	}// getId

		
	public int getrol_idrol() {
		return rol_idrol;
	}

	public void setrol_idrol(int rol_idrol) {
		this.rol_idrol = rol_idrol;
	}

	// TOSTRING
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", contrasena=" + contrasena
				+ ", telefono=" + telefono + ", rol_idrol=" + rol_idrol + "]";
	}


	

	

}// class
