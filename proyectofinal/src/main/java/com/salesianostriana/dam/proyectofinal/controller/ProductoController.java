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
	public String showTienda(Model model){
		model.addAttribute("listaProductos",servicio.findAll());
		return "tienda";
	}
	
	@GetMapping("/admin/")
	public String showTiendaAdmin(Model model){
		model.addAttribute("listaProductos",servicio.findAll());
		return "admin/tienda-admin";
	}
	
	@GetMapping("/admin/add/")
	public String showForm(Model model) {
		Producto producto= new Producto();
		model.addAttribute("producto", producto);
		return "formularioProducto";
	}
	
	@GetMapping("/admin/editar/{id}/")
	public String showEditForm(@PathVariable("id") long id, Model model) {
		model.addAttribute("producto", servicio.findById(id).get());
		model.addAttribute("listaProductos", servicio.findAll());
		return "formularioProducto";
	}
	
	@PostMapping("/admin/add/submit/")
	public String addProduct(@ModelAttribute("producto") Producto producto, Model model) {
		servicio.save(producto);
		return "redirect:/productos/admin/";
	}
	
	@PostMapping("/admin/editar/submit/")
	public String editarProducto(@ModelAttribute("producto") Producto producto,  Model model) {
		servicio.edit(producto);
		return "redirect:/productos/admin/";
	}
}
