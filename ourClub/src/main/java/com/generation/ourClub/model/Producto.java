package com.generation.ourClub.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="producto")
public class Producto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idproducto", unique=true, nullable=false)
	//propiedades de producto
	private Long id;
	private String nombre;
	private String descripcion;
	private double precio;
	private double talla;
	private int existencia;
	private String URL_imagen;
	
	
	//CONSTRUCTOR
	public Producto(Long id, String nombre, String descripcion, double precio, double talla, int existencia, String uRL_imagen) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.talla = talla;
		this.existencia = existencia;
		this.URL_imagen = uRL_imagen;
		this.id=id;
	}//constructor
	
	//CONSTRUCTOR VACIO
	public Producto() {
		
	}//constructor

	//GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}//getNombre

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}//setNombre

	public String getDescripcion() {
		return descripcion;
	}//getDescripcion

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}//setDescripcion

	public double getPrecio() {
		return precio;
	}//getPrecio

	public void setPrecio(double precio) {
		this.precio = precio;
	}//setPrecio

	public double getTalla() {
		return talla;
	}//getTalla

	public void setTalla(double talla) {
		this.talla = talla;
	}//setTalla

	public int getExistencia() {
		return existencia;
	}//getExistencia

	public void setExistencia(int existencia) {
		this.existencia = existencia;
	}//setExistencia
	
	public String getURL_imagen() {
		return URL_imagen;
	}//getURL_imagen

	public void setURL_imagen(String uRL_imagen) {
		this.URL_imagen = uRL_imagen;
	}//setURL_imagen

	public Long getId() {
		return id;
	}//getId

	//TOSTRING
	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", talla=" + talla
				+ ", existencia=" + existencia + ", id=" + id + ", URL_imagen=" + URL_imagen + "]";
	}//toString
	
	
	
	
}//class Productos

