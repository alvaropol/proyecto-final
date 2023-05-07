package com.salesianostriana.dam.proyectofinal.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyectofinal.model.Producto;
import com.salesianostriana.dam.proyectofinal.service.ProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private ProductoService servicio;

	@GetMapping("/")
	public String showForm(Model model) {
		model.addAttribute("listaProductos", servicio.findAll());
		model.addAttribute("productoForm", new Producto());


		return "tienda";
	}
	
	@GetMapping("/editar/{id}")
	public String showEditForm(@PathVariable("id") long id, Model model) {
		model.addAttribute("producto", servicio.findById(id));
		model.addAttribute("listaProductos", servicio.findAll());
	
		
		return "tienda";
	}

	
	@PostMapping("/editar")
	public String editarProducto(@ModelAttribute("productoNew") Producto productoNew,  Model model) {
		servicio.save(productoNew);
		return "redirect:/productos/";
	}
}
