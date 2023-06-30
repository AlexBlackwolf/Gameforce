package Utils;

import com.example.Gamefroce.entity.AuditableEntity;
import com.example.Gamefroce.repository.AuditableEntityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuditableEntityService {
    @Autowired
    private AuditableEntityDao entityRepository;

    public List<AuditableEntity> getEntityNotDeleted(){
        return entityRepository.findByDeletedFalse();
    }

    public void deleteEntity(Long id){
        Optional<AuditableEntity> optionalEntity = entityRepository.findById(id);
        optionalEntity.ifPresent(entity->{entity.setDeleted(true);
            entityRepository.save(entity);});
    }

}
