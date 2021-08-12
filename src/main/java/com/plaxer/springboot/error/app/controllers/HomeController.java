package com.plaxer.springboot.error.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.plaxer.springboot.error.app.errors.UsuarioNoEncontradoException;
import com.plaxer.springboot.error.app.models.domain.Usuario;
import com.plaxer.springboot.error.app.services.UsuarioService;

@Controller
public class HomeController {
	
	@Autowired
	private UsuarioService usuarioService;

	@SuppressWarnings("unused")
	@GetMapping({"index", "", " ", "/", "/home", "/index"})
	public String goHome(Model modelo) {
		// Integer valor = 100/0;
		Integer valor = Integer.parseInt("10x");
		modelo.addAttribute("titulo","Este es el titulo");

		return "index";
	}
	
	@GetMapping("/ver/{id}")
	public String ver(@PathVariable Integer id, Model modelo) {
		
		
		Usuario usuario = usuarioService.obtenerPorIdOptional(id).orElseThrow(() -> new UsuarioNoEncontradoException(id.toString()));

		/*if (usuario == null) {
			throw new UsuarioNoEncontradoException(id.toString()); 
		} */
		modelo.addAttribute("usuario", usuario);
		modelo.addAttribute("titulo", "Detalle usuario: ".concat(usuario.getNombre()));

		return "ver";
	}
}
