package com.plaxer.springboot.error.app.controllers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.plaxer.springboot.error.app.errors.UsuarioNoEncontradoException;

@ControllerAdvice
public class ErrorHandlerController {

	@ExceptionHandler(ArithmeticException.class)
	public String aritmeticaError(Exception ex, Model modelo) {

		modelo.addAttribute("error", "Error de aritmética");
		modelo.addAttribute("message", ex.getMessage());
		modelo.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		modelo.addAttribute("timestamp", new Date());

		return "error/aritmetica";
	}

	@ExceptionHandler(NumberFormatException.class)
	public String numeroFormatoError(NumberFormatException ex, Model modelo) {

		modelo.addAttribute("error", "Error: Formato número inválido");
		modelo.addAttribute("message", ex.getMessage());
		modelo.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		modelo.addAttribute("timestamp", new Date());

		return "error/numero-formato";
	}
	
	@ExceptionHandler(UsuarioNoEncontradoException.class)
	public String UsuarioNoEncontrado (UsuarioNoEncontradoException ex, Model modelo) {

		modelo.addAttribute("error", "Error: Usuario no encontrado !!!");
		modelo.addAttribute("message", ex.getMessage());
		modelo.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		modelo.addAttribute("timestamp", new Date());

		return "error/usuario-noencontrado";
	}
}
