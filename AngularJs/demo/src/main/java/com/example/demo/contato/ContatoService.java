package com.example.demo.contato;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.operadora.OperadoraService;

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository contatoRepository;
	
	@Autowired
	private OperadoraService operadoraService;
	
	public List<ContatoDto> listarContatos() {
		return this.contatoRepository.listarContatos();
	}
	
	@Transactional
	public Long cadastrarContato(ContatoDtoCadastro dados) {
		Contato entidade;
		if(dados.getId() == null) {
			entidade = dados.contatoDtoCadastroToContato();
			entidade.setOperadora(this.operadoraService.buscarOperadora(this.operadoraService.cadastrarOperadora(dados.getOperadora())));
			this.cadastrarContato(entidade);
			return entidade.getId();
		}
		return dados.getId();
	}
	
	@Transactional
	public void cadastrarContato(Contato entidadde) {
		this.contatoRepository.cadastrarContato(entidadde);
	}
}
