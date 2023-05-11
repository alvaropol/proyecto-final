package com.salesianostriana.dam.proyectofinal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
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
	private int calificacion;	//Del 1 al 10 
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
