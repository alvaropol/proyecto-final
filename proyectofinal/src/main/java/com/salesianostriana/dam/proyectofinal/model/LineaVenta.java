package com.salesianostriana.dam.proyectofinal.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LineaVenta {
	
	@Id
	@GeneratedValue
	private long id;
	
	private double pvp;
	
	private int cantidad, descuento; //El descuento solo podrá ir de 0 a 100%
	
	//Falta implementar el producto
}
