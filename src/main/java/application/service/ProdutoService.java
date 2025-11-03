package application.service;

import application.model.Produto;
import application.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Produto> listarProdutosPorTipo(String tipo) {
        return produtoRepository.findByTipo(tipo);
    }

    public Optional<Produto> buscarProdutoPorId(Long id) {
        return produtoRepository.findById(id);
    }

    public void deletarPorTipo(String tipo) {
        produtoRepository.deleteByTipo(tipo);
    }

    public Double Produto (Produto produto) {
        return produto.getPreco() * produto.getQuantidadeEstoque();
    }
}
