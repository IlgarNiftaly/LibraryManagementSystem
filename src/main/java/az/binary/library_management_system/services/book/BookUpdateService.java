package az.binary.library_management_system.services.book;

import az.binary.library_management_system.dto.requests.book.BookUpdateRequest;
import az.binary.library_management_system.entities.Book;
import az.binary.library_management_system.exceptions.book.BookNotFoundException;
import az.binary.library_management_system.mappers.BookMapper;
import az.binary.library_management_system.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookUpdateService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public void update(BookUpdateRequest updateRequest){
        Book book = bookRepository.findById(updateRequest.getId())
                .orElseThrow(BookNotFoundException::new);

        Optional.ofNullable(updateRequest.getName()).ifPresent(book::setName);
        Optional.ofNullable(updateRequest.getAuthor()).ifPresent(book::setAuthor);
        Optional.ofNullable(updateRequest.getCreateDateTime()).ifPresent(book::setCreateDateTime);
        Optional.ofNullable(updateRequest.getStatus()).ifPresent(book::setStatus);

        bookRepository.save(book);
        log.info("Book is updated {}", book.getAuthor());
    }
}
