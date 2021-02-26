package br.com.megasoftgyn.springbootbasico.profissao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfissaoService {
	
	@Autowired
	private ProfissaoRepository profissaoRepository;
	
	public List<Profissao> listarTodasProfissoes() {
		return this.profissaoRepository.listarTodasProfissoes();
	}
}
