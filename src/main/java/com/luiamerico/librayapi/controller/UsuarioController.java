package com.luiamerico.librayapi.controller;

import com.luiamerico.librayapi.controller.dto.UsuarioDTO;
import com.luiamerico.librayapi.controller.mappers.UsuarioMapper;
import com.luiamerico.librayapi.model.Usuario;
import com.luiamerico.librayapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuarios")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService service;
    private final UsuarioMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody UsuarioDTO dto){
        var usuario = mapper.toEntity(dto);
        service.salvar(usuario);
    }
}
