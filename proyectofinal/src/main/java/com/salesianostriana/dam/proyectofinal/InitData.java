package com.salesianostriana.dam.proyectofinal;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.salesianostriana.dam.proyectofinal.model.Socio;
import com.salesianostriana.dam.proyectofinal.repository.SocioRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InitData {
	
	private final SocioRepository repo;
	private final PasswordEncoder passwordEncoder;

	
	@PostConstruct
	public void init() {
		
		Socio socio = Socio.builder()
				.admin(false)
				.username("user")
				.password(passwordEncoder.encode("1234"))
				.build();
		
		Socio admin = Socio.builder()
				.admin(true)
				.username("admin")
				.password(passwordEncoder.encode("admin"))
				.build();
		
		repo.saveAll(List.of(socio, admin));
		
	}

}