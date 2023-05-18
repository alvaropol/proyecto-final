package com.salesianostriana.dam.proyectofinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.proyectofinal.service.VentaService;

@Controller
public class VentaController {

	
	@Autowired
	private VentaService servicio;
	
	@GetMapping ("/carrito/")
    public String showCarrito (Model model) {
    	
    	return "carrito";
    }
}
