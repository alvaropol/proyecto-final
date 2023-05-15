package com.salesianostriana.dam.proyectofinal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyectofinal.model.Socio;

public interface SocioRepository 
					extends JpaRepository<Socio, Long>{

	Optional<Socio> findFirstByUsername(String username);
}
