package br.com.megasoftgyn.springbootbasico.bairro;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class BairroRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Bairro> listarTodosBairros() {
		final TypedQuery<Bairro> tq = this.entityManager.createQuery("SELECT ba FROM Bairro AS ba", Bairro.class);
		return tq.getResultList();
	}
	
}
