package br.com.megasoftgyn.springbootbasico.profissao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class ProfissaoRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Profissao> listarTodasProfissoes() {
		final TypedQuery<Profissao> tq = this.entityManager.createQuery("SELECT pr FROM Profissao AS pr", Profissao.class);
		return tq.getResultList();
	}
}
