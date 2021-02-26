package br.com.megasoftgyn.springbootbasico.endereco;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public List<Endereco> listarTodosEndereco() {
		return this.enderecoRepository.listarTodosEndereco();
	}
}
