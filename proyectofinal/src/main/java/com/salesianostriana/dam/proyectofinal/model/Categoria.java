package com.salesianostriana.dam.proyectofinal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Categoria {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nombre;
	@Lob
	private String imagen;


	public Categoria(String nombre,String imagen) {
		this.nombre = nombre;
		this.imagen = imagen;
	}
}
