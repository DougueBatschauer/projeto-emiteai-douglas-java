package com.project.emiteai.cadastro_pessoas.service;

import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class RelatorioCsvService {

    public FileSystemResource getRelatorio(Long reportId) {
        String filePath = "reports/report_" + reportId + ".csv";
        File file = new File(filePath);

        return new FileSystemResource(file);
    }
}
