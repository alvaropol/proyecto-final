package com.salesianostriana.dam.proyectofinal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity @Data @NoArgsConstructor
public class Categoria {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nombre;
	@Lob
	private String imagen;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy="categoria")
	private List<Producto> productos = new ArrayList<>();
	

	public Categoria(String nombre,String imagen) {
		this.nombre = nombre;
		this.imagen = imagen;
	}
	
	public void addProducto(Producto p) {
		this.productos.add(p);
		p.setCategoria(this);
	}
	
	public void removeProducto(Producto p) {
		this.productos.remove(p);
		p.setCategoria(null);	}
}
