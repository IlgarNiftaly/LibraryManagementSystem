package az.binary.library_management_system.repositories;

import az.binary.library_management_system.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
