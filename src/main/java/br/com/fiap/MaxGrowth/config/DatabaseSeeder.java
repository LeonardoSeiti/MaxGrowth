package br.com.fiap.MaxGrowth.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.fiap.MaxGrowth.model.Categoria;
import br.com.fiap.MaxGrowth.model.Produto;
import br.com.fiap.MaxGrowth.repository.CategoriaRepository;
import br.com.fiap.MaxGrowth.repository.ProdutoRepository;
@Configuration
@Profile("dev")
public class DatabaseSeeder implements CommandLineRunner {
    @Autowired
    CategoriaRepository categoriaRepository;
    
    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public void run(String... args) throws Exception {
        categoriaRepository.saveAll(
            List.of(
                Categoria.builder().tipo("Proteinas").icon("beef").build(),
                Categoria.builder().tipo("Aminoacidos").icon("").build(),
                Categoria.builder().tipo("Acessórios").icon("dumbell").build()
            )
        
        );
        produtoRepository.saveAll(
            List.of(
                Produto.builder().nome("Whey Protein").descricao("Proteina de alto valor biológico").sabor("Morango").quantidade(10).preco(100.0).build(),
                Produto.builder().nome("Whey Protein").descricao("Proteina de alto valor biológico").sabor("Chocolate").quantidade(10).preco(100.0).build(),
                Produto.builder().nome("Whey Protein").descricao("Proteina de alto valor biológico").sabor("Banana").quantidade(10).preco(100.0).build(),
                Produto.builder().nome("Whey Protein").descricao("Proteina de alto valor biológico").sabor("Baunilha").quantidade(10).preco(100.0).build(),
                Produto.builder().nome("Whey Protein").descricao("Proteina de alto valor biológico").sabor("Cappuccino").quantidade(10).preco(100.0).build(),
                Produto.builder().nome("Whey Protein").descricao("Proteina de alto valor biológico").sabor("Chocolate Branco").quantidade(10).preco(100.0).build(),
                Produto.builder().nome("Whey Protein").descricao("Proteina de alto valor biológico").sabor("Avelã").quantidade(10).preco(100.0).build(),
                Produto.builder().nome("Whey Protein").descricao("Proteina de alto valor biológico").sabor("Paçoca").quantidade(10).preco(100.0).build(),
                Produto.builder().nome("Whey Protein").descricao("Proteina de alto valor biológico").sabor("Amendoim").quantidade(10).preco(100.0).build(),
                Produto.builder().nome("Whey Protein").descricao("Proteina de alto valor biológico").sabor("Beijinho").quantidade(10).preco(100.0).build(),
                Produto.builder().nome("Whey Protein").descricao("Proteina de alto valor biológico").sabor("Morango com chocolate").quantidade(10).preco(100.0).build(),
                Produto.builder().nome("Whey Protein").descricao("Proteina de alto valor biológico").sabor("Coco ralado").quantidade(10).preco(100.0).build(),
                Produto.builder().nome("Whey Protein").descricao("Proteina de alto valor biológico").sabor("Natural").quantidade(10).preco(100.0).build(),
                Produto.builder().nome("Whey Protein").descricao("Proteina de alto valor biológico").sabor("Caramelo").quantidade(10).preco(100.0).build(),
                Produto.builder().nome("Creatina").descricao("Aminoácido essencial").sabor("Sem sabor").quantidade(10).preco(50.0).build(),
                Produto.builder().nome("Coqueteleira").descricao("Coqueteleira de 500ml").quantidade(10).preco(10.0).build(),
                Produto.builder().nome("Coqueteleira").descricao("Coqueteleira de 2L Azul").quantidade(10).preco(10.0).build(),
                Produto.builder().nome("Coqueteleira").descricao("Coqueteleira de 2L Preta").quantidade(10).preco(10.0).build()
            )
        );
        
    }
}
