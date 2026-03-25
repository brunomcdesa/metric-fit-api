package org.metricfit.com.br.metricfit.modulos.usuario.service;

import lombok.RequiredArgsConstructor;
import org.metricfit.com.br.metricfit.modulos.comum.exception.NotFoundException;
import org.metricfit.com.br.metricfit.modulos.usuario.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;

    public UserDetails findByUsername(String username) {
        return repository.findByUsername(username)
            .orElseThrow(() -> new NotFoundException("Usuário não encontrado."));
    }
}
