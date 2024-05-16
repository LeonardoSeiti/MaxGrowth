package br.com.fiap.MaxGrowth.controller;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.MaxGrowth.model.Produto;
import br.com.fiap.MaxGrowth.repository.ProdutoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("produto")
@Tag(name = "Produto")
public class ProdutoController {

    @Autowired
    ProdutoRepository repository;

    @GetMapping
    @Operation(
        summary = "Listar todos os produtos",
        description = "Retorna uma lista com todos os produtos cadastrados")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Produtos listados com sucesso"),
        @ApiResponse(responseCode = "404", description = "Nenhum produto encontrado")
    })
    public List<Produto> index() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    @Operation(
        summary = "Cadastrar produto",
        description = "Cadastra um novo produto")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Produto cadastrado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Erro de validação")
    })
    public Produto create(@RequestBody @Valid Produto produto) {
        return repository.save(produto);

    }

}
