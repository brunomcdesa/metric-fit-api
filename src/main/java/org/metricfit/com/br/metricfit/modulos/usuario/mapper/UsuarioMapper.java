package org.metricfit.com.br.metricfit.modulos.usuario.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.metricfit.com.br.metricfit.modulos.comum.enums.EAcao;
import org.metricfit.com.br.metricfit.modulos.usuario.model.Usuario;
import org.metricfit.com.br.metricfit.modulos.usuario.model.UsuarioHistorico;

import java.time.LocalDateTime;
import java.util.UUID;

@Mapper(componentModel = "spring", imports = {UUID.class, LocalDateTime.class})
public interface UsuarioMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "acao", source = "acao")
    @Mapping(target = "usuarioCadastroId", source = "usuarioId")
    @Mapping(target = "dataCadastro", expression = "java(LocalDateTime.now())")
    UsuarioHistorico mapToHistorico(Usuario usuario, Integer usuarioId, EAcao acao);
}
