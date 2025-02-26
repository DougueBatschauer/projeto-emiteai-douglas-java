package com.project.emiteai.cadastro_pessoas.consumer;

import com.opencsv.CSVWriter;
import com.project.emiteai.cadastro_pessoas.dto.PessoaFisicaDto;
import com.project.emiteai.cadastro_pessoas.service.PessoaFisicaService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RelatorioCsvConsumer {

    private final PessoaFisicaService pessoaFisicaService;

    @RabbitListener(queues = "pessoa-fisica-relatorio-queue")
    public void generateReport(Long reportId) {
        try {
            List<PessoaFisicaDto> pessoaFisicaList = pessoaFisicaService.getAll();

            String folderPath = "reports";
            File directory = new File(folderPath);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            String filePath = folderPath + "/report_" + reportId + ".csv";

            CSVWriter writer = new CSVWriter(new FileWriter(filePath));
            writer.writeNext(new String[]{"Id", "CPF", "Nome"
                    ,"Municipio", "Telefone", "Rua"
                    ,"Numero", "Complemento", "CEP"
                    ,"Bairro", "Estado"});

            for (PessoaFisicaDto pessoaFisica : pessoaFisicaList) {
                writer.writeNext(new String[]{pessoaFisica.getId().toString(), pessoaFisica.getCpf(), pessoaFisica.getNome()
                        , pessoaFisica.getMunicipio(), pessoaFisica.getTelefone(), pessoaFisica.getRua()
                        , pessoaFisica.getNumero(), pessoaFisica.getComplemento(), pessoaFisica.getCep()
                        , pessoaFisica.getBairro(), pessoaFisica.getEstado()});
            }

            writer.close();
            System.out.println("Relatório gerado: " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
