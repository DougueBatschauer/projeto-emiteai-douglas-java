package com.project.emiteai.cadastro_pessoas.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RelatorioCsvProducer {

    private final RabbitTemplate rabbitTemplate;
    private final String QUEUE_NAME = "pessoa-fisica-relatorio-queue";

    public void requestReport(Long reportId) {
        rabbitTemplate.convertAndSend(QUEUE_NAME, reportId);
    }
}
