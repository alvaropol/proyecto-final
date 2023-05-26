package com.salesianostriana.dam.proyectofinal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinal.model.Categoria;
import com.salesianostriana.dam.proyectofinal.repository.CategoriaRepository;

@Service
public class CategoriaService
						extends BaseServiceImpl<Categoria, Long, CategoriaRepository>{


	
	public List<Categoria> findByNombre(String nombre){
		return this.repository.findByNombreContainingIgnoreCase(nombre);
	}
}
