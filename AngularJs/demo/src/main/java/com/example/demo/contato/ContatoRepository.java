package com.example.demo.contato;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

@Repository
public class ContatoRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	private CriteriaBuilder builder;
	
	private CriteriaQuery<ContatoDto> criteriaQuery;
	
	private Root<Contato> contato;
	
	private void criteriaContato() {
		this.builder = this.entityManager.getCriteriaBuilder();
		this.criteriaQuery = this.builder.createQuery(ContatoDto.class);
		this.contato = this.criteriaQuery.from(Contato.class);
	}
	
	public List<ContatoDto> listarContatos() {
		this.criteriaContato();
		this.criteriaQuery.select(this.builder.construct(ContatoDto.class, this.contato));
		this.criteriaQuery.orderBy(this.builder.asc(this.contato.get("id")));
		return this.entityManager.createQuery(this.criteriaQuery).getResultList();
	}
	
	public Contato buscarContato(Long id) {
		return this.entityManager.find(Contato.class, id);
	}
	
	public void cadastrarContato(Contato entidade) {
		this.entityManager.persist(entidade);
	}
}
