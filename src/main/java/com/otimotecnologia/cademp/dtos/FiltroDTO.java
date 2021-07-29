package com.otimotecnologia.cademp.dtos;

import com.otimotecnologia.cademp.enums.TipoEmpresa;

public class FiltroDTO {

    private String cnpj;
    private TipoEmpresa tipoEmpresa;
    private String nomeEmpresa;
    private String cep;

    public FiltroDTO() {}

    public FiltroDTO(String cnpj, TipoEmpresa tipoEmpresa, String nomeEmpresa, String cep) {
        this.cnpj = cnpj;
        this.tipoEmpresa = tipoEmpresa;
        this.nomeEmpresa = nomeEmpresa;
        this.cep = cep;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public TipoEmpresa getTipoEmpresa() {
        return tipoEmpresa;
    }

    public void setTipoEmpresa(TipoEmpresa tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
