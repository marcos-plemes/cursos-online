package com.example.demo.contato;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/contato")
public class ContatoApi {
	
	@Autowired
	private ContatoService contatoService;
	
	@GetMapping
	public List<ContatoDto> listarContatos() {
		return this.contatoService.listarContatos();
	}
	
	@GetMapping(path = "{id}")
	public Contato buscarContato(@PathVariable("id") Long id) {
		return this.contatoService.buscarContato(id);
	}
	
	@PostMapping
	public Long cadastrarContato(@RequestBody ContatoDtoCadastro dados) {
		return this.contatoService.cadastrarContato(dados);
	}
}
