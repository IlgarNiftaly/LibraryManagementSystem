package az.binary.library_management_system.repositories;

import az.binary.library_management_system.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    List<User> findUserByFirstNameAndLastName(String firstName, String lastName);
    List<User> findUserByFirstNameOrLastName(String firstName, String lastName);
}
