package com.salesianostriana.dam.proyectofinal.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import com.salesianostriana.dam.proyectofinal.model.LineaVenta;
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
	
	
	
}
