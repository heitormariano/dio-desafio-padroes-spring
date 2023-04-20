package dio.padroes.gof.service;

import java.util.List;

import dio.padroes.gof.model.Cliente;

public interface IClienteService {

	List<Cliente> buscarTodos();

	Cliente buscarPorId(Long id);

	Cliente cadastrar(Cliente cliente);

	Cliente atualizar(Long id, Cliente cliente);

	void excluir(Long id);
}
