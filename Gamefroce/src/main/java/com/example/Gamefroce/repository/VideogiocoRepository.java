package com.example.Gamefroce.repository;

import com.example.Gamefroce.entity.Videogioco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface VideogiocoRepository extends JpaRepository<Videogioco, String> {
}
