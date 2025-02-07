package plant_nursery.app.core.repository.enums;

import org.springframework.data.jpa.repository.JpaRepository;
import plant_nursery.app.core.model.enums.GroundType;

public interface GroundTypeRepository extends JpaRepository<GroundType, Long> {
}
