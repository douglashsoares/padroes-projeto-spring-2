package dio.padroes_projeto_spring_2.repository;

import dio.padroes_projeto_spring_2.model.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String> {
}
