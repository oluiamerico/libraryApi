package com.luiamerico.librayapi.controller;

import com.luiamerico.librayapi.controller.dto.CadastroLivroDTO;
import com.luiamerico.librayapi.controller.dto.ErroResposta;
import com.luiamerico.librayapi.exceptions.RegistroDuplicadoException;
import com.luiamerico.librayapi.repository.LivroRepository;
import com.luiamerico.librayapi.service.LivroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livros")
@RequiredArgsConstructor
public class LivroController {

    private final LivroService livroService;

    @PostMapping
    public ResponseEntity<Object> salvar(@RequestBody @Valid CadastroLivroDTO dto) {
        try {
            return ResponseEntity.ok(dto);
        } catch (RegistroDuplicadoException e) {
            var erroDTO = ErroResposta.conflito(e.getMessage());
            return ResponseEntity.status(erroDTO.status()).body(erroDTO);
        }
    }

}
