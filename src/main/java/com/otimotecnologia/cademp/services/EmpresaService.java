package com.otimotecnologia.cademp.services;

import com.otimotecnologia.cademp.dtos.EmpresaDTO;
import com.otimotecnologia.cademp.dtos.FiltroDTO;
import com.otimotecnologia.cademp.dtos.ResponseDTO;
import com.otimotecnologia.cademp.entities.Empresa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;


public interface EmpresaService {

    /**
     * Persiste empresa no banco de dados
     *
     * @param empresa
     * @return ResponseDTO<Empresa>
     */
    ResponseDTO<EmpresaDTO> save(EmpresaDTO empresa, BindingResult result);

    /**
     * Retorna uma lista de empresas com base em um filtro especificado
     *
     * @param filtro
     * @return ResponseDTO<Empresa>
     */
    ResponseDTO<Page<EmpresaDTO>> findBy(FiltroDTO filtro, PageRequest pageRequest);
}
