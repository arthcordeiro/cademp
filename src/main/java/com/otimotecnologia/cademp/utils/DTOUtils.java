package com.otimotecnologia.cademp.utils;

import com.otimotecnologia.cademp.dtos.EmpresaDTO;
import com.otimotecnologia.cademp.entities.Empresa;
import org.modelmapper.ModelMapper;

public class DTOUtils {

    private ModelMapper modelMapper;

    public DTOUtils () {
        this.modelMapper = new ModelMapper();
    }

    public static final DTOUtils build() {
        return new DTOUtils();
    }

    public Empresa dtoToEntity(EmpresaDTO dto) {
        return modelMapper.map(dto, Empresa.class);
    }

    public EmpresaDTO entityToDto(Empresa empresa) {
        return modelMapper.map(empresa, EmpresaDTO.class);
    }
}
