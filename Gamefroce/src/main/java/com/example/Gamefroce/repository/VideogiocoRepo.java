package com.example.Gamefroce.repository;

import com.example.Gamefroce.entity.Utente;
import com.example.Gamefroce.entity.Videogioco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideogiocoRepo extends JpaRepository<Videogioco, Long> {
}
