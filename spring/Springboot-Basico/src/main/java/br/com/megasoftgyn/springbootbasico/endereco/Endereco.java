package br.com.megasoftgyn.springbootbasico.endereco;

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

import br.com.megasoftgyn.springbootbasico.bairro.Bairro;
import br.com.megasoftgyn.springbootbasico.pessoa.Pessoa;

@Entity
@Table(name = "endereco")
public class Endereco {

	@Id
	@SequenceGenerator(name = "seq_endereco", sequenceName = "seq_endereco_codigo", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pessoa")
	@Column(name = "codigo", unique = true, nullable = false, updatable = false)
	private Long codigo;
	
	@Column(name = "rua", nullable = false)
	private String rua;
	
	@Column(name = "numero", nullable = false)
	private Integer numero;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bairro")
	private Bairro bairro;
	
	@Column(name = "cep", nullable = false)
	private String cep;
	
	@OneToMany(mappedBy = "endereco",fetch = FetchType.LAZY)
	private List<Pessoa> pessoa;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	
}
