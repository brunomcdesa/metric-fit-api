package org.metricfit.com.br.metricfit.modulos.usuario.repository;

import org.metricfit.com.br.metricfit.modulos.usuario.model.UsuarioHistorico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioHistoricoRepository extends JpaRepository<UsuarioHistorico, Integer>,
    QuerydslPredicateExecutor<UsuarioHistorico> {
}
