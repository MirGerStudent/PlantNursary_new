package plant_nursery.app.core.repository.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import plant_nursery.app.core.model.entity.Plant;

public interface PlantRepository extends JpaRepository<Plant, Long> {
}
