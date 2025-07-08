package com.luiamerico.librayapi.controller.mappers;

import com.luiamerico.librayapi.controller.dto.UsuarioDTO;
import com.luiamerico.librayapi.model.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    Usuario toEntity(UsuarioDTO dto);
}
