package com.project.emiteai.cadastro_pessoas.repository.pessoafisica;

import com.project.emiteai.cadastro_pessoas.model.pessoafisica.PessoaFisica;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

public interface PessoaFisicaRepository extends
        JpaRepository<PessoaFisica, Long>,
        RevisionRepository<PessoaFisica, Long, Long> {
    boolean existsByCpf(String cpf);
    Page<PessoaFisica> findAllByOrderByPessoa_Nome(Pageable pageable);
    Page<PessoaFisica> findByPessoa_NomeContainingIgnoreCase(String nome, Pageable pageable);
}
