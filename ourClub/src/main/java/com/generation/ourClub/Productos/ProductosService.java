package com.generation.ourClub.Productos;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service //decir que es un servicio
public class ProductosService {

	public final ArrayList<Producto> lista = new ArrayList<Producto>();
	
	//CONSTRUCTOR
	public ProductosService() {
		lista.add(new Producto("Air force 1", 
				"Este modelo cuenta con colores discretos naranja y gris, medio-tobillo, brinda comodidad a su uso",
				1200.00, 27.0, 10, "imagen1.jpg"));
		lista.add( new Producto("Air force 2", 
				"Este modelo cuenta con colores discretos naranja y gris, medio-tobillo, brinda comodidad a su uso",
				1500.00, 28.0, 12, "imagen2.jpg"));
		lista.add( new Producto("Air force 3", 
				"Este modelo cuenta con colores discretos naranja y gris, medio-tobillo, brinda comodidad a su uso",
				1300.00, 26.0, 7, "imagen3.jpg"));
	}//constructor
	
	//crea el getproductos desde productocontroller
	public ArrayList<Producto> getProductos() {
		return lista;//regresa lista
	}//getProductos

	//GETPRODUCTO
	//crea el getproducto desde productocontroller
	public Producto getProducto(Long prodId) {
		Producto tmpProd=null;//inicializa el producto temporal
		//foreach
		for (Producto producto : lista) {
			if (producto.getId() ==prodId) {
				tmpProd = producto; //tmpProd es un producto temporal
				break;
			}//if==prodId
		}//foreach
		return tmpProd;
	}//getproducto

	//DELETE PRODUCTO
	//crea el deleteproducto desde productocontroller
	public Producto deleteProducto(Long prodId) {
		Producto tmpProd=null;//inicializa el producto temporal
		//foreach
		for (Producto producto : lista) {
			if (producto.getId() ==prodId) {
				//remueve el elemento
				tmpProd = lista.remove(lista.indexOf(producto)); //tmpProd es un producto temporal
				break;
			}//if==prodId
		}//foreach
		return tmpProd;
	}//deleteproducto
	
	//POST PRODUCTO
	//crea el deleteproducto desde productocontroller
	public Producto addProducto(Producto producto) {
		lista.add(producto);
		return producto;
	}//addProducto
	
	//PUT PRODUCTO
	public Producto updateProducto(Long proId, String nombre, String descripcion, double precio, double talla, int existencia, String uRL_imagen) {
		
		Producto tmpProd = null;
		for (Producto producto : lista) {
			if(producto.getId()==proId) {
				if (nombre != null) producto.setNombre(nombre);
				if (descripcion != null)producto.setDescripcion(descripcion);
				if(precio>0) producto.setPrecio(precio);
				if(talla>0) producto.setTalla(talla);
				if(talla>0) producto.setTalla(talla);
				if(existencia>0) producto.setExistencia(existencia);
				if(uRL_imagen != null) producto.setURL_imagen(uRL_imagen);
				tmpProd=producto;
				break;
		 
			}//if
		}//foreach

		return tmpProd;
	}

	
}//class productosService
