package org.metricfit.com.br.metricfit.autenticacao.controller;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.metricfit.com.br.metricfit.autenticacao.dto.LoginRequest;
import org.metricfit.com.br.metricfit.autenticacao.dto.LoginResponse;
import org.metricfit.com.br.metricfit.autenticacao.service.AutenticacaoService;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AutenticacaoController {

    private final AutenticacaoService service;

    @PostMapping("login")
    public LoginResponse login(@RequestBody @Valid LoginRequest loginRequest) {
        return service.login(loginRequest);
    }

    @PutMapping("alterar-senha")
    @ResponseStatus(NO_CONTENT)
    public void alterarSenha(@RequestBody @Valid LoginRequest loginRequest) {
        service.alterarSenha(loginRequest);
    }
}
