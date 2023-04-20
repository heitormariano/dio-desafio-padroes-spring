package dio.padroes.gof.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dio.padroes.gof.model.Cliente;
import dio.padroes.gof.service.IClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteRestController {

	@Autowired
	private IClienteService clienteService;

	@PostMapping
	public ResponseEntity<Cliente> cadastrar(@RequestBody Cliente cliente) {
		Cliente clienteCadastrado = clienteService.cadastrar(cliente);
		return new ResponseEntity<>(clienteCadastrado, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Cliente>> buscarTodos() {
		List<Cliente> clientes = clienteService.buscarTodos();
		return new ResponseEntity<>(clientes, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
		Cliente clienteRecuperado = clienteService.buscarPorId(id);
		return new ResponseEntity<>(clienteRecuperado, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
		Cliente clienteAtualizado = clienteService.atualizar(id, cliente);
		return new ResponseEntity<>(clienteAtualizado, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		clienteService.excluir(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
