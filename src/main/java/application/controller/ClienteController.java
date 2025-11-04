package application.controller;


import application.model.Cliente;
import application.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> criarCliente(@Valid @RequestBody Cliente cliente) {
        Cliente novoCliente = clienteService.criarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deletarClientePorId(@Valid @RequestBody Long id){
        clienteService.deletarClientePorId(id);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Optional<Cliente> buscarClientePorId(@PathVariable @Valid @RequestBody Long id){
        return clienteService.buscarClientePorid(id);
    }

    @GetMapping
    @ResponseStatus
    public List<Cliente> listarTodosOsClientes() {
        return clienteService.listarTodosOsCliente();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void atualiarPorId(@Valid @RequestBody Long id, Cliente cliente){
        clienteService.atualizarPorid(id, cliente);
    }
}


