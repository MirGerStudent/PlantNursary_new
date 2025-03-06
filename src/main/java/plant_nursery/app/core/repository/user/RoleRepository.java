package plant_nursery.app.core.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import plant_nursery.app.core.model.users.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
