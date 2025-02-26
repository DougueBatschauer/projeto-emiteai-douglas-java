package com.project.emiteai.cadastro_pessoas.controller;

import com.project.emiteai.cadastro_pessoas.dto.PessoaFisicaDto;
import com.project.emiteai.cadastro_pessoas.service.PessoaFisicaService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/pessoa-fisica")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PessoaFisicaController {

    private final PessoaFisicaService pessoaFisicaService;

    @PostMapping
    public ResponseEntity<PessoaFisicaDto> create(@RequestBody PessoaFisicaDto pfDto) {
        final PessoaFisicaDto pessoaFisicaDto = pessoaFisicaService.create(pfDto);

        return new ResponseEntity<>(pessoaFisicaDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<PessoaFisicaDto>> getAll(Pageable pageable) {
        final Page<PessoaFisicaDto> pfDto = pessoaFisicaService.getAll(pageable);

        return new ResponseEntity<>(pfDto, HttpStatus.OK);
    }

    @GetMapping("/filter/{name}")
    public ResponseEntity<Page<PessoaFisicaDto>> getByName(@PathVariable("name") String name, Pageable pageable) {
        final Page<PessoaFisicaDto> pfDto = pessoaFisicaService.getByNome(name, pageable);

        return new ResponseEntity<>(pfDto, HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<PessoaFisicaDto> getById(@PathVariable("id") Long id) {
        final PessoaFisicaDto pessoaFisicaDto = pessoaFisicaService.getById(id);

        return new ResponseEntity<>(pessoaFisicaDto, HttpStatus.OK);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        pessoaFisicaService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<PessoaFisicaDto> update(@RequestBody PessoaFisicaDto pfDto) {
        pessoaFisicaService.update(pfDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/valid-cpf/{cpf}")
    public ResponseEntity<Boolean> validCpf(@PathVariable("cpf") String cpf) {
        return new ResponseEntity<>(pessoaFisicaService.validDuplicationCpf(cpf), HttpStatus.OK);
    }

    @GetMapping("/audit/{id}")
    public ResponseEntity<List<String>> audit(@PathVariable("id") Long id) {
        final List<String> auditsPessoaFisica = pessoaFisicaService.audit(id);
        return new ResponseEntity<>(auditsPessoaFisica, HttpStatus.OK);
    }
}
