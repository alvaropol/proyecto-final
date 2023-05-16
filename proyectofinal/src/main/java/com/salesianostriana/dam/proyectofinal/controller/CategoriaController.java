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

import com.salesianostriana.dam.proyectofinal.formbeans.SearchBean;
import com.salesianostriana.dam.proyectofinal.model.Categoria;
import com.salesianostriana.dam.proyectofinal.service.CategoriaService;
import com.salesianostriana.dam.proyectofinal.service.ProductoService;

@Controller
@RequestMapping("/admin/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService servicio;
	
	@Autowired
	private ProductoService productoService;

	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("listaCategorias", servicio.findAll());
		model.addAttribute("searchForm", new SearchBean());
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
		return "redirect:/admin/categorias/";
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
		return "redirect:/admin/categorias/";
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
				
			return "redirect:/admin/categorias/?error=true";
		}

	    return "redirect:/admin/categorias/";
	}
	
	@PostMapping("/search/")
	public String searchCategoriasAdmin(@ModelAttribute("searchForm") SearchBean searchBean, Model model) {
		model.addAttribute("listaCategorias", servicio.findByNombre(searchBean.getSearch()));
		
			return "admin/categorias-admin";
		
	}
	
}
