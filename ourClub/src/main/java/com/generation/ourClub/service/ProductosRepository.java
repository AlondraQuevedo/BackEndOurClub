package com.generation.ourClub.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.generation.ourClub.model.Producto;


public interface ProductosRepository extends JpaRepository<Producto, Long>{
	@Query("SELECT p FROM Producto p WHERE p.nombre=?1")
	Optional<Producto>findByNombre (String nombre);
}
