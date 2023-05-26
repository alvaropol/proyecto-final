package com.salesianostriana.dam.proyectofinal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinal.model.Socio;
import com.salesianostriana.dam.proyectofinal.repository.SocioRepository;


@Service
public class SocioService
				extends BaseServiceImpl<Socio, Long, SocioRepository>{


	
	public List<Socio> findByDni(String dni){
		return this.repository.findByDniContainingIgnoreCase(dni);
	}
	
	public Long contarSocios() {
		return this.repository.contarSocios();
	}
	
}
