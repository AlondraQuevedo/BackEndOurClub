package com.generation.ourClub.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.generation.ourClub.model.Producto;
import com.generation.ourClub.service.ProductosService;


@RestController
@RequestMapping(path="/api/productos/")//es para mapear con la ruta

public class ProductosController {
	
	private final ProductosService productosService;//constante para traer los productos de producto service
	@Autowired //crea instancia de productos Service
	//se crea constructor con la constante nueva
	public ProductosController(ProductosService productosService) {
		this.productosService = productosService;
	}//constructor
	
	@GetMapping
	public List<Producto> getProductos(){
		return productosService.getProductos();
	}//getProductos
	
	//se asigna una variable para poder ejecutar en ruta
	@GetMapping(path="{prodId}")
	public Producto getProducto(@PathVariable("prodId") Long prodId) {
		return productosService.getProducto(prodId);//regresa el producto
	}//getProducto
	
	//DELETE
//	@DeleteMapping(path="{prodId}")//se pide el id para eliminar
//	public Producto deleteProducto(@PathVariable("prodId") Long prodId) {
//		return productosService.deleteProducto(prodId);
//	}//deleteProducto
	
	//POST
	@PostMapping
	public Producto addProducto(@RequestBody Producto producto) {
		return productosService.addProducto(producto);
	}//addProducto
	
	//PUT
	@PutMapping(path="{proId}")
	public Producto updateProducto(@PathVariable("proId") Long proId, 
		@RequestParam(required=false) String nombre, 
		@RequestParam(required=false) String descripcion,
		@RequestParam(required=false) double precio,
		@RequestParam(required=false) double talla,
		@RequestParam(required=false) int existencia,
		@RequestParam(required=false) int categoria_idcategorias,
		@RequestParam(required=false) String URL_imagen){
		return productosService.updateProducto(proId, nombre, descripcion, precio, talla, existencia, categoria_idcategorias, URL_imagen);
	}//class
	

	
}//class ProductosController
