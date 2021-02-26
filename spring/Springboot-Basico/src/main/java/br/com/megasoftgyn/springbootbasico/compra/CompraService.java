package br.com.megasoftgyn.springbootbasico.compra;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraService {

	
	@Autowired
	private CompraRepository compraRepository;
	
	public List<Compra> listarTodasCompras() {
		return this.compraRepository.listarTodasCompras();
	}
	
	public List<CompraDto> totalDeComprasFeitasDeUmBairro(String ba) {
		return this.compraRepository.totalDeComprasFeitasDeUmBairro(ba);
	}
	
	public List<CompraDto> todasComprasDeUmaPessoaPorCodigo(Long codigo) {
		return this.compraRepository.todasComprasDeUmaPessoaPorCodigo(codigo);
	}
	
	public List<CompraDto> todosItemsDeCompraDeUmaPessoa(String nomeCodigo) {
		return this.separarNomeDeCodigo(nomeCodigo);
	}
	
	public List<CompraDto> separarNomeDeCodigo(String nomeCodigo) {
		if(nomeCodigo.matches("[0-9]*")) 
			return this.compraRepository.todosItemsDeCompraDeUmaPessoa(Long.parseLong(nomeCodigo), null);
		return this.compraRepository.todosItemsDeCompraDeUmaPessoa(null, nomeCodigo);
	}
}
