package com.example.demo.contato;

import java.util.Date;

import com.example.demo.operadora.OperadoraDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContatoDto {
	private String nome;
	
	private String telefone;
	
	private Date data;
	
	private OperadoraDto operadora;

	public ContatoDto(Contato contato) {
		this.nome = contato.getNome();
		this.telefone = contato.getTelefone();
		this.data = contato.getData();
		this.operadora = new OperadoraDto(contato.getOperadora());
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

	public OperadoraDto getOperadora() {
		return operadora;
	}
	
	
	
	
}
