package com.example.demo.contato;

import java.util.Date;

import com.example.demo.operadora.OperadoraDtoCadastro;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContatoDtoCadastro {

	private Long id;
	
	private String nome;
	
	private String telefone;
	
	private Date data;
	
	private OperadoraDtoCadastro operadora;
	
	private String serial;

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public Date getData() {
		return data;
	}

	public OperadoraDtoCadastro getOperadora() {
		return operadora;
	}
	
	public String getSerial() {
		return serial;
	}
	
	public Contato contatoDtoCadastroToContato() {
		return new Contato(this.nome, this.telefone, this.data, this.serial);
	}
}
