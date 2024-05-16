package br.com.fiap.MaxGrowth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.MaxGrowth.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
}
