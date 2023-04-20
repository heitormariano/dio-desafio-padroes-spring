package dio.padroes.gof.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dio.padroes.gof.model.Cliente;
import dio.padroes.gof.model.Endereco;
import dio.padroes.gof.repository.ClienteRepository;
import dio.padroes.gof.repository.EnderecoRepository;
import dio.padroes.gof.service.IClienteService;
import dio.padroes.gof.service.httpclient.ViaCepService;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	EnderecoRepository enderecoRepository;

	@Autowired
	ViaCepService viaCepService;

	@Override
	public List<Cliente> buscarTodos() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente buscarPorId(Long id) {
		return clienteRepository.findById(id).get();
	}

	@Override
	public Cliente cadastrar(Cliente cliente) {
		Endereco endereco = obterEnderecoCliente(cliente);

		cliente.setEndereco(endereco);
		return clienteRepository.save(cliente);
	}

	/**
	 * O método considera as situações em que ocorre mudança no nome do cliente ou
	 * alteração de cep do endereço
	 *
	 */
	@Override
	public Cliente atualizar(Long id, Cliente cliente) {
		Cliente clienteRetornar = null;

		Optional<Cliente> clienteBd = clienteRepository.findById(id);
		if (clienteBd.isPresent()) {
			Endereco endereco = obterEnderecoCliente(cliente);

			Cliente clienteAtualizar = clienteBd.get();
			clienteAtualizar.setNome(cliente.getNome());
			clienteAtualizar.setEndereco(endereco);
			clienteRetornar = clienteRepository.save(clienteAtualizar);
		}
		return clienteRetornar;
	}

	@Override
	public void excluir(Long id) {
		clienteRepository.deleteById(id);
	}

	private Endereco obterEnderecoCliente(Cliente cliente) {
		String cep = cliente.getEndereco().getCep();
		Endereco endereco = enderecoRepository.findByCep(cep);
		if (endereco == null) {
			Endereco novoEndereco = viaCepService.consultarCep(cep);
			novoEndereco.setCep(novoEndereco.getCep().replace("-", ""));
			endereco = enderecoRepository.save(novoEndereco);
		}
		return endereco;
	}

}
