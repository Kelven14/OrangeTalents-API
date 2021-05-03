package com.OrangeTalents.desafioZup.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(min = 3, max = 255)
	@NotBlank(message = "O nome não pode está em branco")
	private String nome;

	@Column(unique = true)
	@NotBlank(message = "O Email não pode está em branco")
	@Email(message = "O Email digitado é inválido")
	private String email;

	@Column(unique = true)
	@NotBlank(message = "O CPF não pode está em branco")
	@CPF(message = "O CPF digitado é inválido")
	private String cpf;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;

	@JsonIgnoreProperties("usuario")
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<Endereco> endereco = new ArrayList<>();

	// Métodos Getters e Setters
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}

}
