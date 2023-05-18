package com.salesianostriana.dam.proyectofinal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
public class Producto {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nombre;
	private double precio;
	@Lob
	private String descripcion;
	private int calificacion;		
	@Lob
	private String imagen;
	
	@ManyToOne
	private Categoria categoria;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy="producto")
	private List<LineaVenta> lineasVenta = new ArrayList<>();
	  
	public Producto(String nombre, double precio, String descripcion, int calificacion, String imagen, Categoria categoria) {
		this.nombre = nombre;
		this.precio=precio;
		this.descripcion = descripcion;
		this.calificacion = calificacion;
		this.imagen = imagen;
		this.categoria = categoria;
	}
	
	
	

}
