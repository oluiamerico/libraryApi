package com.luiamerico.librayapi.controller.mappers;

import com.luiamerico.librayapi.controller.dto.CadastroLivroDTO;
import com.luiamerico.librayapi.controller.dto.ResultadoPesquisaLivroDTO;
import com.luiamerico.librayapi.model.Livro;
import com.luiamerico.librayapi.repository.AutorRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = AutorMapper.class )
public abstract class LivroMapper {
    @Autowired
    AutorRepository autorRepository;

    @Mapping(target = "autor", expression = "java( autorRepository.findById(dto.idAutor()).orElse(null) )")
    public abstract Livro toEntity(CadastroLivroDTO dto);

    public abstract ResultadoPesquisaLivroDTO toDTO(Livro livro);
}
