package com.example.Gameforce.repository;

import com.example.Gameforce.entity.Videogioco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideogiocoRepository extends JpaRepository<Videogioco, String> {
}