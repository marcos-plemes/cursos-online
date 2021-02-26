package br.com.megasoftgyn.springbootbasico.compra;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.megasoftgyn.springbootbasico.itemdecompra.ItemDeCompra;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompraDto {
	
	private Long codigo;
	
	private Double valorDaCompra;

	private Long count;
	
	private String nome;

	private Double valorDoItem;
	

	public CompraDto(ItemDeCompra itemDeCompra, Compra compra) {
		this.codigo = itemDeCompra.getCodigo();
		this.nome = itemDeCompra.getNome();
		this.valorDoItem = itemDeCompra.getValor();
		this.valorDaCompra = compra.getValor();
	}

	public CompraDto(Long count) {
		this.count = count;
	}

	public CompraDto(Long codigo, Double valorDaCompra) {
		this.codigo = codigo;
		this.valorDaCompra = valorDaCompra;
	}


	public Long getCodigo() {
		return codigo;
	}

	public Double getValorDaCompra() {
		return valorDaCompra;
	}


	public Long getCount() {
		return count;
	}

	public String getNome() {
		return nome;
	}

	public Double getValorDoItem() {
		return valorDoItem;
	}
	
	
	
}
