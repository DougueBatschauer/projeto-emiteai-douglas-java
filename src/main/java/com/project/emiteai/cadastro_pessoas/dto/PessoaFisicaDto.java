package com.project.emiteai.cadastro_pessoas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaFisicaDto {

    private Long id;
    private String cpf;
    private String nome;
    private String telefone;
    private String rua;
    private String numero;
    private String complemento;
    private String cep;
    private String bairro;
    private String municipio;
    private String estado;
}
