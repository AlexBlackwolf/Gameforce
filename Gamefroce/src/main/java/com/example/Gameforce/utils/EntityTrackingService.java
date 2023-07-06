package com.example.Gameforce.utils;

import com.example.Gameforce.entity.EntityTracking;
import com.example.Gameforce.repository.EntityTrackingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EntityTrackingService {
    @Autowired
    private EntityTrackingRepo entityTrackingRepo;

    public void logicalDelete(Long id){
        Optional<EntityTracking> optionalEntity = entityTrackingRepo.findById(id);
        optionalEntity.ifPresent(entity->{entity.setDeleted(true);
            entityTrackingRepo.save(entity);});
    }
}
