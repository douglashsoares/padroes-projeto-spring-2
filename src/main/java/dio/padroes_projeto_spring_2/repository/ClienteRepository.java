package dio.padroes_projeto_spring_2.repository;

import dio.padroes_projeto_spring_2.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
