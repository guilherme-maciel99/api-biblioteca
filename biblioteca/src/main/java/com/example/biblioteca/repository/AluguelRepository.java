package com.example.biblioteca.repository;

import com.example.biblioteca.model.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AluguelRepository extends JpaRepository<Aluguel, Long> {
    Optional<Aluguel> findAluguelByLocatario(String locatario);
}
