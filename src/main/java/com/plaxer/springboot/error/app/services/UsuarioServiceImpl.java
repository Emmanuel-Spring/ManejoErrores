package com.plaxer.springboot.error.app.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.plaxer.springboot.error.app.models.domain.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private List<Usuario> lista;

	public UsuarioServiceImpl() {
		this.lista = new ArrayList<>();
		this.lista.add(new Usuario(1, "Emmanuel", "Nieto"));
		this.lista.add(new Usuario(2, "Mario", "Bolaños"));
		this.lista.add(new Usuario(3, "Felipe", "Guzman"));
		this.lista.add(new Usuario(4, "Rodrigo", "Pinochet"));
		this.lista.add(new Usuario(5, "Carlos", "Borges"));
		this.lista.add(new Usuario(6, "Feliciano", "Nietzche"));
		this.lista.add(new Usuario(7, "Mauricio", "Huenchumilla"));
		this.lista.add(new Usuario(8, "Fernando", "Muñoz"));
		this.lista.add(new Usuario(9, "Matias", "Allende"));
		this.lista.add(new Usuario(10, "Ramiro", "Santibañez"));
	}

	@Override
	public List<Usuario> listar() {

		return this.lista;
	}

	@Override
	public Usuario obtenerPorId(Integer id) {

		Usuario resultado = null;
		for(Usuario u: this.lista) {
			if (u.getId().equals(id)) {
				resultado = u;
				break;
			}
		}

		return resultado;
	}

	@Override
	public Optional<Usuario> obtenerPorIdOptional(Integer id) {
		Usuario usuario = this.obtenerPorId(id);
		return Optional.ofNullable(usuario);
	}

}
