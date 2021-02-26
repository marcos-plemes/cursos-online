package br.com.megasoftgyn.springbootbasico.compra;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.megasoftgyn.springbootbasico.itemdecompra.ItemDeCompra;
import br.com.megasoftgyn.springbootbasico.pessoa.Pessoa;

@Entity
@Table(name = "compra")
public class Compra {

	@Id
	@SequenceGenerator(name = "seq_compra", sequenceName = "seq_compra_codigo", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_compra")
	@Column(name = "codigo", unique = true, nullable = false, updatable = false)
	private Long codigo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pessoa")
	private Pessoa pessoa;
	
	@Column(name = "valor", nullable = false)
	private Double valor;
	
	@OneToMany(mappedBy = "compra", fetch = FetchType.LAZY)
	private List<ItemDeCompra> itemDeCompra;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
	
}
