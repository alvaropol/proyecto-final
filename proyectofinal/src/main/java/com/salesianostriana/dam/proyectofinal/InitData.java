package com.salesianostriana.dam.proyectofinal;

import java.time.LocalDate;
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
		
		Socio admin = Socio.builder()
				.admin(true)
				.username("admin")
				.password(passwordEncoder.encode("admin"))
				.nombre("Alfonso")
				.apellidos("Góngora Ruíz")
				.direccion("Calle Torneo Nº10")
				.dni("43929384J")
				.telefono("773902831")
				.email("alfonsogongora@gmail.com")
				.fechaNacimiento(LocalDate.of(1973, 3, 20))
				.imagen("https://img.freepik.com/foto-gratis/retrato-joven-sonriente-gafas_171337-4842.jpg")
				.socioRojo(false)
				.build();
		
		Socio socio = Socio.builder()
				.admin(false)
				.username("user")
				.password(passwordEncoder.encode("1234"))
				.nombre("Antonio")
				.apellidos("García López")
				.direccion("Calle Bermejales Nº9")
				.dni("32928372O")
				.telefono("432422423")				.email("antoniogarcia@gmail.com")
				.fechaNacimiento(LocalDate.of(1985, 2, 18))
				.imagen("https://img.freepik.com/foto-gratis/chico-guapo-seguro-posando-contra-pared-blanca_176420-32936.jpg?w=360")
				.socioRojo(false)
				.telefono("893983493")
				.build();
		
		
		repo.saveAll(List.of(socio, admin));
		
	}

}