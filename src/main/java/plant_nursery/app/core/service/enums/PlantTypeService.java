
package plant_nursery.app.core.service.enums;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import plant_nursery.app.core.model.enums.PlantType;
import plant_nursery.app.core.repository.enums.PlantTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PlantTypeService {
    @Autowired
    private PlantTypeRepository plantTypeRepository;

    public List<PlantType> getAllPlantTypes() {
        return plantTypeRepository.findAll();
    }

    public Optional<PlantType> getPlantTypeById(Long id) {
        return plantTypeRepository.findById(id);
    }

    public PlantType addPlantType(PlantType plantType) {
        return plantTypeRepository.save(plantType);
    }

    public PlantType updatePlantType(Long id, PlantType plantType) {
        PlantType newPlantType = plantTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("PlantType not found."));
        newPlantType.setName(plantType.getName());
        return plantTypeRepository.save(newPlantType);
    }

    public void deletePlantType(Long id) {
        plantTypeRepository.deleteById(id);
    }
}
