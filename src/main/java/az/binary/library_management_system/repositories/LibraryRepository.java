package az.binary.library_management_system.repositories;

import az.binary.library_management_system.entities.Library;
import az.binary.library_management_system.enums.LibraryStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibraryRepository extends JpaRepository<Library, Long> {
    Library findByName(String name);

    List<Library> findByStatus(LibraryStatus status);
}
