package com.otimotecnologia.cademp.controllers;

import com.otimotecnologia.cademp.dtos.ResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/health-check")
public class HealthCheckController {
    private static final Logger log = LoggerFactory.getLogger(HealthCheckController.class);
    @GetMapping
    public ResponseEntity<ResponseDTO<String>> healthCheck() {
        log.info("Chamada para verificação do serviço UP");
        ResponseDTO<String> response = new ResponseDTO<String>();
        response.setData("Work It!");
        return ResponseEntity.ok(response);
    }
}
