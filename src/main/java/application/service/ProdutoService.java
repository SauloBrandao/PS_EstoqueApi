package application.service;

import application.model.Produto;
import application.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public void criarProduto(Produto produto) {
        produtoRepository.save(produto);
    }

    public List<Produto> listarTodosProdutos(){
        return produtoRepository.findAll();
    }

    public Optional<Produto> listarProdutosPorTipo(String tipo) {
        return produtoRepository.findByTipo(tipo);
    }

    public Optional<Produto> buscarProdutoPorId(Long id) {
        return produtoRepository.findById(id);
    }

    public void deletarPorTipo(String tipo) {
        produtoRepository.deleteByTipo(tipo);
    }

    public void deletarPorId(Long id){
        produtoRepository.deleteById(id);
    }

    public Double valorTotal (Produto produto) {
        return produto.getPreco() * produto.getQuantidadeEstoque();
    }

    public void atualizarPorId(Produto produto, Long id){
       Optional<Produto> ProdutoBD = buscarProdutoPorId(id);

       if (ProdutoBD.isEmpty()) {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado!");
       }

       Produto produtoEditado = ProdutoBD.get();

       produtoEditado.setNome(produto.getNome());
       produtoEditado.setTipo(produto.getTipo());
       produtoEditado.setPreco(produto.getPreco());
       produtoEditado.setQuantidadeEstoque(produto.getQuantidadeEstoque());

       produtoRepository.save(produtoEditado);
    }

}
