package com.example.Gameforce.repository;

import com.example.Gameforce.entity.AuditableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


import java.util.List;

//dice di non creare il bean visto che è una classe estratta
@NoRepositoryBean
public interface AuditableEntityRepo extends JpaRepository<AuditableEntity,Long>{
    List<AuditableEntity>findAllByDeletedFalse();
    //controllare se il metodo funziona una volta creato il service con dentro una classe che implementa auditableEntity e vedere se  il metodo findAllByDeletedFalse funziona
    //se non funziona bisogno implementare le custom querry all'interno di tutti i repository!
}
