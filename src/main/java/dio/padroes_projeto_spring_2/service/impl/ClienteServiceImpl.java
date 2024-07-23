package dio.padroes_projeto_spring_2.service.impl;

import dio.padroes_projeto_spring_2.model.Cliente;
import dio.padroes_projeto_spring_2.model.Endereco;
import dio.padroes_projeto_spring_2.repository.ClienteRepository;
import dio.padroes_projeto_spring_2.repository.EnderecoRepository;
import dio.padroes_projeto_spring_2.service.ClientService;
import dio.padroes_projeto_spring_2.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClientService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente bucarPorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElse(null);
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if (clienteBd.isPresent()){
            salvarClienteComCep(cliente);
        }
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    private void salvarClienteComCep(Cliente cliente) {
        //Busca o Cep do Cliente
        String cep = cliente.getEndereco().getCep();
        //Busca o Endereço através do CEP do Cliente no Repositorio
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            //Caso não ache no repositorio ele busca na API do ViaCep
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            //Depois salva o novo endereco no repositorio
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });

        //Adiciona o novo endereco
        cliente.setEndereco(endereco);

        //salva o novo Cliente
        clienteRepository.save(cliente);
    }
}
