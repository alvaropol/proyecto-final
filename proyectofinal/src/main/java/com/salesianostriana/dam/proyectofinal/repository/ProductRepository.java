package com.salesianostriana.dam.proyectofinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyectofinal.model.Producto;

public interface ProductRepository
					extends JpaRepository<Producto, Long>{

}
