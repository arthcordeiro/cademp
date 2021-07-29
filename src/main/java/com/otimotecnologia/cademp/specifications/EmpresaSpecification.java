package com.otimotecnologia.cademp.specifications;

import com.otimotecnologia.cademp.dtos.FiltroDTO;
import com.otimotecnologia.cademp.entities.Empresa;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class EmpresaSpecification implements Specification<Empresa> {

    private FiltroDTO filtro;

    public EmpresaSpecification(FiltroDTO filtro) {
        this.filtro = filtro;
    }

    @Override
    public Predicate toPredicate(Root<Empresa> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        final List<Predicate> predicates = new ArrayList<>();

        if (filtro.getCnpj() != null) {
            predicates.add(criteriaBuilder.equal(root.get("cnpj"), filtro.getCnpj()));
        }
        if (filtro.getTipoEmpresa() != null) {
            predicates.add(criteriaBuilder.equal(root.get("tipoEmpresa"), filtro.getTipoEmpresa()));
        }
        if (filtro.getNomeEmpresa() != null) {
            predicates.add(criteriaBuilder.like( criteriaBuilder.function("unaccent", String.class, criteriaBuilder.lower(root.get("nomeEmpresa"))),
                    "%" + filtro.getNomeEmpresa().toLowerCase(Locale.ROOT) +"%"));
        }
        if (filtro.getCep() != null) {
            predicates.add(criteriaBuilder.equal(root.get("cep"), filtro.getCep()));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}
