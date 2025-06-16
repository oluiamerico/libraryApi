package com.luiamerico.librayapi.service;

import com.luiamerico.librayapi.exceptions.OperacaoNaoPermitidaException;
import com.luiamerico.librayapi.model.Autor;
import com.luiamerico.librayapi.repository.AutorRepository;
import com.luiamerico.librayapi.repository.LivroRepository;
import com.luiamerico.librayapi.validator.AutorValidator;
import lombok.RequiredArgsConstructor;
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


    public Autor salvarAutor(Autor autor) {
        autorValidator.validar(autor);
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

    public boolean possuiLivro(Autor autor) {
        return livroRepository.existsByAutor(autor);
    }

}
