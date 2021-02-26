package br.com.megasoftgyn.springbootbasico.profissao;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.megasoftgyn.springbootbasico.pessoa.Pessoa;

@Entity
@Table(name = "profissao")
public class Profissao {

	@Id
	@SequenceGenerator(name = "seq_profissao", sequenceName = "seq_profissao_codigo", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_profissao")
	@Column(name = "codigo", unique = true, nullable = false, updatable = false)
	private Long codigo;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "salario", nullable = false)
	private Double salario;
	
	@OneToMany(mappedBy = "profissao", fetch = FetchType.LAZY)
	private List<Pessoa> pessoa;

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

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}	
}
