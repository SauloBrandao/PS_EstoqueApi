package application.controller;

import application.model.Produto;
import application.service.ProdutoService;
import jakarta.validation.Valid;
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
    public void criarProduto(@Valid @RequestBody Produto produto) {
        produtoService.criarProduto(produto);
    }

    @DeleteMapping("id")
    @ResponseStatus(HttpStatus.OK)
    public void deletarProdutoPorId(@PathVariable @Valid @RequestBody Long id){
        produtoService.deletarPorId(id);
    }

    @DeleteMapping("tipo")
    @ResponseStatus(HttpStatus.OK)
    public void deletarProdutoPorTipo(@PathVariable @Valid @RequestBody String tipo) {
        produtoService.deletarPorTipo(tipo);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> listarTodosProdutos() {
        return produtoService.listarTodosProdutos();
    }

    @GetMapping("{tipo}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Produto> listarPorTido(@PathVariable @Valid @RequestBody String tipo) {
        return produtoService.listarProdutosPorTipo(tipo);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Produto> buscarProdutoPorId(@PathVariable @Valid @RequestBody Long id) {
        return produtoService.buscarProdutoPorId(id);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Double valorTotalEstoque(@PathVariable @Valid @RequestBody Long id){
        return produtoService.valorTotalEstoque(id);
    }


    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void atualizarProdutoPorId(@Valid @RequestBody Produto produto, Long id){
        produtoService.atualizarPorId(produto, id);
    }

}
