package plant_nursery.app.core.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import plant_nursery.app.core.model.users.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
