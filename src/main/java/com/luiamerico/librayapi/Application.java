package com.luiamerico.librayapi;

import com.luiamerico.librayapi.model.Autor;
import com.luiamerico.librayapi.repository.AutorRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        var context = SpringApplication.run(Application.class, args);
        AutorRepository repository = context.getBean(AutorRepository.class);

        exemploSalvarRegistro(repository);
    }

    public static void exemploSalvarRegistro(AutorRepository autorRepository) {
        Autor autor = new Autor();
        autor.setNome("J.K. Rowling");
        autor.setNacionalidade("Britânica");
        autor.setDataNascimento(LocalDate.of(1965, 7, 31));

        var autorSalvo = autorRepository.save(autor);

        System.out.println(autorSalvo);
    }

}
