package br.com.megasoftgyn.springbootbasico.endereco;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class EnderecoRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	public List<Endereco> listarTodosEndereco() {
		final TypedQuery<Endereco> tq = this.entityManager.createQuery("SELECT en FROM Endereco AS en", Endereco.class);
		return tq.getResultList();
	}
}
