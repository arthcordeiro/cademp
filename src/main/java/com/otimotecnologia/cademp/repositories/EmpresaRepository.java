package com.otimotecnologia.cademp.repositories;

import com.otimotecnologia.cademp.dtos.FiltroDTO;
import com.otimotecnologia.cademp.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import javax.transaction.Transactional;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>, JpaSpecificationExecutor<Empresa> {

    @Transactional
    Empresa findByCnpj(String cnpj);
}
