package com.example.demo.operadora;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperadoraService {

	@Autowired
	private OperadoraRepository operadoraRepository;
	
	public List<OperadoraDto> listarOperadoras() {
		return this.operadoraRepository.listarOperadoras();
	}
	
	public Operadora buscarOperadora(Long id) {
		return this.operadoraRepository.buscarOperadora(id);
	}
	
	@Transactional
	public Long cadastrarOperadora(OperadoraDtoCadastro dados) {
		Operadora entidade;
		if(dados.getId() == null) {
			entidade = dados.operadoraDtoCadastroToOperadora();
			this.cadastrarOperadora(entidade);
			return entidade.getId();
		}
		return dados.getId();
	}
	
	@Transactional
	public void cadastrarOperadora(Operadora entidade) {
		this.operadoraRepository.cadastrarOperadora(entidade);
	}
}
