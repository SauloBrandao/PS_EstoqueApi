package application.model;


import application.enums.AprovacaoStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Compras implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valorTotal;

    private Integer quantidade;

    @Enumerated(EnumType.STRING)
    private AprovacaoStatus status;

    @ManyToMany
    @JoinTable(
            name = "compra_produto",
            joinColumns = @JoinColumn(name = "compra_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<Produto> produtos;


    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
