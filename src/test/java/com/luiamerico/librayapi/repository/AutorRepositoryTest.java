package com.luiamerico.librayapi.repository;

import com.luiamerico.librayapi.model.Autor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
class AutorRepositoryTest {

    @Autowired
    AutorRepository autorRepository;

    @Test
    public void salvarTest() {
        Autor autor = new Autor();
        autor.setNome("Luis Americo");
        autor.setNacionalidade("Brasileiro");
        autor.setDataNascimento(LocalDate.of(2004, 04, 30));

        var autorSalvo = autorRepository.save(autor);

        System.out.println(autorSalvo);
    }

    @Test
    public void deleteTest() {
        Autor autor = autorRepository.findById(UUID.fromString("1160cf92-d54f-4b43-b00a-a8541bc09f95"))
                .orElseThrow(() -> new RuntimeException("Autor não encontrado"));

        autorRepository.delete(autor);
    }




}