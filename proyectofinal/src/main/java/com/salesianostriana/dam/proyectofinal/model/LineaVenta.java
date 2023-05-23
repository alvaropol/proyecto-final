package com.salesianostriana.dam.proyectofinal.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

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
	
	@EmbeddedId
	@Builder.Default
	private LineaVentaPK lineaventaPK = new LineaVentaPK();
	
	private double pvp;
	private int cantidad;
	private double subtotal;
	
	
	@ManyToOne
	private Producto producto;

	@ManyToOne
	@MapsId("venta_id")
	@JoinColumn(name="venta_id")
	private Venta venta;

}
