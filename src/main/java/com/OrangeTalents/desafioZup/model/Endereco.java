package com.OrangeTalents.desafioZup.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

@Entity
@Table(name = "tb_endereco")
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O logradouro não pode está em branco")
	private String logradouro;

	@Min(1)
	@NotNull
	private int numero;

	@NotBlank(message = "O complemento não pode está em branco")
	private String complemento;

	@NotBlank(message = "O bairro não pode está em branco")
	private String bairro;

	@NotBlank(message = "A cidade não pode está em branco")
	private String cidade;

	@NotBlank(message = "O estado não pode está em branco")
	private String estado;

	@NotBlank(message = "O cep não pode está em branco")
	private String cep;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	// Métodos Getters e Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
