package com.project.emiteai.cadastro_pessoas.repository.audit;

import com.project.emiteai.cadastro_pessoas.model.audit.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
}