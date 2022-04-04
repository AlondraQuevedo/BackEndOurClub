package com.generation.ourClub.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;

import com.generation.ourClub.model.Producto;


@Service //decir que es un servicio
public class ProductosService {

	public final ProductosRepository productosRepository;
	public final ArrayList<Producto> lista = new ArrayList<Producto>();
	
	//CONSTRUCTOR
	public ProductosService(ProductosRepository productosRepository) {
		this.productosRepository = productosRepository;
	}//constructor
	public List<Producto> getProductos() {
		return productosRepository.findAll();


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
