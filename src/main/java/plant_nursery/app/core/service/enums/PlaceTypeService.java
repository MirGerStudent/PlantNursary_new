
package plant_nursery.app.core.service.enums;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import plant_nursery.app.core.model.enums.PlaceType;
import plant_nursery.app.core.repository.enums.PlaceTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceTypeService {
    @Autowired
    private PlaceTypeRepository placeTypeRepository;

    public List<PlaceType> getAllPlaceTypes() {
        return placeTypeRepository.findAll();
    }

    public Optional<PlaceType> getPlaceTypeById(Long id) {
        return placeTypeRepository.findById(id);
    }

    public PlaceType addPlaceType(PlaceType placeType) {
        return placeTypeRepository.save(placeType);
    }

    public PlaceType updatePlaceType(Long id, PlaceType placeType) {
        PlaceType newPlaceType = placeTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("PlaceType not found."));
        newPlaceType.setName(placeType.getName());
        return placeTypeRepository.save(newPlaceType);
    }

    public void deletePlaceType(Long id) {
        placeTypeRepository.deleteById(id);
    }
}
