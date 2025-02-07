
package plant_nursery.app.core.service.enums;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import plant_nursery.app.core.model.enums.WinterHardinessType;
import plant_nursery.app.core.repository.enums.WinterHardinessTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WinterHardinessTypeService {
    @Autowired
    private WinterHardinessTypeRepository winterHardinessTypeRepository;

    public List<WinterHardinessType> getAllWinterHardinessTypes() {
        return winterHardinessTypeRepository.findAll();
    }

    public Optional<WinterHardinessType> getWinterHardinessTypeById(Long id) {
        return winterHardinessTypeRepository.findById(id);
    }

    public WinterHardinessType addWinterHardinessType(WinterHardinessType winterHardinessType) {
        return winterHardinessTypeRepository.save(winterHardinessType);
    }

    public WinterHardinessType updateWinterHardinessType(Long id, WinterHardinessType winterHardinessType) {
        WinterHardinessType newWinterHardinessType = winterHardinessTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("WinterHardinessType not found."));
        newWinterHardinessType.setName(winterHardinessType.getName());
        return winterHardinessTypeRepository.save(newWinterHardinessType);
    }

    public void deleteWinterHardinessType(Long id) {
        winterHardinessTypeRepository.deleteById(id);
    }
}
