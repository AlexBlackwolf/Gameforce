package com.example.Gameforce.repository;

import com.example.Gameforce.entity.EntityTracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityTrackingRepo extends JpaRepository<EntityTracking,Long> {
}
