package com.salesianostriana.dam.proyectofinal.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.salesianostriana.dam.proyectofinal.model.Producto;
import com.salesianostriana.dam.proyectofinal.model.Socio;
import com.salesianostriana.dam.proyectofinal.model.Venta;

public interface VentaRepository
				extends JpaRepository<Venta, Long>{
	
	
   @Query("select CASE WHEN sum(v.precioTotal) IS NULL THEN 0 ELSE SUM(v.precioTotal) END from Venta v WHERE v.socio = ?1")
   public Double getTotalGastadoPorIdSocio(Socio socio);
   
   @Query("select CASE WHEN COUNT(v) IS NULL THEN 0 ELSE COUNT(v) END from Venta v WHERE v.socio = ?1")
   public int contarVentasPorSocio(Socio socio);
   
   @Query("SELECT CASE WHEN sum(v.precioTotal) IS NULL THEN 0 ELSE SUM(v.precioTotal) END FROM Venta v WHERE YEAR(v.fechaVenta) = YEAR(CURRENT_DATE())")
	public Double calcularGanadoAlAnyo();
  
   @Query("SELECT CASE WHEN sum(v.precioTotal) IS NULL THEN 0 ELSE sum(v.precioTotal) END FROM Venta v WHERE MONTH(v.fechaVenta) = MONTH(NOW()) AND YEAR(v.fechaVenta) = YEAR(NOW())")
	public Double calcularGanadoAlMes();
   
   @Query("SELECT CASE WHEN COUNT(lv.producto.id) IS NULL THEN 0 ELSE COUNT(lv.producto.id) END FROM Venta v JOIN v.lineasVenta lv WHERE lv.producto = :producto")
  	public int contarProductosEnLineasVentas(@Param("producto") Producto producto);
   
   @Query("SELECT CASE WHEN COUNT(v.socio.id) IS NULL THEN 0 ELSE COUNT(v.socio.id) END FROM Venta v WHERE v.socio = :socio")
 	public int contarSociosEnVentas(@Param("socio") Socio socio);
     
   @Query("SELECT COUNT(v) FROM Venta v")
   public Long contarCantidadTotalVentas();
   
  


}
