package com.example.biblioteca.repository;

import com.example.biblioteca.model.Locatario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocatarioRepository extends JpaRepository<Locatario, Long> {
    Optional<Locatario> findLocatarioByNome(String nome);
}
