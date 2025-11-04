package application.controller;


import application.model.Compras;
import application.service.ComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/compras")
public class ComprasController {

    @Autowired
    ComprasService comprasService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void registrarCompra(@RequestBody Compras compras) {
        comprasService.registrarCompra(compras);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Compras> listarTodasCompras(){
        return comprasService.listarTodasAsCompras();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Optional<Compras> buscarComprasPorid(@RequestBody Long id){
        return buscarComprasPorid(id);
    }
}
