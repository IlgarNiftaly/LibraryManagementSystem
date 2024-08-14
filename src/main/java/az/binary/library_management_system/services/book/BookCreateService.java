package az.binary.library_management_system.services.book;

import az.binary.library_management_system.dto.requests.book.BookCreateRequest;
import az.binary.library_management_system.dto.responses.book.BookCreateResponse;
import az.binary.library_management_system.entities.Book;
import az.binary.library_management_system.mappers.BookMapper;
import az.binary.library_management_system.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookCreateService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookCreateResponse create(BookCreateRequest createRequest){
        Book book = bookMapper.mapRequestToEntity(createRequest);
        bookRepository.save(book);
        return bookMapper.mapCrateToResponse(book);
    }
}
