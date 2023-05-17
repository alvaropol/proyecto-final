package com.salesianostriana.dam.proyectofinal.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.proyectofinal.formbeans.SearchBean;
import com.salesianostriana.dam.proyectofinal.model.Socio;
import com.salesianostriana.dam.proyectofinal.service.SocioService;

@Controller
public class SocioController {

	@Autowired
	private SocioService servicio;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/hazte-socio/")
	public String showFormSocios(Model model) {
		Socio socio = new Socio();
		model.addAttribute("socio",socio);
		return "formularioSocios";
	}

	@GetMapping("/admin/socios/")
	public String showSociosAdmin(Model model) {
		model.addAttribute("listaSocios", servicio.findAll());
		model.addAttribute("searchForm", new SearchBean());
		return "admin/socios-admin";
	}

	@GetMapping("/admin/socios/add/")
	public String showForm(Model model) {
		Socio socio = new Socio();
		model.addAttribute("socio", socio);
		model.addAttribute("listaSocios", servicio.findAll());
		return "admin/formularioSocios-admin";
	}

	@GetMapping("/admin/socios/editar/{id}/")
	public String showEditForm(@PathVariable("id") long id, Model model) {
		model.addAttribute("socio", servicio.findById(id).get());
		model.addAttribute("listaSocios", servicio.findAll());
		return "admin/formularioSocios-admin";
	}

	@GetMapping("/admin/socios/detalles/{id}/")
	public String showSocioDetails(@PathVariable("id") long id, Model model) {
		model.addAttribute("socio", servicio.findById(id).get());
		return "admin/detallesSocio-admin";
	}

	@GetMapping("/admin/socios/borrar/{id}/")
	public String borrarSocio(@PathVariable("id") Long id, Model model) {

		Optional<Socio> sBorrar = servicio.findById(id);

		if (sBorrar.isPresent()) {
			Socio socio = sBorrar.get();
			servicio.delete(socio);
		}

		return "redirect:/admin/socios/";
	}
	
	@PostMapping("/socios/add/submit/")
	public String addSocio(@ModelAttribute("socio") Socio socio, Model model) {
		
		for(Socio s : servicio.findAll()) {
			if(s.getUsername().equals(socio.getUsername())) {
				model.addAttribute("error", "El nombre de usuario no está disponible, introduzca otro distinto");
	            return "formularioSocios";
			}
		}
		
		socio.setPassword(passwordEncoder.encode(socio.getPassword()));
	    servicio.save(socio);
		return "successAddSocio";
	}

	@PostMapping("/admin/socios/add/submit/")
	public String addSocioAdmin(@ModelAttribute("socio") Socio socio, Model model) {
		
		for(Socio s : servicio.findAll()) {
			if(s.getUsername().equals(socio.getUsername())) {
				model.addAttribute("error", "El nombre de usuario no está disponible, introduzca otro distinto");
	            return "admin/formularioSocios-admin";
			}
		}
		
		socio.setPassword(passwordEncoder.encode(socio.getPassword()));
	    servicio.save(socio);
	    return "redirect:/admin/socios/";
	}
	
	
	@GetMapping("/socios/editar/{id}/")
	public String showEditFormUser(@PathVariable("id") long id, Model model) {
		model.addAttribute("socio", servicio.findById(id).get());
		model.addAttribute("listaSocios", servicio.findAll());
		return "editarFormSocio";
	}
	

	@PostMapping("/admin/socios/editar/submit/")
	public String editarSocioAdmin(@ModelAttribute("socio") Socio socio, Model model) {
		servicio.edit(socio);
		return "redirect:/admin/socios/";
	}
	
	@PostMapping("/socios/editar/submit/")
	public String editarSocio(@ModelAttribute("socio") Socio socio, Model model) {
		servicio.edit(socio);
		return "redirect:/inicio/";
	}

	@PostMapping("/admin/socios/search/")
	public String searchSocioAdmin(@ModelAttribute("searchForm") SearchBean searchBean, Model model) {
		model.addAttribute("listaSocios", servicio.findByDni(searchBean.getSearch()));

		return "admin/socios-admin";

	}

}
