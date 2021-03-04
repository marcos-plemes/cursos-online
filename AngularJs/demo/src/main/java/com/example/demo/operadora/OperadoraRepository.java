package com.example.demo.operadora;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

@Repository
public class OperadoraRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	private CriteriaBuilder builder;
	
	private CriteriaQuery<OperadoraDto> criteriaQuery;
	
	private Root<Operadora> operadora;
	
	private void criteriaOperadora() {
		this.builder = this.entityManager.getCriteriaBuilder();
		this.criteriaQuery = this.builder.createQuery(OperadoraDto.class);
		this.operadora = this.criteriaQuery.from(Operadora.class);
	}
	
	public List<OperadoraDto> listarOperadoras() {
		this.criteriaOperadora();
		this.criteriaQuery.select(this.builder.construct(OperadoraDto.class, this.operadora));
		return this.entityManager.createQuery(this.criteriaQuery).getResultList();
	}
	
	public Operadora buscarOperadora(Long id) {
		return this.entityManager.find(Operadora.class, id);
	}
	
	public void cadastrarOperadora(Operadora entidade) {
		this.entityManager.persist(entidade);
	}
}
