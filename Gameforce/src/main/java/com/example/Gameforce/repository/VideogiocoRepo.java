package com.example.Gameforce.repository;

import com.example.Gameforce.entity.Videogioco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideogiocoRepo extends JpaRepository<Videogioco, Long> {
    List<Videogioco> findByValutazione(Double valutazione);
}
