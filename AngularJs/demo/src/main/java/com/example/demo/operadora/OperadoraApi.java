package com.example.demo.operadora;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/operadora")
public class OperadoraApi {

	@Autowired
	private OperadoraService operadoraservice;
	
	@GetMapping
	public List<OperadoraDto> listarOperadoras() {
		return this.operadoraservice.listarOperadoras();
	}
	
	@PostMapping
	public Long cadastrarOperadora(@RequestBody OperadoraDtoCadastro dados) {
		return this.operadoraservice.cadastrarOperadora(dados);
	}
}
