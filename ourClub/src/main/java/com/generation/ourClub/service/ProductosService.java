package com.generation.ourClub.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.ourClub.model.Producto;


@Service //decir que es un servicio
public class ProductosService {

	public final ProductosRepository productosRepository;
	
	@Autowired
	//CONSTRUCTOR
	public ProductosService(ProductosRepository productosRepository) {
		this.productosRepository = productosRepository;
	}//constructor
	public List<Producto> getProductos() {
		return productosRepository.findAll();


	}//getProductos
	public Producto getProducto(Long id) {
		return productosRepository.findById(id).orElseThrow(
				()-> new IllegalStateException("El producto no existe  con el id "+ id + " no existe.")
				
				);
	}

	//POST PRODUCTO
		public Producto addProducto(Producto producto) {
			Producto tmpProducto = null;
			Optional<Producto> prodByName=productosRepository.findByNombre(producto.getNombre());
			if(prodByName.isPresent()) {
				throw new IllegalStateException("El Producto con el nombre [" + producto.getNombre() + 
						"] YA existe."); 	
			} else {
				productosRepository.save(producto);
				tmpProducto = producto;
			}//else 
			return tmpProducto;	//addProducto
		}

	//PUT PRODUCTO
			public Producto updateProducto(Long id,String nombre, String descripcion,Double precio,Double talla, int existencia, int categoria_idcategorias, String uRL_imagen ) {
				Producto tmpProducto=null;
				if(productosRepository.existsById(id)){
					tmpProducto=productosRepository.findById(id).get();
				if(nombre!=null)tmpProducto.setNombre(nombre);
				if(descripcion!=null)tmpProducto.setDescripcion(descripcion);
				if(uRL_imagen!=null)tmpProducto.setURL_imagen(uRL_imagen);
				if(precio!=null && precio.doubleValue()>0)tmpProducto.setPrecio(precio.doubleValue());
				productosRepository.save(tmpProducto);
				}else {
					System.out.println("No existe el producto con el id" + id);
				}
				return tmpProducto;
				
			}
		 
	

	
}//class productosService
