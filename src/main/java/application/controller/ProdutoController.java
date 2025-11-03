package application.controller;

import application.model.Produto;
import application.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarProduto(@RequestBody Produto produto) {
        produtoService.criarProduto(produto);
    }

    @DeleteMapping("id")
    @ResponseStatus(HttpStatus.OK)
    public void deletarProdutoPorId(@RequestBody Long id){
        produtoService.deletarPorId(id);
    }

}
