package com.example.demo.operadora;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OperadoraDto {
	private Long id;
	
	private String nome;
	
	private Integer codigo;
	
	private String categoria;

	private Double preco;
	
	public OperadoraDto(Operadora operadora) {
		this.id = operadora.getId();
		this.nome = operadora.getNome();
		this.codigo = operadora.getCodigo();
		this.categoria = operadora.getCategoria();
		this.preco = operadora.getPreco();
	}
	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getCategoria() {
		return categoria;
	}
	
	public Double getPreco() {
		return preco;
	}
}
