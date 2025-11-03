package application.service;

import application.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;
}
