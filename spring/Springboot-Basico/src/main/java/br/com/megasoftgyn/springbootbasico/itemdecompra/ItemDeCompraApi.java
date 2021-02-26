package br.com.megasoftgyn.springbootbasico.itemdecompra;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/itemdecompra")
public class ItemDeCompraApi {

	@Autowired
	private ItemDeCompraService itemDeCompraService;
	
	@GetMapping
	public String teste() {
		return "ItemDeCompra";
	}
	
	@GetMapping(path = "listar")
	public List<ItemDeCompra> listarTodosItemDeCompra() {
		return this.itemDeCompraService.listarTodosItemDeCompra();
	}
	
	@GetMapping(path = "listar/codigo={codigo}/pagina={pag}")
	public List<ItemDeCompraDto> todosItemsDeCompraPorCompraCodigo(@PathVariable("codigo") Long codigo, @PathVariable("pag") Integer pag) {
		return this.itemDeCompraService.todosItemsDeCompraCodigo(codigo, pag);
	}
}
