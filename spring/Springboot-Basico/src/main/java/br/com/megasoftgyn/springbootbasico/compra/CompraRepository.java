package br.com.megasoftgyn.springbootbasico.compra;

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
import br.com.megasoftgyn.springbootbasico.itemdecompra.ItemDeCompra;
import br.com.megasoftgyn.springbootbasico.pessoa.Pessoa;

@Repository
public class CompraRepository {

	
	@PersistenceContext
	EntityManager entityManager;
	
	private static final String PESSOASTRING = "pessoa";
	private static final String CODIGOSTRING = "codigo";
	
	public List<Compra> listarTodasCompras() {
		final TypedQuery<Compra> tq = this.entityManager.createQuery("SELECT co FROM Compra AS co", Compra.class);
		return tq.getResultList();
	}
	
	public List<CompraDto> totalDeComprasFeitasDeUmBairro(String ba) {
		TypedQuery<CompraDto> tq = this.entityManager.createQuery(
				"SELECT new br.com.megasoftgyn.springbootbasico.compra.CompraDto(count(co)) FROM Compra AS co "
			  + "INNER JOIN co.pessoa AS pe "
			  + "INNER JOIN pe.endereco AS en "
			  + "INNER JOIN en.bairro AS ba "
			  + "WHERE ba.nome = :nomeBairro", CompraDto.class);
		tq.setParameter("nomeBairro", ba);
		return tq.getResultList();
	}
	
	public List<CompraDto> todasComprasDeUmaPessoaPorCodigo(Long codigo) {
		TypedQuery<CompraDto> tq = this.entityManager.createQuery("SELECT new br.com.megasoftgyn.springbootbasico.compra.CompraDto(co.codigo, co.valor) FROM Compra AS co "
																+ "INNER JOIN co.pessoa AS pe "
																+ "WHERE pe.codigo = :codigoPessoa", CompraDto.class);
		tq.setParameter("codigoPessoa", codigo);
		return tq.getResultList();
	}
	
	public List<CompraDto> todosItemsDeCompraDeUmaPessoa(Long codigo, String nome) {
		TypedQuery<CompraDto> tq = this.entityManager.createQuery("SELECT new br.com.megasoftgyn.springbootbasico.compra.CompraDto(idc, co) FROM Compra AS co "
																+ "INNER JOIN co.pessoa AS pe "
																+ "INNER JOIN co.itemDeCompra AS idc "
																+ "WHERE pe.nome = :nomePessoa "
																+ "OR co.codigo = :codigoCompra", CompraDto.class);
		tq.setParameter("nomePessoa", nome);
		tq.setParameter("codigoCompra", codigo);
		return tq.getResultList();
	}
}
