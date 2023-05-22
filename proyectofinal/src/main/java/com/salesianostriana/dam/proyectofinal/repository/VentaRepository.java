package com.salesianostriana.dam.proyectofinal.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.proyectofinal.model.Venta;

public interface VentaRepository
				extends JpaRepository<Venta, Long>{
	
	
   @Query("select COALESCE(SUM(v.precioTotal), 0) from Venta v WHERE v.socio.id = ?1")
   public double getTotalGastadoPorIdSocio(Long idSocio);

}
