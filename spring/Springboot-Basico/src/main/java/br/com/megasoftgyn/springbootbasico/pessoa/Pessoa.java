package br.com.megasoftgyn.springbootbasico.pessoa;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.megasoftgyn.springbootbasico.compra.Compra;
import br.com.megasoftgyn.springbootbasico.endereco.Endereco;
import br.com.megasoftgyn.springbootbasico.profissao.Profissao;

@Entity
@Table(name = "pessoa")
public class Pessoa {

	@Id
	@SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa_codigo", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pessoa")
	@Column(name = "codigo", unique = true, nullable = false, updatable = false)
	private Long codigo;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "sobrenome", nullable = false)
	private String sobrenome;

	@Column(name = "idade", nullable = false)
	private Integer idade;
	
	@Column(name = "peso", nullable = true)
	private Double peso;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "endereco")
	private Endereco endereco;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "profissao")
	private Profissao profissao;
	
	@Column(name = "cpf", nullable = false, unique = true)
	private String cpf;
	
	@Column(name = "tipo_de_pessoa", nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoPessoa tipoDePessoa;
	
	@OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY)
	private List<Compra> compra;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Profissao getProfissao() {
		return profissao;
	}

	public void setProfissao(Profissao profissao) {
		this.profissao = profissao;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public TipoPessoa getTipoDePessoa() {
		return tipoDePessoa;
	}

	public void setTipoDePessoa(TipoPessoa tipoDePessoa) {
		this.tipoDePessoa = tipoDePessoa;
	}
	
	

}
