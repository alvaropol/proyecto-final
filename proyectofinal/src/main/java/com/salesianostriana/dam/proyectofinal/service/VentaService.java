package com.salesianostriana.dam.proyectofinal.service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import com.salesianostriana.dam.proyectofinal.model.LineaVenta;
import com.salesianostriana.dam.proyectofinal.model.Producto;
import com.salesianostriana.dam.proyectofinal.model.Socio;
import com.salesianostriana.dam.proyectofinal.model.Venta;
import com.salesianostriana.dam.proyectofinal.repository.ProductRepository;
import com.salesianostriana.dam.proyectofinal.repository.VentaRepository;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class VentaService extends BaseServiceImpl<Venta, Long, VentaRepository> {

	@Autowired
	VentaRepository repositorioVenta;

	@Autowired
	ProductRepository repositorioProducto;


	private Map<Producto, Integer> productos = new HashMap<>();

	public void addProducto(Producto p) {
		if (productos.containsKey(p)) {
			productos.replace(p, productos.get(p) + 1);
		} else {
			productos.put(p, 1);
		}
	}

	public void removeProducto(Producto p) {
		if (productos.containsKey(p)) {
			if (productos.get(p) > 1)
				productos.replace(p, productos.get(p) - 1);
			else if (productos.get(p) == 1) {
				productos.remove(p);
			}
		}
	}

	public Double totalCarrito() {

		Map<Producto, Integer> carrito = getProductsInCart();
		double total = 0.0;
		if (carrito != null) {
			for (Producto p : carrito.keySet()) {

				total += p.getPrecio() * carrito.get(p);
			}
			return total;
		}

		return 0.0;
	}

	public Map<Producto, Integer> getProductsInCart() {
		return Collections.unmodifiableMap(productos);
	}

	/**
	 * Este método atiende al checkout del carrito, donde al darle al botón comprar en la página web, trabajará con la venta y el socio
	 * 
	 * @param s Socio que está asociado a la compra (model Venta)
	 */
	public void checkoutCompra(Socio s) {
		Venta v = new Venta();
		for (Producto p : productos.keySet()) {
			v.addLineaVenta(
					LineaVenta.builder()
					.producto(p)
					.cantidad(productos.get(p))
					// En mi caso, el pvp de los productos, será el valor de dicho producto más un
					// 10% del valor total.
					.pvp(p.getPrecio() + (1 * 0.10))
					.subtotal(p.getPrecio() * productos.get(p))
					.build());
		}
		v.setSocio(s);
		v.setPrecioTotal(totalCarrito());
		v.setFechaVenta(LocalDate.now());
		save(v);
		
		//Vaciamos la lista del carrito para que pueda seguir haciendo más compras.
		productos.clear();
	}

}
