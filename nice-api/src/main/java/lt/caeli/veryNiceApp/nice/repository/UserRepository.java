package lt.caeli.veryNiceApp.nice.repository;

import lt.caeli.veryNiceApp.nice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
