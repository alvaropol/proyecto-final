package com.salesianostriana.dam.proyectofinal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinal.model.Categoria;
import com.salesianostriana.dam.proyectofinal.model.Producto;
import com.salesianostriana.dam.proyectofinal.repository.ProductRepository;

@Service
public class ProductoService
				extends BaseServiceImpl<Producto, Long, ProductRepository>{

	@Autowired
	private ProductRepository repositorio;
	
	public List<Producto> findAllByCategoria(Categoria categoria) {
		return repositorio.findByCategoria(categoria);
	}
	
	public List<Producto> findAllByCategoria(Long categoriaId) {
		return repositorio.findByCategoriaId(categoriaId);
	}
	
	public int numeroProductosCategoria(Optional<Categoria> categoria) {
		return repositorio.findNumProductosByCategoria(categoria);
	}
	
	public List<Producto> findByNombre(String nombre){
		return repositorio.findByNombreContainingIgnoreCase(nombre);
	}
}
