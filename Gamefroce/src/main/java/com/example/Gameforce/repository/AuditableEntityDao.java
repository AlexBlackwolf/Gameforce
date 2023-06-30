package com.example.Gameforce.repository;

import com.example.Gameforce.entity.AuditableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditableEntityDao extends JpaRepository<AuditableEntity,Long>{
    List<AuditableEntity> findByDeletedFalse();
}
