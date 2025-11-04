package application.controller;


import application.model.Cliente;
import application.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarCliente(@RequestBody Cliente cliente) {
        clienteService.criarCliente(cliente);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deletarClientePorId(@RequestBody Long id){
        clienteService.deletarClientePorId(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Optional<Cliente> buscarClientePorId(@RequestBody Long id){
        return clienteService.buscarClientePorid(id);
    }

    @GetMapping
    @ResponseStatus
    public List<Cliente> listarTodosOsClientes() {
        return clienteService.listarTodosOsCliente();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void atualiarPorId(@RequestBody Long id, Cliente cliente){
        clienteService.atualizarPorid(id, cliente);
    }
}


