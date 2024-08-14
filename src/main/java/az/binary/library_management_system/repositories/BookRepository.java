package az.binary.library_management_system.repositories;

import az.binary.library_management_system.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByName(String name);

    List<Book> findByStatus(String status);
}
