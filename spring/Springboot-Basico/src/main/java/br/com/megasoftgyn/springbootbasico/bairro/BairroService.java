package br.com.megasoftgyn.springbootbasico.bairro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BairroService {

	@Autowired
	private BairroRepository bairroRepository;
	
	public List<Bairro> listarTodosBairros() {
		return this.bairroRepository.listarTodosBairros();
	}
}
