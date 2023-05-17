package com.salesianostriana.dam.proyectofinal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
public class LineaVenta {
	
	@Id
	@GeneratedValue
	private long id;
	
	private double pvp;
	
	private int cantidad, descuento; //El descuento solo podrá ir de 0 a 100%
	
	@ManyToOne
	private Producto producto;

	@ManyToOne
	private Venta venta;

}
