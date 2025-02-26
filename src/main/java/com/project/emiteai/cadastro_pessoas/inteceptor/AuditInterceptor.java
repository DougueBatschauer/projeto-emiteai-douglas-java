package com.project.emiteai.cadastro_pessoas.inteceptor;

import com.project.emiteai.cadastro_pessoas.model.audit.AuditLog;
import com.project.emiteai.cadastro_pessoas.repository.audit.AuditLogRepository;
import com.project.emiteai.cadastro_pessoas.wrapper.RequestWrapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import java.time.LocalDateTime;

@Component
public class AuditInterceptor implements HandlerInterceptor {

    private final AuditLogRepository auditLogRepository;

    public AuditInterceptor(AuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        request.setAttribute("startTime", System.currentTimeMillis());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        long startTime = (long) request.getAttribute("startTime");
        long duration = System.currentTimeMillis() - startTime;

        String requestBody = "";
        if (request instanceof RequestWrapper wrappedRequest) {
            requestBody = wrappedRequest.getBody();
        }

        AuditLog auditLog = new AuditLog();
        auditLog.setMethod(request.getMethod());
        auditLog.setUrl(request.getRequestURI());
        auditLog.setStatus(response.getStatus());
        auditLog.setDuration(duration);
        auditLog.setTimestamp(LocalDateTime.now());
        auditLog.setPayload(requestBody);

        if (ex != null) {
            auditLog.setError(ex.getMessage());
        }

        auditLogRepository.save(auditLog);
    }
}
