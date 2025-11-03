package application.service;


import application.model.Compras;
import application.repository.ComprasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComprasService {

    @Autowired
    ComprasRepository comprasRepository;

    public void registrarCompra(Compras compras) {
        comprasRepository.save(compras);
    }
}
