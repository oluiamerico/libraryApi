package com.luiamerico.librayapi.controller.dto;

import com.luiamerico.librayapi.model.Autor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record AutorDTO(
        UUID id,
        @NotBlank(message = "O nome do autor é obrigatório")
        String nome,
        @NotNull(message = "A data de nascimento do autor é obrigatória")
        LocalDate dataNascimento,
        @NotBlank(message = "A nacionalidade do autor é obrigatória")
        String nacionalidade) {

    public Autor mapearAutor() {
        Autor autor = new Autor();
        autor.setNome(this.nome);
        autor.setDataNascimento(this.dataNascimento);
        autor.setNacionalidade(this.nacionalidade);
        return autor;
    }
}
