package br.com.megasoftgyn.springbootbasico.itemdecompra;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.megasoftgyn.springbootbasico.compra.Compra;

@Entity
@Table(name = "item_de_compra")
public class ItemDeCompra {

	@Id
	@SequenceGenerator(name = "seq_item_de_compra", sequenceName = "seq_item_de_compra_codigo", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_item_de_compra")
	@Column(name = "codigo", unique = true, nullable = false, updatable = false)
	private Long codigo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "compra")
	private Compra compra;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "valor", nullable = false)
	private Double valor;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
}
