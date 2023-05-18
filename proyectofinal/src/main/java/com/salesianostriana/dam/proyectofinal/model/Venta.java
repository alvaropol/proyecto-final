package com.salesianostriana.dam.proyectofinal.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Venta {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private LocalDate fechaVenta;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
	@OneToMany(
			mappedBy="venta", 
			fetch = FetchType.EAGER,
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	private List<LineaVenta> lineasVenta = new ArrayList<>();
	
	
	public List<LineaVenta> getAsientos() {
		return Collections.unmodifiableList(lineasVenta);
	}

	private double precioTotal;
	
	
	
	// MÉTODOS HELPER
	public void addLineaVenta(LineaVenta l) {
		l.setVenta(this);
		this.lineasVenta.add(l);
	}
	
	public void removeLineaVenta(LineaVenta l) {
		this.lineasVenta.remove(l);
		l.setVenta(null);
		
	}
	
	public void removeLineaVenta(long venta_id) {
		Optional<LineaVenta> l = lineasVenta.stream()
				.filter(lineaventa -> lineaventa.getLineaventaPK().getVenta_id() == this.id && lineaventa.getLineaventaPK().getVenta_id() == venta_id)
				.findFirst();


		if (l.isPresent())
			removeLineaVenta(l.get());

	}

	public long getLineaVentaIdNextval() {
		if (this.lineasVenta.size() > 0) {
			return this.lineasVenta.stream()
					.map(LineaVenta::getLineaventaPK)
					.map(LineaVentaPK::getLineaventa_id)
					.max(Comparator.naturalOrder())
					.orElse(0l) + 1l;
		} else
			return 1l;
	}


}
