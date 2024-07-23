package dio.padroes_projeto_spring_2.controller;

import dio.padroes_projeto_spring_2.model.Cliente;
import dio.padroes_projeto_spring_2.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
public class ClienteRestController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<Iterable<Cliente>> buscarTodos(){
        return ResponseEntity.ok(clientService.buscarTodos());
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Cliente> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(clientService.bucarPorId(id));
    }
    @PostMapping
    public ResponseEntity<Cliente> inserir(@RequestBody Cliente cliente){
        clientService.inserir(cliente);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente){
        clientService.atualizar(id, cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> deletar (@PathVariable Long id){
        clientService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
