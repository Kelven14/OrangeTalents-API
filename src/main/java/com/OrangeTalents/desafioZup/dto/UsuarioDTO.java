package com.OrangeTalents.desafioZup.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.OrangeTalents.desafioZup.model.Usuario;

public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String email;
	private String cpf;
	private Date dataNascimento;
	private List<EnderecoDTO> endereco = new ArrayList<>();

	public UsuarioDTO(Long id, String nome, String email, String cpf, Date dataNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}

	public UsuarioDTO(Usuario entity) {
		id = entity.getId();
		nome = entity.getNome();
		email = entity.getEmail();
		cpf = entity.getCpf();
		dataNascimento = entity.getDataNascimento();
		endereco = entity.getEndereco().stream().map(x -> new EnderecoDTO(x)).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<EnderecoDTO> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<EnderecoDTO> endereco) {
		this.endereco = endereco;
	}

}
