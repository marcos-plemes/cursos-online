package br.com.megasoftgyn.springbootbasico.pessoa;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class PessoaDto {
	
	private String nome;
	
	private String sobrenome;
	
	private String cpf;
	
	private TipoPessoa tipoDePessoa;

	private Long count;
	
	private Integer idade;
	
	private Double totalIPTU;
	
	
	
	public PessoaDto(Double totalIPTU) {
		this.totalIPTU = totalIPTU;
	}

	public PessoaDto(String nome, String sobrenome, Integer idade) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.idade = idade;
	}

	public PessoaDto(TipoPessoa tipoDePessoa, Long count) {
		this.tipoDePessoa = tipoDePessoa;
		this.count = count;
	}

	public PessoaDto(String nome, String sobrenome, TipoPessoa tipoDePessoa) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.tipoDePessoa = tipoDePessoa;
	}

	public PessoaDto(String nome) {
		this.nome = nome;
	}

	public PessoaDto(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public TipoPessoa getTipoDePessoa() {
		return tipoDePessoa;
	}

	public Long getCount() {
		return count;
	}

	public Integer getIdade() {
		return idade;
	}

	public Double getTotalIPTU() {
		return totalIPTU;
	}
	
	
	
}
