package com.luiamerico.librayapi.service;

import com.luiamerico.librayapi.exceptions.OperacaoNaoPermitidaException;
import com.luiamerico.librayapi.model.Autor;
import com.luiamerico.librayapi.model.Usuario;
import com.luiamerico.librayapi.repository.AutorRepository;
import com.luiamerico.librayapi.repository.LivroRepository;
import com.luiamerico.librayapi.security.SecurityService;
import com.luiamerico.librayapi.validator.AutorValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AutorService {

    private final AutorRepository autorRepository;
    private final AutorValidator autorValidator;
    private final LivroRepository livroRepository;
    private final SecurityService securityService;


    public Autor salvarAutor(Autor autor) {
        autorValidator.validar(autor);
        Usuario usuario = securityService.obterPorUsuarioLogado();
        autor.setUsuario(usuario);
        return autorRepository.save(autor);
    }

    public void atualizarAutor(Autor autor) {
        if (autor.getId() == null) {
            throw new IllegalArgumentException("Autor ID não pode ser nulo para atualização.");
        }
        autorRepository.save(autor);
    }

    public Optional<Autor> obterPorId(UUID id) {
        return autorRepository.findById(id);
    }

    public void deletarAutor(Autor autor) {
        if (possuiLivro(autor)) {
            throw new OperacaoNaoPermitidaException("Autor possui livros cadastrados");
        }
        autorRepository.delete(autor);
    }

    public List<Autor> pesquisarAutores(String nome, String nacionalidade) {

        if(nome != null && nacionalidade != null) {
            return autorRepository.findByNomeAndNacionalidade(nome, nacionalidade);
        }

        if(nome != null) {
            return autorRepository.findByNome(nome);
        }

        if(nacionalidade != null) {
            return autorRepository.findByNacionalidade(nacionalidade);
        }

        return autorRepository.findAll();

    }

    public List<Autor> pesquisaByExample(String nome, String nacionalidade) {
        var autor = new Autor();
        autor.setNome(nome);
        autor.setNacionalidade(nacionalidade);

        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnorePaths("dataNascimento", "id", "dataCadastro")
                .withIgnoreNullValues()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Autor> autorExample = Example.of(autor, matcher);
        return autorRepository.findAll(autorExample);
    }

    public boolean possuiLivro(Autor autor) {
        return livroRepository.existsByAutor(autor);
    }

}
