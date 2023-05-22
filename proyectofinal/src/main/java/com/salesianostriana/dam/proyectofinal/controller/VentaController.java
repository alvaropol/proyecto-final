package com.salesianostriana.dam.proyectofinal.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import com.salesianostriana.dam.proyectofinal.model.Producto;
import com.salesianostriana.dam.proyectofinal.model.Socio;
import com.salesianostriana.dam.proyectofinal.service.ProductoService;
import com.salesianostriana.dam.proyectofinal.service.VentaService;

@Controller
public class VentaController {

	
	@Autowired
	private VentaService servicioVenta;
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping ("/carrito/")
    public String showCarrito (Model model) {
		if (model.addAttribute("productos",servicioVenta.getProductsInCart()) == null)
    		return "redirect:/";
		model.addAttribute("total", servicioVenta.totalCarrito());
    	return "carrito";
    }
	
	 @GetMapping ("/productoACarrito/{id}/")
	    public String productoACarrito (@PathVariable("id") Long id, Model model, @AuthenticationPrincipal Socio s) {
	    	
		 Optional<Producto> optionalProducto = productoService.findById(id);
		 Producto producto = optionalProducto.get();
		 if(optionalProducto.isPresent()) {
			 servicioVenta.addProducto(producto);
		 }
	    	    	    		 	
		 if(s.isAdmin()) {
	    		return "redirect:/admin/productos/";
	    	}else {
	    		return "redirect:/productos/";
	    	}
	    }
	 
	    @GetMapping("/borrarProducto/{id}/")
	    public String removeProductFromCart(@PathVariable("id") Long id) {
	        
	    	Optional<Producto> optionalProducto = productoService.findById(id);
			 Producto producto = optionalProducto.get();
			 if(optionalProducto.isPresent()) {
				 servicioVenta.removeProducto(producto);
			 }
	    	
	        return "redirect:/carrito/";
	    }
	    
	    @GetMapping("/carrito/checkout/")
	    public String checkoutCarrito(@AuthenticationPrincipal Socio s) {
	    	servicioVenta.checkoutCompra(s);
	    	
	    	if(s.isAdmin()) {
	    		return "redirect:/admin/productos/";
	    	}else {
	    		return "redirect:/productos/";
	    	}
	    }

	   
	    
	    
}
