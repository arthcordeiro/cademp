package com.otimotecnologia.cademp.controllers;

import com.otimotecnologia.cademp.dtos.EmpresaDTO;
import com.otimotecnologia.cademp.dtos.FiltroDTO;
import com.otimotecnologia.cademp.dtos.ResponseDTO;
import com.otimotecnologia.cademp.enums.TipoEmpresa;
import com.otimotecnologia.cademp.services.EmpresaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/v1/empresas")
public class EmpresasController {

    private static final Logger log = LoggerFactory.getLogger(EmpresasController.class);

    @Autowired
    private EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<ResponseDTO<EmpresaDTO>> save(@Valid @RequestBody EmpresaDTO empresaDTO, BindingResult result) {
        log.info("Inserindo a empresa "+empresaDTO.getNomeEmpresa()+" no banco de dados");
        ResponseDTO<EmpresaDTO> response = new ResponseDTO();

        response = empresaService.save(empresaDTO, result);

        if (response.getErrors().size() > 0) {
            return ResponseEntity.badRequest().body(response);
        } else {
            return ResponseEntity.created(URI.create("/v1/empresas/"+response.getData().getId())).build();
        }
    }

    @GetMapping
    public ResponseEntity<ResponseDTO<Page<EmpresaDTO>>> getByFilter(@RequestParam(value = "tipo_empresa", required = false) TipoEmpresa tipoEmpresa,
                                                                     @RequestHeader(value = "cnpj", required = false) String cnpj,
                                                                     @RequestParam(value = "nome_empresa", required = false) String nomeEmpresa,
                                                                     @RequestParam(value = "cep", required = false) String cep,
                                                                     @RequestParam(value = "_limit", defaultValue = "0") int limit,
                                                                     @RequestParam(value = "_offset", defaultValue = "id") String offset) {
        FiltroDTO filtro = new FiltroDTO(cnpj, tipoEmpresa, nomeEmpresa, cep);
        ResponseDTO<Page<EmpresaDTO>> response = empresaService.findBy()
        return null;
    }

}
