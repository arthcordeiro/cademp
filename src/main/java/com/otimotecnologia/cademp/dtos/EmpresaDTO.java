package com.otimotecnologia.cademp.dtos;

import com.otimotecnologia.cademp.enums.TipoEmpresa;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class EmpresaDTO {


    private Long id;
    @NotEmpty(message = "CNPJ não pode ser nulo.")
    @CNPJ(message = "CNPJ inválido")
    private String cnpj;
    @NotEmpty(message = "O nome da empresa não pode ser nulo.")
    @Length(max = 50, message = "O nome da empresa deve ter no máximo 50 caracteres")
    private String nomeEmpresa;
    @NotEmpty(message = "O tipo da empresa não pode ser nulo.")
    @Length(max = 6, message = "O tipo da empresa deve ter no máximo 6 caracteres")
    private TipoEmpresa tipoEmpresa;
    @NotEmpty(message = "A razão social não pode ser nula.")
    @Length(max = 40, message = "O razão social deve ter no máximo 40 caracteres")
    private String razaoSocial;
    @NotEmpty(message = "O contato não pode ser nulo.")
    @Length(max = 40, message = "O razão social deve ter no máximo 40 caracteres")
    private String contato;
    @NotEmpty(message = "E-mail não pode ser nulo.")
    @Length(max = 40, message = "O E-mail deve ter no máximo 40 caracteres")
    @Email(message = "E-mail inválido.")
    private String email;
    @NotEmpty(message = "O CEP não pode ser nulo.")
    @Length(min = 8, max = 8, message = "O CEP deve ter 8 caracteres")
    private String cep;
    @NotEmpty(message = "O estado não pode ser nulo.")
    @Length(max = 40, message = "O estado deve ter no máximo 40 caracteres")
    private String estado;
    @NotEmpty(message = "O bairro não pode ser nulo.")
    @Length(max = 40, message = "O bairro deve ter no máximo 40 caracteres")
    private String bairro;
    @NotEmpty(message = "A cidade não pode ser nulo.")
    @Length(max = 40, message = "A cidade deve ter no máximo 40 caracteres")
    private String cidade;
    @NotEmpty(message = "O logradouro não pode ser nulo.")
    @Length(max = 40, message = "O logradouro deve ter no máximo 40 caracteres")
    private String logradouro;
    @Length(max = 40, message = "O complemento deve ter no máximo 40 caracteres")
    private String complemento;
    private Date createdOn;


    public EmpresaDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public TipoEmpresa getTipoEmpresa() {
        return tipoEmpresa;
    }

    public void setTipoEmpresa(TipoEmpresa tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}
