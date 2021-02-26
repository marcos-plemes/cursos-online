package br.com.megasoftgyn.springbootbasico.itemdecompra;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ItemDeCompraDto {

	private Long codigo;
	
	private String nome;
	
	private Double valor;
	
	public ItemDeCompraDto(Long codigo, String nome, Double valor) {
		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public Double getValor() {
		return valor;
	}

	public Long getCodigo() {
		return codigo;
	}
	
	
}
