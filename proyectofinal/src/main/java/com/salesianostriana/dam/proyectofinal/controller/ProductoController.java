package com.salesianostriana.dam.proyectofinal.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.proyectofinal.formbeans.SearchBean;
import com.salesianostriana.dam.proyectofinal.model.Producto;
import com.salesianostriana.dam.proyectofinal.service.CategoriaService;
import com.salesianostriana.dam.proyectofinal.service.ProductoService;


@Controller
public class ProductoController {

	@Autowired
	private ProductoService servicioProducto;

	@Autowired
	private CategoriaService servicioCategoria;
	

	@GetMapping("/productos/")
	public String showTienda(Model model) {
		model.addAttribute("listaProductos", servicioProducto.findAll());
		model.addAttribute("searchForm", new SearchBean());
		return "tienda";
	}

	@GetMapping("/admin/productos/")
	public String showTiendaAdmin(Model model) {
		model.addAttribute("listaProductos", servicioProducto.findAll());
		model.addAttribute("searchForm", new SearchBean());

		return "admin/tienda-admin";
	}

	@GetMapping("/admin/productos/add/")
	public String showForm(Model model) {
		Producto producto = new Producto();
		model.addAttribute("producto", producto);
		model.addAttribute("listaCategorias", servicioCategoria.findAll());
		return "admin/formularioProducto";
	}

	@GetMapping("/admin/productos/editar/{id}/")
	public String showEditForm(@PathVariable("id") long id, Model model) {
		model.addAttribute("producto", servicioProducto.findById(id).get());
		model.addAttribute("listaProductos", servicioProducto.findAll());
		model.addAttribute("listaCategorias", servicioCategoria.findAll());
		return "admin/formularioProducto";
	}

	@GetMapping("productos/detalles/{id}/")
	public String showProductDetails(@PathVariable("id") long id, Model model) {
		model.addAttribute("producto", servicioProducto.findById(id).get());
		return "detallesProducto";
	}

	@PostMapping("/admin/productos/add/submit/")
	public String addProduct(@ModelAttribute("producto") Producto producto, Model model) {
		servicioProducto.save(producto);
		return "redirect:/admin/productos/";
	}

	@PostMapping("/admin/productos/editar/submit/")
	public String editarProducto(@ModelAttribute("producto") Producto producto, Model model) {
		servicioProducto.edit(producto);
		return "redirect:/admin/productos/";
	}

	@GetMapping("/admin/productos/borrar/{id}/")
	public String borrarProducto(@PathVariable("id") Long id, Model model) {

		Optional<Producto> pBorrar = servicioProducto.findById(id);

		if (pBorrar.isPresent()) {
			Producto producto = pBorrar.get();
			servicioProducto.delete(producto);
		}

		return "redirect:/admin/productos/";
	}

	@PostMapping("/admin/productos/search/")
	public String searchProductoAdmin(@ModelAttribute("searchForm") SearchBean searchBean, Model model) {
		model.addAttribute("listaProductos", servicioProducto.findByNombre(searchBean.getSearch()));
		
			return "admin/tienda-admin";
		
	}
	
	@PostMapping("/productos/search/")
	public String searchProducto(@ModelAttribute("searchForm") SearchBean searchBean, Model model) {
		model.addAttribute("listaProductos", servicioProducto.findByNombre(searchBean.getSearch()));
		
			return "tienda";
		
	}
}
