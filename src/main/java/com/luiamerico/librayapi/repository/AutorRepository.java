package com.luiamerico.librayapi.repository;

import com.luiamerico.librayapi.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface AutorRepository extends JpaRepository<Autor, UUID> {

}
