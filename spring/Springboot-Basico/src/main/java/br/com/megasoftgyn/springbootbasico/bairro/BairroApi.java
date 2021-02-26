package br.com.megasoftgyn.springbootbasico.bairro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bairro")
public class BairroApi {
	
	@Autowired
	private BairroService bairroService;
	
	@GetMapping
	public String teste() {
		return "Bairro";
	}
	
	@GetMapping(path = "listar")
	public List<Bairro> listarTodosBairros() {
		return this.bairroService.listarTodosBairros();
	}
}
