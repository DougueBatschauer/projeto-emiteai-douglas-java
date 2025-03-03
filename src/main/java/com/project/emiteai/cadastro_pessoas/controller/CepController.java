package com.project.emiteai.cadastro_pessoas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/cep/")
@CrossOrigin(origins = "*")
public class CepController {

    @GetMapping("/get-cep/{cep}")
    public ResponseEntity<String> getCep(@PathVariable String cep) {
        final RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = restTemplate.getForEntity("https://viacep.com.br/ws/"+cep+"/json/", String.class);

        return ResponseEntity.ok(response.getBody());
    }
}
