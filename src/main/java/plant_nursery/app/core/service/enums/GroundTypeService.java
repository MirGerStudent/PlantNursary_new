package plant_nursery.app.core.service.enums;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import plant_nursery.app.core.model.enums.GroundType;
import plant_nursery.app.core.repository.enums.GroundTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GroundTypeService {
    @Autowired
    private GroundTypeRepository groundTypeRepository;

    public List<GroundType> getAllGroundTypes() {
        return groundTypeRepository.findAll();
    }

    public Optional<GroundType> getGroundTypeByTd(Long id) {
        return groundTypeRepository.findById(id);
    }

    public GroundType addGroundType(GroundType groundType) {
        return groundTypeRepository.save(groundType);
    }

    public GroundType updateGroundType(Long id, GroundType groundType) {
        GroundType newGroundType = groundTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("GroundType not Found!"));
//        GroundType newGroundType = groundTypeRepository.findById(id).orElse(new GroundType(-1L, "notFound"));
        newGroundType.setName(groundType.getName());
        return groundTypeRepository.save(newGroundType);
    }

    public void deleteGroundType(Long id) {
        groundTypeRepository.deleteById(id);
    }
}
