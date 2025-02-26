package com.project.emiteai.cadastro_pessoas.controller;

import com.project.emiteai.cadastro_pessoas.producer.RelatorioCsvProducer;
import com.project.emiteai.cadastro_pessoas.service.RelatorioCsvService;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@RequestMapping("/relatorio-csv")
public class RelatorioCsvController {

    private final RelatorioCsvProducer relatorioCsvProducer;
    private final RelatorioCsvService relatorioCsvService;

    public RelatorioCsvController(RelatorioCsvProducer relatorioCsvProducer, RelatorioCsvService relatorioCsvService) {
        this.relatorioCsvProducer = relatorioCsvProducer;
        this.relatorioCsvService = relatorioCsvService;
    }

    @PostMapping("/pessoa-fisica/gerar")
    public ResponseEntity<?> gerarRelatorio() {
        Long reportId = System.currentTimeMillis();
        relatorioCsvProducer.requestReport(reportId);
        return ResponseEntity.ok().body("{\"reportId\": " + reportId + "}");
    }

    @GetMapping("/pessoa-fisica/check/{relatorioId}")
    public ResponseEntity<?> checkRelatorio(@PathVariable Long relatorioId) {
        String filePath = "reports/report_" + relatorioId + ".csv";
        if (Files.exists(Paths.get(filePath))) {
            return ResponseEntity.ok().body("{\"ready\": true, \"url\": \"/reports/report_" + relatorioId + ".csv\"}");
        }
        return ResponseEntity.ok().body("{\"ready\": false}");
    }

    @GetMapping("/pessoa-fisica/get-relatorio/{reportId}")
    public ResponseEntity<FileSystemResource> getRelatorio(@PathVariable Long reportId) {
        final FileSystemResource fileSystemResource = relatorioCsvService.getRelatorio(reportId);

        if (!fileSystemResource.exists()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=report_" + reportId + ".csv");
        headers.add(HttpHeaders.CONTENT_TYPE, "text/csv");

        return ResponseEntity.ok()
                .headers(headers)
                .body(fileSystemResource);
    }
}
