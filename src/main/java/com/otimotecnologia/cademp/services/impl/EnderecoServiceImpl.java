package com.otimotecnologia.cademp.services.impl;

import com.otimotecnologia.cademp.dtos.ResponseDTO;
import com.otimotecnologia.cademp.dtos.ViaCepDTO;
import com.otimotecnologia.cademp.services.EnderecoService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnderecoServiceImpl implements EnderecoService {
    @Override
    public ResponseDTO<ViaCepDTO> getEndereco(String cep) {

        ResponseDTO<ViaCepDTO> response = new ResponseDTO<>();

        WebClient client = WebClient.create("https://viacep.com.br/ws/"+cep+"/json/");

        ViaCepDTO dto = new ViaCepDTO();

        dto = client.get()
                .retrieve()
                .bodyToMono(ViaCepDTO.class)
                .block();

        response.setData(dto);

        return response;
    }
}
