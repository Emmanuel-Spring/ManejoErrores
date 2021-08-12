package com.plaxer.springboot.error.app.errors;

public class UsuarioNoEncontradoException extends RuntimeException {

	public UsuarioNoEncontradoException(String id) {
		super("Usuario con ID: ".concat(id).concat(" no existe e el sistema"));
		
	}

	private static final long serialVersionUID = 1L;

}
