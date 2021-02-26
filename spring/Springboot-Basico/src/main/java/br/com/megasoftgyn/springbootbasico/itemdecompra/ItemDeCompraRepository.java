package br.com.megasoftgyn.springbootbasico.itemdecompra;

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

import br.com.megasoftgyn.springbootbasico.compra.Compra;

@Repository
public class ItemDeCompraRepository {

	
	@PersistenceContext
	EntityManager entityManager;
	
	public List<ItemDeCompra> listarTodositemDeCompra() {
		final TypedQuery<ItemDeCompra> tq = this.entityManager.createQuery("SELECT idc FROM ItemDeCompra AS idc", ItemDeCompra.class);
		return tq.getResultList();
	}
	
	public List<ItemDeCompraDto> todosItemsDeCompraPorCompraCodigo(Long codigo, Integer pag) {
		TypedQuery<ItemDeCompraDto> tq = this.entityManager.createQuery("SELECT new br.com.megasoftgyn.springbootbasico.itemdecompra.ItemDeCompraDto(idc.codigo, idc.nome, idc.valor) FROM ItemDeCompra AS idc "
																	  + "INNER JOIN idc.compra AS co "
																	  + "WHERE co.codigo = :codigoItemDeCompra", ItemDeCompraDto.class);
		tq.setParameter("codigoItemDeCompra", codigo);
		tq.setFirstResult((pag-1) * 10);
		tq.setMaxResults(10);
		return tq.getResultList();
	}
	
}
