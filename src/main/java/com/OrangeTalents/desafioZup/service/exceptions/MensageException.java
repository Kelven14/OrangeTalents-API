package com.OrangeTalents.desafioZup.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MensageException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	
	public MensageException(String mensagem) {
		super(mensagem);
	}

}
