package az.binary.library_management_system.services.book;

import az.binary.library_management_system.dto.requests.book.BookDeleteRequest;
import az.binary.library_management_system.mappers.BookMapper;
import az.binary.library_management_system.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookDeleteService {
    private final BookRepository bookRepository;

    public void deleteAll(){
        bookRepository.deleteAll();
    }

    public void deleteById(BookDeleteRequest deleteRequest){
        bookRepository.deleteById(deleteRequest.getId());
    }
}
