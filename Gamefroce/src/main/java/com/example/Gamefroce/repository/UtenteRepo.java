package com.example.Gamefroce.repository;

import com.example.Gamefroce.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepo extends JpaRepository<Utente, Long> {
}
