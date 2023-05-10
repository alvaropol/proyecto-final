package com.salesianostriana.dam.proyectofinal.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyectofinal.model.Producto;
import com.salesianostriana.dam.proyectofinal.service.CategoriaService;
import com.salesianostriana.dam.proyectofinal.service.ProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private ProductoService servicioProducto;
	
	@Autowired
	private CategoriaService servicioCategoria;

	@GetMapping("/")
	public String showTienda(Model model){
		model.addAttribute("listaProductos",servicioProducto.findAll());
		return "tienda";
	}
	
	@GetMapping("/admin/")
	public String showTiendaAdmin(Model model){
		model.addAttribute("listaProductos",servicioProducto.findAll());
		return "admin/tienda-admin";
	}
	
	@GetMapping("/admin/add/")
	public String showForm(Model model) {
		Producto producto= new Producto();
		model.addAttribute("producto", producto);
		model.addAttribute("listaCategorias", servicioCategoria.findAll());
		return "admin/formularioProducto";
	}
	
	@GetMapping("/admin/editar/{id}/")
	public String showEditForm(@PathVariable("id") long id, Model model) {
		model.addAttribute("producto", servicioProducto.findById(id).get());
		model.addAttribute("listaProductos", servicioProducto.findAll());
		model.addAttribute("listaCategorias", servicioCategoria.findAll());
		return "admin/formularioProducto";
	}
	
	@GetMapping("/detalles/{id}/")
	public String showProductDetails(@PathVariable("id") long id, Model model) {
		model.addAttribute("producto", servicioProducto.findById(id).get());
		return "detallesProducto";
	}
	
	@PostMapping("/admin/add/submit/")
	public String addProduct(@ModelAttribute("producto") Producto producto, Model model) {
		servicioProducto.save(producto);
		return "redirect:/productos/admin/";
	}
	
	@PostMapping("/admin/editar/submit/")
	public String editarProducto(@ModelAttribute("producto") Producto producto,  Model model) {
		servicioProducto.edit(producto);
		return "redirect:/productos/admin/";
	}
	
	@GetMapping("/admin/borrar/{id}/")
	public String borrarProducto(@PathVariable("id") Long id, Model model) {
	    
		Optional<Producto> pBorrar = servicioProducto.findById(id);

	    if (pBorrar.isPresent()) {
	        Producto producto = pBorrar.get();
	        servicioProducto.delete(producto);
	    }

	    return "redirect:/productos/admin/";
	}
}
