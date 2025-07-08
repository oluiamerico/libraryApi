package com.luiamerico.librayapi.repository;

import com.luiamerico.librayapi.model.Autor;
import com.luiamerico.librayapi.model.GeneroLivro;
import com.luiamerico.librayapi.model.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LivroRepositoryTest {

    @Autowired
    LivroRepository livroRepository;

    @Autowired
    AutorRepository autorRepository;


    @Test
    void salvarTest() {
        Livro livro = new Livro();
        livro.setIsbn("198498-498798");
        livro.setPreco(BigDecimal.valueOf(100));
        livro.setGenero(GeneroLivro.FICCAO);
        livro.setTitulo("Primeiro Milhao");
        livro.setDataPublicacao(LocalDate.of(2023, 10, 1));

        Autor autor = autorRepository.findById(UUID.fromString("517b29d6-5cb7-4d7a-978a-d0a1d3f358f9"))
                .orElseThrow(() -> new RuntimeException("Autor não encontrado"));

        System.out.println(livro.getTitulo());

        livro.setAutor(autor);

        livroRepository.save(livro);

    }

}