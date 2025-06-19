package com.luiamerico.librayapi.controller.dto;

import com.luiamerico.librayapi.model.GeneroLivro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import org.hibernate.validator.constraints.ISBN;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record CadastroLivroDTO(
        @ISBN
        @NotBlank(message = "ISBN não pode estar em branco")
        String isbn,
        @NotBlank(message = "Título não pode estar em branco")
        String titulo,
        @NotNull(message = "Data de publicação não pode ser nula")
        @Past(message = "Data de publicação deve ser uma data passada")
        LocalDate dataPublicacao,
        GeneroLivro genero,
        BigDecimal preco,
        @NotNull(message = "Autor não pode ser nulo")
        UUID idAutor
) {
}
