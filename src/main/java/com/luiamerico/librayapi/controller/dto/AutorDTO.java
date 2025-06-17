package com.luiamerico.librayapi.controller.dto;

import com.luiamerico.librayapi.model.Autor;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.UUID;

public record AutorDTO(
        UUID id,
        @NotBlank(message = "O nome do autor é obrigatório")
        @Size(min = 2, max = 100, message = "Campo fora do tamanho permitido, deve ter entre 2 e 100 caracteres")
        String nome,
        @NotNull(message = "A data de nascimento do autor é obrigatória")
        @Past(message = "A data de nascimento deve ser uma data passada")
        LocalDate dataNascimento,
        @NotBlank(message = "A nacionalidade do autor é obrigatória")
        @Size(min = 2, max = 50, message = "Campo fora do tamanho permitido, deve ter entre 2 e 50 caracteres")
        String nacionalidade) {

    public Autor mapearAutor() {
        Autor autor = new Autor();
        autor.setNome(this.nome);
        autor.setDataNascimento(this.dataNascimento);
        autor.setNacionalidade(this.nacionalidade);
        return autor;
    }
}
