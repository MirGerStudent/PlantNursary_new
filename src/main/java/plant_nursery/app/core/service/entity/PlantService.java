package plant_nursery.app.core.service.entity;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import plant_nursery.app.core.model.entity.Plant;
import plant_nursery.app.core.repository.entity.PlantRepository;

@Service
public class PlantService {
    @Autowired
    private PlantRepository plantRepository;

    public List<Plant> getAllPlants() {
        return plantRepository.findAll();
    }
    
    public Optional<Plant> getPlantById(Long id) {
        return plantRepository.findById(id);
    }
    
    public Plant addPlant(Plant plant) {
        return plantRepository.save(plant);
    }

    public Plant updatePlant(Long id, Plant plantDetails) {
        Plant plant = plantRepository.findById(id).orElse(null);
        if (plant != null) {
            plant.setName(plantDetails.getName());
            plant.setHeight(plantDetails.getHeight());
            plant.setDiameter(plantDetails.getDiameter());
            plant.setWinterHardinessType(plantDetails.getWinterHardinessType());
            plant.setPlaceType(plantDetails.getPlaceType());
            plant.setGroundType(plantDetails.getGroundType());
            plant.setPeculiarities(plantDetails.getPeculiarities());
            return plantRepository.save(plant);
        }
        return null;
    }
    
    public void deletePlant(Long id) {
        plantRepository.deleteById(id);
    }
}
