package com.project.emiteai.cadastro_pessoas.model.audit;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "audit_logs")
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String method;
    private String url;
    private int status;
    private long duration;
    private String payload;
    private String response;
    private String error;
    private LocalDateTime timestamp;
}
