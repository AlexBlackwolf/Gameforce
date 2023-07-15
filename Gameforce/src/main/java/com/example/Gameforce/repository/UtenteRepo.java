package com.example.Gameforce.repository;

import com.example.Gameforce.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtenteRepo extends JpaRepository<Utente, Long> {
    List<Utente> findUserByUsername(String username);
    Utente findByEmail(String email);
}
