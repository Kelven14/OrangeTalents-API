package com.OrangeTalents.desafioZup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OrangeTalents.desafioZup.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}