package az.binary.library_management_system.repositories;

import az.binary.library_management_system.entities.Library;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibraryRepository extends JpaRepository<Library, Long> {
    Library findByName(String name);

    List<Library> findByStatus(String status);
}
