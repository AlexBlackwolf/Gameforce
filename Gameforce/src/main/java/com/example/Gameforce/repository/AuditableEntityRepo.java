package com.example.Gameforce.repository;

import com.example.Gameforce.entity.AuditableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


import java.util.List;

@NoRepositoryBean
public interface AuditableEntityRepo extends JpaRepository<AuditableEntity,Long>{
    List<AuditableEntity>findAllByDeletedFalse();
}
