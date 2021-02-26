package br.com.megasoftgyn.springbootbasico.bairro;

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

import br.com.megasoftgyn.springbootbasico.endereco.Endereco;

@Entity
@Table(name = "bairro")
public class Bairro {
	
	@Id
    @SequenceGenerator(name = "seq_bairro", sequenceName = "seq_pessoa_codigo", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_bairro")
	@Column(name = "codigo", unique = true, nullable = false, updatable = false)
	private Long codigo;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "iptu", nullable = false)
	private Double iptu;

	@OneToMany(mappedBy = "bairro", fetch = FetchType.LAZY)
	private List<Endereco> endereco;
	
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

	public Double getIptu() {
		return iptu;
	}

	public void setIptu(Double iptu) {
		this.iptu = iptu;
	}
	
	
	
}
