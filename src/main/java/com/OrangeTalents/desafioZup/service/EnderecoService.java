package com.OrangeTalents.desafioZup.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OrangeTalents.desafioZup.model.Endereco;
import com.OrangeTalents.desafioZup.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	EnderecoRepository enderecoRepository;

	@Transactional
	public Endereco inserir(Endereco endereco) {
		endereco = enderecoRepository.save(endereco);
		return endereco;
	}
}
