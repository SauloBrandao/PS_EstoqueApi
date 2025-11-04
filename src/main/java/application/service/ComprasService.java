package application.service;


import application.model.Compras;
import application.repository.ComprasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComprasService {

    @Autowired
    ComprasRepository comprasRepository;

    public void registrarCompra(Compras compras) {
        comprasRepository.save(compras);
    }

    public List<Compras> listarTodasAsCompras(){
        return comprasRepository.findAll();
    }

    public Optional<Compras> buscarCompraPorId(Long id){
        return comprasRepository.findById(id);
    }
}
