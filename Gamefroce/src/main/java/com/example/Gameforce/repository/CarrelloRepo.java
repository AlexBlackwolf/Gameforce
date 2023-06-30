package com.example.Gameforce.repository;

import com.example.Gameforce.entity.Carrello;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrelloRepo extends JpaRepository<Carrello, String> {
}
