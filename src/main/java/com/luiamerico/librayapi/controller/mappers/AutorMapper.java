package com.luiamerico.librayapi.controller.mappers;

import com.luiamerico.librayapi.controller.dto.AutorDTO;
import com.luiamerico.librayapi.model.Autor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AutorMapper {

    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "dataNascimento", target = "dataNascimento")
    @Mapping(source = "nacionalidade", target = "nacionalidade")
    Autor toEntity(AutorDTO dto);
    AutorDTO toDTO(Autor autor);

}
