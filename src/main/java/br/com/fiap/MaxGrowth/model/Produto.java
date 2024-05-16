package br.com.fiap.MaxGrowth.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "{produto.nome.notblank}")
    private String nome;
    @Size(min = 4, max = 60, message = "{produto.descricao.size}")
    @NotBlank(message = "{produto.descricao.notblank}")
    private String descricao;

    //pode variar de produto para produto
    private String sabor;
    
    @Positive(message = "{produto.quantidade.positive}")
    private int quantidade;

    @Positive(message = "{produto.preco.positive}")
    private Double preco;
}
