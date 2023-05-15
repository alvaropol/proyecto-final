package com.salesianostriana.dam.proyectofinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.proyectofinal.model.Socio;
import com.salesianostriana.dam.proyectofinal.service.SocioService;

@Controller
public class SocioController {
	
	@Autowired
	
	private SocioService servicio;

	
	
	@GetMapping("/hazte-socio/")
	public String showSocios(Model model){

		return "formularioSocios";
	}
	
	@GetMapping("/admin/socios/")
	public String showSociosAdmin(Model model){
		model.addAttribute("listaSocios",servicio.findAll());
		return "admin/socios-admin";
	}
	
	@GetMapping("/admin/socios/add/")
	public String showForm(Model model) {
		Socio socio= new Socio();
		model.addAttribute("socio", socio);
		model.addAttribute("listaSocios", servicio.findAll());
		return "admin/formularioSocios-admin";
	}
	
	@PostMapping("/admin/socios/add/submit/")
	public String addProduct(@ModelAttribute("socio") Socio socio, Model model) {
	
		servicio.save(socio);
		return "redirect:/admin/socios/";
	}
		

}
