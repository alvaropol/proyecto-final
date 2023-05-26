package com.salesianostriana.dam.proyectofinal.service;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinal.model.Categoria;
import com.salesianostriana.dam.proyectofinal.model.Producto;
import com.salesianostriana.dam.proyectofinal.repository.ProductRepository;

@Service
public class ProductoService
				extends BaseServiceImpl<Producto, Long, ProductRepository>{

	public List<Producto> findAllByCategoria(Categoria categoria) {
		return this.repository.findByCategoria(categoria);
	}
	
	public List<Producto> findAllByCategoria(Long categoriaId) {
		return this.repository.findByCategoriaId(categoriaId);
	}
	
	public int numeroProductosCategoria(Optional<Categoria> categoria) {
		return this.repository.findNumProductosByCategoria(categoria);
	}
	
	public List<Producto> findByNombre(String nombre){
		return this.repository.findByNombreContainingIgnoreCase(nombre);
	}
}
