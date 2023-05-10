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

import com.salesianostriana.dam.proyectofinal.model.Categoria;
import com.salesianostriana.dam.proyectofinal.service.CategoriaService;
import com.salesianostriana.dam.proyectofinal.service.ProductoService;

@Controller
@RequestMapping("/categorias/admin")
public class CategoriaController {
	
	@Autowired
	private CategoriaService servicio;
	
	@Autowired
	private ProductoService productoService;

	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("listaCategorias", servicio.findAll());
		return "admin/categorias-admin";
	}
	
	@GetMapping("/add/")
	public String nuevaCategoria(Model model) {
		model.addAttribute("categoria", new Categoria());
		return "admin/formularioCategorias";
	}
	
	@PostMapping("/add/submit/")
	public String submitNuevaCategoria(@ModelAttribute("categoria") Categoria categoria, Model model) {
		servicio.save(categoria);
		return "redirect:/categorias/admin/";
	}
	
	@GetMapping("/editar/{id}/")
	public String editarCategoria(@PathVariable("id") Long id, Model model) {
		
		model.addAttribute("categoria", servicio.findById(id).get());
		model.addAttribute("listaCategorias", servicio.findAll());

		return "admin/formularioCategorias";
	}
	
	@PostMapping("/editar/submit/")
	public String submitEditarCategoria(@ModelAttribute("categoria") Categoria categoria,  Model model) {
		servicio.edit(categoria);
		return "redirect:/categorias/admin/";
	}
	
	@GetMapping("/borrar/{id}/")
	public String borrarProducto(@PathVariable("id") Long id, Model model) {
	    
		Optional<Categoria> categoria = servicio.findById(id);

		if (productoService.numeroProductosCategoria(categoria) == 0) {
			if (categoria.isPresent()) {
		        Categoria categoriaB = categoria.get();
		        servicio.delete(categoriaB);
		    }		
		} else {
				
			return "redirect:/categorias/admin/?error=true";
		}

	    return "redirect:/categorias/admin/";
	}
	
}
