package com.salesianostriana.dam.proyectofinal.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class LineaVentaPK implements Serializable {

	private static final long serialVersionUID = 1L;
	 
	private Long lineaventa_id;
	private Long venta_id;

}
