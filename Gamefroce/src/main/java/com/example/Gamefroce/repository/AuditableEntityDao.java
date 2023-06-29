package com.example.Gamefroce.repository;

import com.example.Gamefroce.entity.AuditableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditableEntityDao extends JpaRepository<AuditableEntity,Long>{
    List<AuditableEntity> findByDeletedFalse();
}
