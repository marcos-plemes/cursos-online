package br.com.megasoftgyn.springbootbasico.endereco;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/endereco")
public class EnderecoApi {

	@Autowired
	private EnderecoService enderecoService;
	
	@GetMapping
	public String teste() {
		return "Endereco";
	}
	
	@GetMapping(path = "listar")
	public List<Endereco> listarTodosEndereco() {
		return this.enderecoService.listarTodosEndereco();
	}
}
