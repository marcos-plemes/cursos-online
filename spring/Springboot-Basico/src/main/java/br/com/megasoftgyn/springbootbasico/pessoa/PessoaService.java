package br.com.megasoftgyn.springbootbasico.pessoa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public List<PessoaDto> listarTodasPessoas() {
		return this.pessoaRepository.listarTodasPessoas();
	}
	
	public List<PessoaDto> todasPessoasPorTipoNoBairro(TipoPessoa tp, String ba){
		return this.pessoaRepository.todasPessoasPorTipoNoBairro(tp, ba);
	}
	
	public List<PessoaDto> todasPessoasNoBairro(String ba) {
		return this.pessoaRepository.todasPessoasNoBairro(ba);
	}
	
	public List<PessoaDto> todasPessoasNaProfissao(Long codigo) {
		return this.pessoaRepository.todasPessoasNaProfissao(codigo);
	}
	
	public List<PessoaDto> totalIptuPorTipoDePessoa(TipoPessoa tipoPessoa) {
		return this.pessoaRepository.totalIptuPorTipoDePessoa(tipoPessoa);
	}
}
