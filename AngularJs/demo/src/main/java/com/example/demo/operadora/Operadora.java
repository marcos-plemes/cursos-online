package com.example.demo.operadora;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.example.demo.contato.Contato;

@Entity
@Table(name = "operadora")
public class Operadora {

	@Id
	@SequenceGenerator(name = "seq_operadora", sequenceName = "seq_operadora_id", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_operadora")
	@Column(name = "id", unique = true, nullable = false, updatable = false)
	private Long id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "codigo", nullable = false)
	private Integer codigo;
	
	@Column(name = "categoria", nullable = false)
	private String categoria;
	
	@Column(name = "preco", nullable = false)
	private Double preco;
	
	@OneToMany
	private List<Contato> contato;

	public Operadora() {
	}
	
	public Operadora(String nome, Integer codigo, String categoria, Double preco) {
		this.nome = nome;
		this.codigo = codigo;
		this.categoria = categoria;
		this.preco = preco;
	}

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

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	
	
	
}
