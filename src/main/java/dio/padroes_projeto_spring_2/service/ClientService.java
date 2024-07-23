package dio.padroes_projeto_spring_2.service;


import dio.padroes_projeto_spring_2.model.Cliente;

public interface ClientService {

    Iterable<Cliente> buscarTodos();

    Cliente bucarPorId(Long id);

    void inserir (Cliente cliente);

    void atualizar (Long id, Cliente cliente);

    void deletar (Long id);
}
