package com.otimotecnologia.cademp.controllers;

import com.otimotecnologia.cademp.dtos.ResponseDTO;
import com.otimotecnologia.cademp.dtos.ViaCepDTO;
import com.otimotecnologia.cademp.services.EnderecoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/enderecos")
public class EnderecoController {

    private static final Logger log = LoggerFactory.getLogger(EnderecoController.class);

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping(value = "/{cep}")
    public ResponseEntity<ResponseDTO<ViaCepDTO>> getEndereco(@PathVariable("cep") String cep) {
        log.info("Buscando endereço a partir do cep "+cep);
        ResponseDTO<ViaCepDTO> response = enderecoService.getEndereco(cep);
        if (response.getErrors().size() > 0) {
            return ResponseEntity.badRequest().body(response);
        } else {
            return ResponseEntity.ok(response);
        }
    }
}
