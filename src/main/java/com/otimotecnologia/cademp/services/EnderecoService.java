package com.otimotecnologia.cademp.services;

import com.otimotecnologia.cademp.dtos.ResponseDTO;
import com.otimotecnologia.cademp.dtos.ViaCepDTO;

public interface EnderecoService {

    /**
     * Obtem o endereço a partir do cep utilizando WS do ViaCep
     *
     * @param cep
     * @return ResponseDTO<ViaCepDTO>
     */
    ResponseDTO<ViaCepDTO> getEndereco(String cep);
}
