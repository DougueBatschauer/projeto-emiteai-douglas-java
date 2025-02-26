package com.project.emiteai.cadastro_pessoas.mapper;

import com.project.emiteai.cadastro_pessoas.dto.PessoaFisicaDto;
import com.project.emiteai.cadastro_pessoas.model.pessoafisica.Endereco;
import com.project.emiteai.cadastro_pessoas.model.pessoafisica.Pessoa;
import com.project.emiteai.cadastro_pessoas.model.pessoafisica.PessoaFisica;

public class PessoaFisicaMapper {

    public static PessoaFisicaDto mapToPessoaFisicaDto(final PessoaFisica pf) {
        return new PessoaFisicaDto(pf.getId(), pf.getCpf(), pf.getPessoa().getNome(),
                pf.getPessoa().getTelefone(), pf.getEndereco().getRua(),
                pf.getEndereco().getNumero(), pf.getEndereco().getComplemento(),
                pf.getEndereco().getCep(), pf.getEndereco().getBairro(),
                pf.getEndereco().getMunicipio(), pf.getEndereco().getEstado());
    }

    public static PessoaFisica mapToPessoaFisica(final PessoaFisicaDto pfDto) {
        final Pessoa pessoa = new Pessoa();
        final Endereco endereco = new Endereco();

        pessoa.setNome(pfDto.getNome());
        pessoa.setTelefone(pfDto.getTelefone());

        endereco.setBairro(pfDto.getBairro());
        endereco.setComplemento(pfDto.getComplemento());
        endereco.setCep(pfDto.getCep());
        endereco.setEstado(pfDto.getEstado());
        endereco.setMunicipio(pfDto.getMunicipio());
        endereco.setRua(pfDto.getRua());
        endereco.setNumero(pfDto.getNumero());

        return new PessoaFisica(pfDto.getId(), pfDto.getCpf(), pessoa, endereco);
    }
}
