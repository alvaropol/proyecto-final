package com.salesianostriana.dam.proyectofinal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nombre;
	private double precio;
	private String descripcion;
	private int calificacion;		
	@Lob
	private String imagen;
	
	@ManyToOne
	private Categoria categoria;
	  
	public Producto(String nombre, double precio, String descripcion, int calificacion, String imagen, Categoria categoria) {
		this.nombre = nombre;
		this.precio=precio;
		this.descripcion = descripcion;
		this.calificacion = calificacion;
		this.imagen = imagen;
		this.categoria = categoria;
	}
	
	
	

}
