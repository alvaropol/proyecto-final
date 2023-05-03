package com.salesianostriana.dam.proyectofinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.proyectofinal.model.Producto;



@Controller
public class ProductController {
	
	//@Autowired
	//private ProductService servicio;

	@GetMapping("/producto")
	public String showForm(Model model) {
	    Producto producto = new Producto();

	    model.addAttribute("productoForm", producto);
	    
	    return "tienda";
	}

	
	@PostMapping ("/addProducto")
	public String submit(@ModelAttribute("productoForm") Producto producto,  Model model) {

		model.addAttribute("producto", producto);
		
		return "tienda";
	}
	
}
