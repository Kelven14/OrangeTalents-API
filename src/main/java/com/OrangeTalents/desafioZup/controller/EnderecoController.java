package com.OrangeTalents.desafioZup.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.OrangeTalents.desafioZup.dto.EnderecoDTO;
@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoController {

	@Autowired
	EnderecoService enderecoService;
	
	@PostMapping
	public ResponseEntity<EnderecoDTO> insert(@RequestBody EnderecoDTO enderecoDTO) {
		enderecoDTO = enderecoService.insert(enderecoDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(enderecoDTO.getId())
				.toUri();
		return ResponseEntity.created(uri).body(enderecoDTO);
	}
}
