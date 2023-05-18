package com.salesianostriana.dam.proyectofinal.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.dam.proyectofinal.model.Producto;
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
    	return "carrito";
    }
	
	 @GetMapping ("/productoACarrito/{id}/")
	    public String productoACarrito (@PathVariable("id") Long id, Model model) {
	    	
		 Optional<Producto> optionalProducto = productoService.findById(id);
		 Producto producto = optionalProducto.get();
		 if(optionalProducto.isPresent()) {
			 servicioVenta.addProducto(producto);
		 }
	    	
	    	    		 	
	    	return "redirect:/carrito/";
	    }
	 
	    @GetMapping("/borrarProducto/{id}")
	    public String removeProductFromCart(@PathVariable("id") Long id) {
	        
	    	Optional<Producto> optionalProducto = productoService.findById(id);
			 Producto producto = optionalProducto.get();
			 if(optionalProducto.isPresent()) {
				 servicioVenta.removeProducto(producto);
			 }
	    	
	        return "redirect:/carrito/";
	    }
	    
	    @ModelAttribute("total_carrito")
	    public Double totalCarrito () {
	    	
	    	Map <Producto,Integer> carrito=servicioVenta.getProductsInCart();
	    	double total=0.0;
	    	if (carrito !=null) {
	        	for (Producto p: carrito.keySet()) {
	        		       		
	        		total+=p.getPrecio()*carrito.get(p);
	        	}
	        	return total;
	    	}
	    	
	    	return 0.0;
	    }
	    
	    
}
