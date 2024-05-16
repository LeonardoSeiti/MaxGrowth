package br.com.fiap.MaxGrowth.controller;

import java.util.List;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import br.com.fiap.MaxGrowth.model.Categoria;
import br.com.fiap.MaxGrowth.repository.CategoriaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("categoria")
@Slf4j
@CacheConfig(cacheNames = "categorias")//cache de forma global
@Tag(name = "Categoria")

public class CategoriaController {
    @Autowired
    CategoriaRepository repository;

    @GetMapping
    @Cacheable
    @Operation(
        summary = "Listar todas as categorias",
        description = "Retorna uma lista com todas as categorias cadastradas"
        )
    public List<Categoria> index() {
        return repository.findAll();
    }

    @PostMapping
    @CacheEvict(allEntries = true)
    @ResponseStatus(CREATED)
    @Operation(
        summary = "Cadastrar categoria",
        description = "Cadastra uma nova categoria"
        )
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Categoria cadastrada com sucesso"),
        @ApiResponse(responseCode = "400", description = "Erro de validação")
    })
    public Categoria create(@RequestBody @Valid Categoria categoria) {
        log.info("cadastro categoria {}", categoria);
        return repository.save(categoria);
    }

    @GetMapping("{id}")
    @Operation(
        summary = "Buscar categoria por id",
        description = "Retorna uma categoria específica de acordo com o id informado"
        )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Categoria encontrada"),
        @ApiResponse(responseCode = "404", description = "Categoria não encontrada, id inexistente")
    })
    public ResponseEntity<Categoria> show(@PathVariable Long id) {
        log.info("buscando categoria com id {} ", id);

        return repository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    @Operation(
        summary = "Deletar categoria",
        description = "Deleta uma categoria de acordo com o id informado"
        )
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Categoria deletada com sucesso"),
        @ApiResponse(responseCode = "404", description = "Categoria não encontrada, id inexistente")
    })
    @ResponseStatus(NO_CONTENT)
    @CacheEvict(allEntries = true)
    public void destroy(@PathVariable Long id) {
        log.info("apagando categoria {}", id);

        verificarSeCategoriaExiste(id);
        repository.deleteById(id);
    }
    @Operation(
        summary = "Atualizar categoria",
        description = "Atualiza uma categoria de acordo com o id informado"
        )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Categoria atualizada com sucesso"),
        @ApiResponse(responseCode = "404", description = "Categoria não encontrada, id inexistente")
    })
    @PutMapping("{id}")
    @CacheEvict(allEntries = true)
    public Categoria update(@PathVariable Long id, @RequestBody Categoria categoria) {
        log.info("Atualizando categoria {} para {} ", id, categoria);

        verificarSeCategoriaExiste(id);
        categoria.setId(id);
        return repository.save(categoria);

    }

    private void verificarSeCategoriaExiste(Long id) {
        repository
                .findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(
                                NOT_FOUND,
                                "Não existe categoria com id informado"));
    }
}