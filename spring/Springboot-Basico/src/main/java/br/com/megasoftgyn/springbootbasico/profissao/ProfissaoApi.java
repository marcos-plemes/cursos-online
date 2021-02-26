package br.com.megasoftgyn.springbootbasico.profissao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profissao")
public class ProfissaoApi {
	
	@Autowired
	private ProfissaoService profissaoService;
	
	@GetMapping
	public String teste() {
		return "Profissao";
	}
	
	@GetMapping(path = "listar")
	public List<Profissao> listarTodasProfissoes() {
		return this.profissaoService.listarTodasProfissoes();
	}
}
