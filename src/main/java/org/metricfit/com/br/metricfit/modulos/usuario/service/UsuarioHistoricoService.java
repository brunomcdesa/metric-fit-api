package org.metricfit.com.br.metricfit.modulos.usuario.service;

import lombok.RequiredArgsConstructor;
import org.metricfit.com.br.metricfit.modulos.comum.enums.EAcao;
import org.metricfit.com.br.metricfit.modulos.usuario.mapper.UsuarioMapper;
import org.metricfit.com.br.metricfit.modulos.usuario.model.Usuario;
import org.metricfit.com.br.metricfit.modulos.usuario.repository.UsuarioHistoricoRepository;
import org.springframework.stereotype.Service;

import static org.metricfit.com.br.metricfit.modulos.comum.utils.MapUtils.mapNullWithBackup;

@Service
@RequiredArgsConstructor
public class UsuarioHistoricoService {

    private final UsuarioMapper usuarioMapper;
    private final UsuarioHistoricoRepository repository;

    public void salvar(Usuario usuario, Usuario usuarioAutenticado, EAcao acao) {
        var historico = usuarioMapper.mapToHistorico(usuario,
            mapNullWithBackup(usuarioAutenticado, Usuario::getId, usuario.getId()),
            acao);

        repository.save(historico);
    }
}
