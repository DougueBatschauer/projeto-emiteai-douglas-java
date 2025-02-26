package com.project.emiteai.cadastro_pessoas.config;

import com.project.emiteai.cadastro_pessoas.inteceptor.AuditInterceptor;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import org.springframework.context.annotation.Bean;

@Configuration
@EnableWebMvc
public class ApiConfig implements WebMvcConfigurer {

    private final AuditInterceptor auditInterceptor;

    public ApiConfig(AuditInterceptor auditInterceptor) {
        this.auditInterceptor = auditInterceptor;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("GET", "POST");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(auditInterceptor);
    }
}

