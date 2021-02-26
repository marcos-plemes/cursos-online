package br.com.megasoftgyn.springbootbasico.pessoa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import br.com.megasoftgyn.springbootbasico.bairro.Bairro;
import br.com.megasoftgyn.springbootbasico.endereco.Endereco;
import br.com.megasoftgyn.springbootbasico.profissao.Profissao;

@Repository
public class PessoaRepository {

	@PersistenceContext
    private EntityManager entityManager;
	
	private static final String ENDERECOSTRING = "endereco";
	private static final String BAIRROSTRING = "bairro";
	private static final String TIPODEPESSOASTRING = "tipoDePessoa";
	
	public List<PessoaDto> listarTodasPessoas() {
		final TypedQuery<PessoaDto> tq = this.entityManager.createQuery("SELECT new br.com.megasoftgyn.springbootbasico.pessoa.PessoaDto(pe.nome) FROM Pessoa AS pe order by pe.codigo", PessoaDto.class);
		return tq.getResultList();
	}
	
	public List<PessoaDto> todasPessoasPorTipoNoBairro(TipoPessoa tp, String ba) {
		final TypedQuery<PessoaDto> tq = this.entityManager.createQuery("SELECT new br.com.megasoftgyn.springbootbasico.pessoa.PessoaDto(pe.tipoDePessoa, count(pe)) FROM Pessoa AS pe "
													                  + "INNER JOIN pe.endereco AS en "
													                  + "INNER JOIN en.bairro AS ba "
													                  + "WHERE pe.tipoDePessoa = :tipoDePessoa "
													                  + "AND ba.nome = :nomeBairro "
													                  + "group by pe.tipoDePessoa", PessoaDto.class);
	    tq.setParameter("tipoDePessoa", tp);
		tq.setParameter("nomeBairro", ba);
		return tq.getResultList();
	}
	
	public List<PessoaDto> todasPessoasNoBairro(String ba) {
		final TypedQuery<PessoaDto> tq = this.entityManager.createQuery("SELECT new br.com.megasoftgyn.springbootbasico.pessoa.PessoaDto(pe.nome, pe.cpf) FROM Pessoa AS pe "
															          + "INNER JOIN pe.endereco AS en "
															          + "INNER JOIN en.bairro AS ba "
															          + "WHERE ba.nome = :bairroNome", PessoaDto.class);
		tq.setParameter("bairroNome", ba);
		return tq.getResultList();
	}
	
	public List<PessoaDto> todasPessoasNaProfissao(Long codigo) {
		final TypedQuery<PessoaDto> tq = this.entityManager.createQuery("SELECT new br.com.megasoftgyn.springbootbasico.pessoa.PessoaDto(pe.nome, pe.sobrenome, pe.idade) FROM Pessoa AS pe "
																	  + "INNER JOIN pe.profissao AS pr "
																	  + "WHERE pr.codigo :codigoProfissao", PessoaDto.class);
		tq.setParameter("codigoProfissao", codigo);
		return tq.getResultList();
	}
	
	public List<PessoaDto> totalIptuPorTipoDePessoa(TipoPessoa tipoPessoa) {
		final TypedQuery<PessoaDto> tq = this.entityManager.createQuery("SELECT new br.com.megasoftgyn.springbootbasico.pessoa.PessoaDto(SUM(ba.iptu)) FROM Pessoa AS pe "
											                          + "INNER JOIN pe.endereco AS en "
											                          + "INNER JOIN en.bairro AS ba "
											                          + "WHERE pe.tipoDePessoa = :tipoDePessoa", PessoaDto.class);
		tq.setParameter("tipoDePessoa", tipoPessoa);
		return tq.getResultList();
	}
}
