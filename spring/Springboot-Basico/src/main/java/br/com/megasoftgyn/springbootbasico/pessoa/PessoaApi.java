package br.com.megasoftgyn.springbootbasico.pessoa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/pessoa")
public class PessoaApi {
	
	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping 
	public String teste() {
		return "Pessoa";
	}
	
	@GetMapping(path = "listar")
	public List<PessoaDto> listarTodasPessoas() {
		return this.pessoaService.listarTodasPessoas();
	}
	
	@GetMapping(path = "{tipoPessoa}/{bairro}")
	public List<PessoaDto> todasPessoasPorTipoNoBairro(@PathVariable("tipoPessoa") TipoPessoa tp, @PathVariable("bairro") String ba) {
		return this.pessoaService.todasPessoasPorTipoNoBairro(tp, ba);
	}
	
	@GetMapping(path = "listar/bairro={bairro}")
	public List<PessoaDto> todasPessoasNoBairro(@PathVariable("bairro") String ba) {
		return this.pessoaService.todasPessoasNoBairro(ba);
	}
	
	@GetMapping(path = "listar/profissao={profissao}")
	public List<PessoaDto> todasPessoasNaProfissao(@PathVariable("profissao") Long codigo) {
		return this.pessoaService.todasPessoasNaProfissao(codigo);
	}
	
	@GetMapping(path = "totaliptu/tipodepessoa={tipoPessoa}")
	public List<PessoaDto> totalIptuPorTipoDePessoa(@PathVariable("tipoPessoa") TipoPessoa tipoPessoa) {
		return this.pessoaService.totalIptuPorTipoDePessoa(tipoPessoa);
	}
}
