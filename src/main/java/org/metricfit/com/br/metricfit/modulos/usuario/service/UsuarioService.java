package org.metricfit.com.br.metricfit.modulos.usuario.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.metricfit.com.br.metricfit.modulos.comum.enums.EAcao;
import org.metricfit.com.br.metricfit.modulos.comum.exception.NotFoundException;
import org.metricfit.com.br.metricfit.modulos.usuario.model.Usuario;
import org.metricfit.com.br.metricfit.modulos.usuario.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import static org.metricfit.com.br.metricfit.modulos.comum.enums.EAcao.ALTERACAO_SENHA;

@Slf4j
@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;
    private final UsuarioHistoricoService usuarioHistoricoService;

    public UserDetails findByUsername(String username) {
        return repository.findByUsername(username)
            .orElseThrow(() -> new NotFoundException("Usuário não encontrado."));
    }

    public void atualizarSenha(Usuario usuario, String senha) {
        usuario.alterarSenha(senha);
        this.salvarComHistorico(usuario, null, ALTERACAO_SENHA);
    }

    private void salvarComHistorico(Usuario usuario, Usuario usuarioAutenticado, EAcao acao) {
        repository.save(usuario);
        usuarioHistoricoService.salvar(usuario, usuarioAutenticado, acao);
        log.info("Usuario salvo com sucesso: {}", usuario);
    }
}
