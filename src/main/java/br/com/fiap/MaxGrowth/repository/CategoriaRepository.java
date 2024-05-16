package br.com.fiap.MaxGrowth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.MaxGrowth.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    
}
