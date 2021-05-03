package com.OrangeTalents.desafioZup.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.OrangeTalents.desafioZup.model.Endereco;
import com.OrangeTalents.desafioZup.service.EnderecoService;

@RestController
@RequestMapping("/endereco")
@CrossOrigin("*")
public class EnderecoController {

	@Autowired
	EnderecoService enderecoService;

	@PostMapping("/cadastrar")
	public ResponseEntity<Endereco> cadastrarUsuario(@RequestBody Endereco endereco) {
		try {
			endereco = enderecoService.inserir(endereco);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(endereco.getId())
					.toUri();
			return ResponseEntity.created(uri).body(endereco);
		} catch (Exception e) {
			return new ResponseEntity<Endereco>(HttpStatus.BAD_REQUEST);
		}
	}
}
