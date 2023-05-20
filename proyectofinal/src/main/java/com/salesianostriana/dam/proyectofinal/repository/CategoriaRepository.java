package com.salesianostriana.dam.proyectofinal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyectofinal.model.Categoria;


public interface CategoriaRepository
			extends JpaRepository<Categoria, Long>{
	
	public List<Categoria> findByNombreContainingIgnoreCase(String nombre);

}
