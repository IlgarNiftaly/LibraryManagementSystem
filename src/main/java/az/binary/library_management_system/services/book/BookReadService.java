package az.binary.library_management_system.services.book;

import az.binary.library_management_system.dto.requests.book.BookReadRequest;
import az.binary.library_management_system.dto.responses.book.BookReadResponse;
import az.binary.library_management_system.entities.Book;
import az.binary.library_management_system.exceptions.book.BookAuthorNotFoundException;
import az.binary.library_management_system.exceptions.book.BookNotFoundException;
import az.binary.library_management_system.exceptions.other.StatusIsEmptyException;
import az.binary.library_management_system.mappers.BookMapper;
import az.binary.library_management_system.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookReadService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public List<BookReadResponse> getAll(){
        return bookRepository.findAll().stream()
                .map(bookMapper::mapReadToResponse)
                .toList();
    }

    public BookReadResponse getById(BookReadRequest readRequest){
        return bookRepository.findById(readRequest.getId())
                .map(bookMapper::mapReadToResponse)
                .orElseThrow(BookNotFoundException::new);
    }

    public List<BookReadResponse> getByAuthor(BookReadRequest readRequest){
        if(bookRepository.findByStatus(readRequest.getAuthor()).isEmpty()){
            throw new BookAuthorNotFoundException();
        }
        return bookRepository.findByStatus(readRequest.getAuthor()).stream()
                .map(bookMapper::mapReadToResponse)
                .toList();
    }

    public List<BookReadResponse> getByStatus(BookReadRequest readRequest){
        if(bookRepository.findByStatus(readRequest.getStatus()).isEmpty()){
            throw new StatusIsEmptyException();
        }
        return bookRepository.findByStatus(readRequest.getStatus()).stream()
                .map(bookMapper::mapReadToResponse)
                .toList();
    }
}
