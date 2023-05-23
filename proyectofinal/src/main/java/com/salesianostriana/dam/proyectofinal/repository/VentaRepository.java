package com.salesianostriana.dam.proyectofinal.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.proyectofinal.model.Socio;
import com.salesianostriana.dam.proyectofinal.model.Venta;

public interface VentaRepository
				extends JpaRepository<Venta, Long>{
	
	
   @Query("select CASE WHEN sum(v.precioTotal) IS NULL THEN 0 ELSE SUM(v.precioTotal) END from Venta v WHERE v.socio = ?1")
   public Double getTotalGastadoPorIdSocio(Socio socio);
   
   @Query("SELECT CASE WHEN sum(v.precioTotal) IS NULL THEN 0 ELSE SUM(v.precioTotal) END FROM Venta v WHERE YEAR(v.fechaVenta) = YEAR(CURRENT_DATE())")
	public Double calcularGanadoAlAnyo();
  
   @Query("SELECT CASE WHEN sum(v.precioTotal) IS NULL THEN 0 ELSE sum(v.precioTotal) END FROM Venta v WHERE MONTH(v.fechaVenta) = MONTH(NOW()) AND YEAR(v.fechaVenta) = YEAR(NOW())")
	public Double calcularGanadoAlMes();
   
   @Query("SELECT COUNT(v) FROM Venta v")
   public Long contarCantidadTotalVentas();
   


}
