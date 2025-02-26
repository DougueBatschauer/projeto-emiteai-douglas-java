package com.project.emiteai.cadastro_pessoas.service;

import com.project.emiteai.cadastro_pessoas.dto.PessoaFisicaDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PessoaFisicaService {

    PessoaFisicaDto create(PessoaFisicaDto pfDto);
    PessoaFisicaDto getById(Long id);
    Page<PessoaFisicaDto> getAll(Pageable pageable);
    List<PessoaFisicaDto> getAll();
    Page<PessoaFisicaDto> getByNome(String nome, Pageable pageable);
    void delete(Long id);
    void update(PessoaFisicaDto pfDto);
    boolean validDuplicationCpf(String cpf);
    List<String> audit(Long id);
}
