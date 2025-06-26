package lt.caeli.veryNiceApp.nice.repository;

import lt.caeli.veryNiceApp.nice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
