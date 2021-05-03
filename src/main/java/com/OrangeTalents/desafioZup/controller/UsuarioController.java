package com.OrangeTalents.desafioZup.controller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.OrangeTalents.desafioZup.model.Usuario;
import com.OrangeTalents.desafioZup.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Long id) {

		Usuario usuario = usuarioService.getById(id);
		return ResponseEntity.ok().body(usuario);

	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> cadastrarUsuario(@Valid @RequestBody Usuario usuario) {
		Optional<Usuario> user = usuarioService.inserir(usuario);
		try {
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.get().getId())
					.toUri();
			return ResponseEntity.created(uri).body(user.get());
		} catch (Exception e) {
			return new ResponseEntity<Usuario>(HttpStatus.BAD_REQUEST);
		}
	}
}
