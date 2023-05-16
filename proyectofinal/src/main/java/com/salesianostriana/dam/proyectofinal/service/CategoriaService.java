package com.salesianostriana.dam.proyectofinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinal.model.Categoria;
import com.salesianostriana.dam.proyectofinal.repository.CategoriaRepository;

@Service
public class CategoriaService
						extends BaseServiceImpl<Categoria, Long, CategoriaRepository>{

	@Autowired
	private CategoriaRepository repositorio;
	
	public List<Categoria> findByNombre(String nombre){
		return repositorio.findByNombreContainingIgnoreCase(nombre);
	}
}
