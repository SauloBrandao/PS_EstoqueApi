package application.repository;

import application.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByTipo(String tipo);
    void deleteByTipo(String tipo);
}
