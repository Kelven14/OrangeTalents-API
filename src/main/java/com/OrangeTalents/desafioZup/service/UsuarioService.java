package com.OrangeTalents.desafioZup.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.OrangeTalents.desafioZup.model.Usuario;

import com.OrangeTalents.desafioZup.repository.UsuarioRepository;
import com.OrangeTalents.desafioZup.service.exceptions.MensageException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Transactional
	public Usuario getById(Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Não existe um usuário cadastrado com o ID: " + id));
	}

	@Transactional
	public Optional<Usuario> inserir(Usuario usuario) {
		if (usuarioRepository.findByCpf(usuario.getCpf()).isPresent()) {
			throw new MensageException("Já existe um cliente cadastrado com este cpf");
		}
		if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
			throw new MensageException("Já existe um cliente cadastrado com este E-mail");
		}
		return Optional.of ( usuarioRepository.save(usuario));

	}

}
