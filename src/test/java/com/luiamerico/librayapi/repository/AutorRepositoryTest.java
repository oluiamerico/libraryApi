package com.luiamerico.librayapi.repository;

import com.luiamerico.librayapi.model.Autor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
class AutorRepositoryTest {

    @Autowired
    AutorRepository autorRepository;

    @Test
    public void salvarTest() {
        Autor autor = new Autor();
        autor.setNome("J.K. Rowling");
        autor.setNacionalidade("Britânica");
        autor.setDataNascimento(LocalDate.of(1965, 7, 31));

        var autorSalvo = autorRepository.save(autor);

        System.out.println(autorSalvo);
    }

    @Test
    public void atualizarTest() {
        var id = UUID.fromString("557eb23c-371c-4e2c-b30c-cdd8e5203542");
        Optional<Autor> possivelAutor = autorRepository.findById(id);
        if (possivelAutor.isPresent()) {

            Autor autorEncontrado = possivelAutor.get();
            System.out.println("Dados do autor: ");
            System.out.println(possivelAutor.get());

            autorEncontrado.setDataNascimento(LocalDate.of(1960, 1, 30));

            autorRepository.save(autorEncontrado);

        }

    }

}