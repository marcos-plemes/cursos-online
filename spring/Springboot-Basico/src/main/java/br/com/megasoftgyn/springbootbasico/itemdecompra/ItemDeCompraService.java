package br.com.megasoftgyn.springbootbasico.itemdecompra;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemDeCompraService {

	
	@Autowired
	private ItemDeCompraRepository itemDeCompraRepository;
	
	public List<ItemDeCompra> listarTodosItemDeCompra() {
		return this.itemDeCompraRepository.listarTodositemDeCompra();
	}
	
	public List<ItemDeCompraDto> todosItemsDeCompraCodigo(Long codigo, Integer pag) {
		return this.itemDeCompraRepository.todosItemsDeCompraPorCompraCodigo(codigo, pag);
	}
}
