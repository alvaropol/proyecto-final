package com.salesianostriana.dam.proyectofinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinal.model.Socio;
import com.salesianostriana.dam.proyectofinal.repository.SocioRepository;




@Service
public class SocioService
				extends BaseServiceImpl<Socio, Long, SocioRepository>{

	@Autowired
	private SocioRepository repositorio;
	
	public List<Socio> findByDni(String dni){
		return repositorio.findByDniContainingIgnoreCase(dni);
	}
	
	public Long contarSocios() {
		return repositorio.contarSocios();
	}
	
}
