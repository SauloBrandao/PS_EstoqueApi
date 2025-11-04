package application.service;

import application.model.Cliente;
import application.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public void criarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public void deletarClientePorId(Long id) {
        clienteRepository.deleteById(id);
    }

    public Optional<Cliente> buscarClientePorid(Long id) {
        return clienteRepository.findById(id);
    }

    public List<Cliente> listarTodosOsCliente(){
        return clienteRepository.findAll();
    }

    public void atualizarPorid(Long id, Cliente cliente){
        Optional<Cliente> clienteDoDb = buscarClientePorid(id);

        if (clienteDoDb.isEmpty()) throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "CLIENTE NAO ENCONTRADO");

        Cliente clienteEditado = clienteDoDb.get();

        clienteEditado.setNome(cliente.getNome());
        clienteEditado.setEmail(cliente.getEmail());
        clienteEditado.setCpf(cliente.getCpf());

        clienteRepository.save(clienteEditado);
    }
}
