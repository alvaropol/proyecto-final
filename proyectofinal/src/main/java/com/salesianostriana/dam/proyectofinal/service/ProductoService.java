package com.salesianostriana.dam.proyectofinal.service;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinal.model.Producto;
import com.salesianostriana.dam.proyectofinal.repository.ProductRepository;

@Service
public class ProductoService
				extends BaseServiceImpl<Producto, Long, ProductRepository>{

	private ProductRepository productRepository;

	public ProductoService(ProductRepository repo) {
		this.productRepository = repo;
	}
	
	public Producto findById(long id) {
		return productRepository.findById(id).orElse(null);
	}
}
