package com.salesianostriana.dam.proyectofinal.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import com.salesianostriana.dam.proyectofinal.model.Producto;
import com.salesianostriana.dam.proyectofinal.model.Venta;
import com.salesianostriana.dam.proyectofinal.repository.ProductRepository;
import com.salesianostriana.dam.proyectofinal.repository.VentaRepository;

@Service
@Scope (value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class VentaService
	extends BaseServiceImpl<Venta, Long, VentaRepository>{

	@Autowired
	private VentaRepository repositorioVenta;
	
	@Autowired
	private ProductRepository repositorioProducto;
	
	private Map<Producto, Integer> productos = new HashMap <> ();
	
	
	public void addProducto (Producto p) {
		if (productos.containsKey(p)) {
			productos.replace(p, productos.get(p)+1);
		}else {
			productos.put(p, 1);
		}
	}
	
	public void removeProducto (Producto p) {
        if (productos.containsKey(p)) {
            if (productos.get(p) > 1)
                productos.replace(p, productos.get(p) - 1);
            else if (productos.get(p) == 1) {
                productos.remove(p);
            }
        }
	}
	
	 public Map<Producto, Integer> getProductsInCart() {
	        return Collections.unmodifiableMap(productos);
	    }
	
}
