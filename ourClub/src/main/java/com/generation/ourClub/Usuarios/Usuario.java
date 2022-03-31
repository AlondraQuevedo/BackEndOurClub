package com.generation.ourClub.Usuarios;

public class Usuario {

	//propiedades del usuario
	private String nombre;
	private String correo;
	private String contrasena;
	private String telefono;
	private int id;
	private static int total = 0;
	
	//CONSTRUCTOR
	public Usuario(String nombre, String correo, String contrasena, String telefono) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.contrasena = contrasena;
		this.telefono = telefono;
		total++;
		this.id = total;
	}//constructor
	
	//CONSTRUCTOR VACIO
	public Usuario() {
		total++;
		this.id = total;
	}//constructor

	//GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}//getNombre

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}//SetNombre

	public String getCorreo() {
		return correo;
	}//getCorreo

	public void setCorreo(String correo) {
		this.correo = correo;
	}//setCorreo

	public String getContrasena() {
		return contrasena;
	}//getContrasena

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}//setContrasena

	public String getTelefono() {
		return telefono;
	}//getTelefono

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}//setTelefono

	public static int getTotal() {
		return total;
	}//getTotal

	public static void setTotal(int total) {
		Usuario.total = total;
	}//setTotal

	public int getId() {
		return id;
	}//getId

	//TOSTRING
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", correo=" + correo + ", contrasena=" + contrasena + ", telefono="
				+ telefono + ", id=" + id + "]";
	}//toString
	
}//class
