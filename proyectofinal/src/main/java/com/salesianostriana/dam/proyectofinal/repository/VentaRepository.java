package com.salesianostriana.dam.proyectofinal.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.proyectofinal.model.Socio;
import com.salesianostriana.dam.proyectofinal.model.Venta;

public interface VentaRepository
				extends JpaRepository<Venta, Long>{
	
	
   @Query("select CASE WHEN SUM(v.precioTotal) IS NULL THEN 0 ELSE SUM(v.precioTotal) END from Venta v WHERE v.socio = ?1")
   public Double getTotalGastadoPorIdSocio(Socio socio);

}
