package com.otimotecnologia.cademp.services.impl;

import com.otimotecnologia.cademp.dtos.EmpresaDTO;
import com.otimotecnologia.cademp.dtos.FiltroDTO;
import com.otimotecnologia.cademp.dtos.ResponseDTO;
import com.otimotecnologia.cademp.entities.Empresa;
import com.otimotecnologia.cademp.repositories.EmpresaRepository;
import com.otimotecnologia.cademp.services.EmpresaService;
import com.otimotecnologia.cademp.specifications.EmpresaSpecification;
import com.otimotecnologia.cademp.utils.DTOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.Optional;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    private static final Logger log = LoggerFactory.getLogger(EmpresaServiceImpl.class);

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public ResponseDTO<EmpresaDTO> save(EmpresaDTO empresa, BindingResult result) {
        ResponseDTO<EmpresaDTO> response = new ResponseDTO<>();

        hasEmpresa(empresa, result);
        if (result.hasErrors()) {
            log.error("Erro ao Salvar Empresa: {}", result.getAllErrors());
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return response;
        } else {
            response.setData(DTOUtils.build().entityToDto(empresaRepository.save(DTOUtils.build().dtoToEntity(empresa))));
            return response;
        }
    }

    @Override
    public ResponseDTO<Page<EmpresaDTO>> findBy(FiltroDTO filtro, PageRequest pageRequest) {

        ResponseDTO<Page<EmpresaDTO>> response = new ResponseDTO<>();
        EmpresaSpecification spec = new EmpresaSpecification(filtro);
        Page<Empresa> empresas = empresaRepository.findAll(spec, pageRequest);
        Page<EmpresaDTO> empresasDTO = empresas.map(emp -> DTOUtils.build().entityToDto(emp));

        response.setData(empresasDTO);
        return response;
    }

    private void hasEmpresa(EmpresaDTO dto, BindingResult result) {
        Optional<Empresa> empresa = Optional.of(empresaRepository.findByCnpj(dto.getCnpj()));

        if (empresa.isPresent()) {
            result.addError(new ObjectError("Empresa", "Empresa já cadastrada"));
        }

    }
}
