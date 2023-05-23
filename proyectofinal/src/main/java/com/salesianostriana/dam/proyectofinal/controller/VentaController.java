package com.salesianostriana.dam.proyectofinal.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.dam.proyectofinal.model.Producto;
import com.salesianostriana.dam.proyectofinal.model.Socio;
import com.salesianostriana.dam.proyectofinal.repository.SocioRepository;
import com.salesianostriana.dam.proyectofinal.repository.VentaRepository;
import com.salesianostriana.dam.proyectofinal.service.ProductoService;
import com.salesianostriana.dam.proyectofinal.service.VentaService;

@Controller
public class VentaController {

	
	@Autowired
	private VentaService servicioVenta;
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private SocioRepository socioRepositorio;
	
	@Autowired
	private VentaRepository ventaRepositorio;

	
	@GetMapping ("/carrito/")
    public String showCarrito (@AuthenticationPrincipal Socio socio, Model model) {
		Map<Producto,Integer> productos = servicioVenta.getProductsInCart();
		
		 if (productos == null || productos.isEmpty()) {
			//Si el carrito no tiene productos te redirige a la tienda (de admin o de usuario) hasta que se añade algún producto.
		        if(socio.isAdmin()){
		        	return "redirect:/admin/productos/";
		        }else {
		        	return "redirect:/productos/";
		        }
		    }
		 
		 double totalGastado = ventaRepositorio.getTotalGastadoPorIdSocio(socio);
		 
		 if (totalGastado >= 80 && totalGastado < 150) { 
			 
			 	double precio;
			 	double descuento = 10;
				precio =  servicioVenta.totalCarrito(socio) - (servicioVenta.totalCarrito(socio) * (descuento / 100));
				model.addAttribute("totalDesc", precio);
			} else if (totalGastado >= 150 && totalGastado < 250) {
			
				double precio;
			 	double descuento = 15;
				precio =  servicioVenta.totalCarrito(socio) - (servicioVenta.totalCarrito(socio) * (descuento / 100));
				model.addAttribute("totalDesc", precio);
				
			} else if (totalGastado >= 250) {
				
				double precio;
			 	double descuento = 25;
				precio =  servicioVenta.totalCarrito(socio) - (servicioVenta.totalCarrito(socio) * (descuento / 100));
				model.addAttribute("totalDesc", precio);
			}else {
				model.addAttribute("totalDesc", servicioVenta.totalCarrito(socio));
			}
    	
		model.addAttribute("productos", servicioVenta.getProductsInCart());
		model.addAttribute("total", servicioVenta.totalCarrito(socio));
		
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
	    	
	    	s.setCantidadCompras(s.getCantidadCompras()+1);
	    		
	    	if(s.getCantidadCompras()>5) {
	    		s.setSocioRojo(true);
	    	}
	    	
	    	socioRepositorio.save(s);
	    	servicioVenta.checkoutCompra(s);
	    	
	    	return "successCheckoutCompra";
	    }

	   
	    
	    
}
