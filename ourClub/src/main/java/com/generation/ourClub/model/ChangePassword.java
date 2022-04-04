package com.generation.ourClub.model;

public class ChangePassword {
	private String nombre;
	private String contrasena;
	private String nuevaContrasena;
	public ChangePassword(String nombre, String contrasena, String nuevaContrasena) {
		super();
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.nuevaContrasena = nuevaContrasena;
	}
	//constructor vacio
	public ChangePassword(){
		
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getNuevaContrasena() {
		return nuevaContrasena;
	}
	public void setNuevaContrasena(String nuevaContrasena) {
		this.nuevaContrasena = nuevaContrasena;
	}
	@Override
	public String toString() {
		return "ChangePassword [nombre=" + nombre + ", contrasena=" + contrasena + ", nuevaContrasena="
				+ nuevaContrasena + "]";
	}
	
	
	
}
