package com.project.emiteai.cadastro_pessoas.model.pessoafisica;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
@Audited
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String rua;

    @Column
    private String numero;

    @Column
    private String complemento;

    @Column
    private String cep;

    @Column
    private String bairro;

    @Column
    private String municipio;

    @Column
    private String estado;
}
