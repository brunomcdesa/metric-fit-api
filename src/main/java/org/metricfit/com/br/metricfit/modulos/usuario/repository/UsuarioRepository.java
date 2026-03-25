package org.metricfit.com.br.metricfit.modulos.usuario.repository;

import org.metricfit.com.br.metricfit.modulos.usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>, QuerydslPredicateExecutor<Usuario> {

    Optional<UserDetails> findByUsername(String username);
}
