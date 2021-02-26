package br.com.megasoftgyn.springbootbasico.compra;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compra")
public class CompraApi {

	@Autowired
	private CompraService compraService;
	
	@GetMapping
	public String teste() {
		return "Compra";
	}
	
	@GetMapping(path = "listar")
	public List<Compra> listarTodasCompras() {
		return this.compraService.listarTodasCompras();
	}
	
	@GetMapping(path = "total/bairro={nomeBairro}")
	public List<CompraDto> totalDeComprasFeitasDeUmBairro(@PathVariable("nomeBairro") String ba) {
		return this.compraService.totalDeComprasFeitasDeUmBairro(ba);
	}
	
	@GetMapping(path = "todas/pessoaid={codigoPessoa}")
	public List<CompraDto> todasComprasDeUmaPessoaPorCodigo(@PathVariable("codigoPessoa") Long codigo) {
		return this.compraService.todasComprasDeUmaPessoaPorCodigo(codigo);
	}
	
	@GetMapping(path = "listar/{nomeCodigo}")
	public List<CompraDto> todosItemsDeCompraDeUmaPessoa(@PathVariable("nomeCodigo") String nomeCodigo) {
		return this.compraService.todosItemsDeCompraDeUmaPessoa(nomeCodigo);
	}
}
