package com.example.Gameforce.repository;

import com.example.Gameforce.entity.Ordine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdineRepo extends JpaRepository <Ordine, String>{
}
