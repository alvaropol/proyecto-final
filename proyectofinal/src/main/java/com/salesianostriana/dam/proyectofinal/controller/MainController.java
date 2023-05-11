package com.salesianostriana.dam.proyectofinal.controller;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	


	@GetMapping({"/inicio","/"})
	public String show() {
		return "inicio";
	}
	
	@GetMapping("/noticias")
	public String showNotices() {
		return "noticias";
	}
	
	@GetMapping("/clasificacion")
	public String showCalificacion() {
		return "clasificacion";
	}
	
	@GetMapping("/contacto")
	public String showContacto() {
		return "contacto";
	}

	@GetMapping("/login/")
	public String showLogIn() {
		return "login";
	}

	
}
