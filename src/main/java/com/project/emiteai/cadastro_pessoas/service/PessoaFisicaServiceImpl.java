package com.project.emiteai.cadastro_pessoas.service;

import com.project.emiteai.cadastro_pessoas.dto.PessoaFisicaDto;
import com.project.emiteai.cadastro_pessoas.exceptions.PessoaFisicaNaoEncontrada;
import com.project.emiteai.cadastro_pessoas.mapper.PessoaFisicaMapper;
import com.project.emiteai.cadastro_pessoas.model.pessoafisica.PessoaFisica;
import com.project.emiteai.cadastro_pessoas.repository.pessoafisica.PessoaFisicaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PessoaFisicaServiceImpl implements PessoaFisicaService {

    private final PessoaFisicaRepository pessoaFisicaRepository;

    @Override
    public PessoaFisicaDto create(PessoaFisicaDto pfDto) {
        final PessoaFisica pessoaFisica = PessoaFisicaMapper.mapToPessoaFisica(pfDto);
        final PessoaFisica pessoaFisicaSalva = pessoaFisicaRepository.save(pessoaFisica);

        return PessoaFisicaMapper.mapToPessoaFisicaDto(pessoaFisicaSalva);
    }

    @Override
    public PessoaFisicaDto getById(Long id) {
        final PessoaFisica pessoaFisica = pessoaFisicaRepository.findById(id).orElseThrow(() -> new PessoaFisicaNaoEncontrada("Pessoa Fisica Nao encontrada"));

        return PessoaFisicaMapper.mapToPessoaFisicaDto(pessoaFisica);
    }

    @Override
    public Page<PessoaFisicaDto> getAll(Pageable pageable) {
        Page<PessoaFisica> pessoaFisica = pessoaFisicaRepository.findAllByOrderByPessoa_Nome(pageable);

        List<PessoaFisicaDto> pessoaFisicaList = pessoaFisica
                .getContent()
                .stream()
                .map(PessoaFisicaMapper::mapToPessoaFisicaDto).toList();

        return new PageImpl<>(pessoaFisicaList, pageable, pessoaFisica.getTotalElements());
    }

    @Override
    public List<PessoaFisicaDto> getAll() {
        List<PessoaFisica> pessoaFisica = pessoaFisicaRepository.findAll();

        return pessoaFisica.stream().map(PessoaFisicaMapper::mapToPessoaFisicaDto).toList();
    }

    @Override
    public Page<PessoaFisicaDto> getByNome(String nome, Pageable pageable) {
        Page<PessoaFisica> pessoaFisica = pessoaFisicaRepository.findByPessoa_NomeContainingIgnoreCase(nome, pageable);

        List<PessoaFisicaDto> pessoaFisicaList = pessoaFisica
                .getContent()
                .stream()
                .map(PessoaFisicaMapper::mapToPessoaFisicaDto).toList();

        return new PageImpl<>(pessoaFisicaList, pageable, pessoaFisica.getTotalElements());
    }

    @Override
    public void delete(Long id) {
        pessoaFisicaRepository.deleteById(id);
    }

    @Override
    public void update(PessoaFisicaDto pfDto) {
        pessoaFisicaRepository.save(PessoaFisicaMapper.mapToPessoaFisica(pfDto));
    }

    @Override
    public boolean validDuplicationCpf(String cpf) {
        return pessoaFisicaRepository.existsByCpf(cpf);
    }

    @Override
    public List<String> audit(Long id) {
        return pessoaFisicaRepository.findRevisions(id)
                .stream()
                .map(Objects::toString)
                .collect(Collectors.toList());
    }
}
