package com.example.Gamefroce.repository;

import com.example.Gamefroce.entity.Carrello;
import com.example.Gamefroce.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrelloRepo extends JpaRepository<Carrello, String> {
}
