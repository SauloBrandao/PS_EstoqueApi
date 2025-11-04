package application.controller;

import application.model.Produto;
import application.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @DeleteMapping("tipo")
    @ResponseStatus(HttpStatus.OK)
    public void deletarProdutoPorTipo(@RequestBody String tipo) {
        produtoService.deletarPorTipo(tipo);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> listarTodosProdutos() {
        return produtoService.listarTodosProdutos();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Optional<Produto> listarPorTido(@RequestBody String tipo) {
        return produtoService.listarProdutosPorTipo(tipo);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Optional<Produto> buscarProdutoPorId(@RequestBody Long id) {
        return produtoService.buscarProdutoPorId(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Double valorTotalEstoque(@RequestBody Long id){
        return produtoService.valorTotalEstoque(id);
    }


    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void atualizarProdutoPorId(@RequestBody Produto produto, Long id){
        produtoService.atualizarPorId(produto, id);
    }

}
