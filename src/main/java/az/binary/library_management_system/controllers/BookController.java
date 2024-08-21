package az.binary.library_management_system.controllers;

import az.binary.library_management_system.dto.requests.book.BookCreateRequest;
import az.binary.library_management_system.dto.requests.book.BookDeleteRequest;
import az.binary.library_management_system.dto.requests.book.BookReadRequest;
import az.binary.library_management_system.dto.requests.book.BookUpdateRequest;
import az.binary.library_management_system.dto.requests.library.LibraryCreateRequest;
import az.binary.library_management_system.dto.requests.library.LibraryDeleteRequest;
import az.binary.library_management_system.dto.requests.library.LibraryReadRequest;
import az.binary.library_management_system.dto.requests.library.LibraryUpdateRequest;
import az.binary.library_management_system.dto.responses.book.BookCreateResponse;
import az.binary.library_management_system.dto.responses.book.BookReadResponse;
import az.binary.library_management_system.dto.responses.library.LibraryCreateResponse;
import az.binary.library_management_system.dto.responses.library.LibraryReadResponse;
import az.binary.library_management_system.services.book.BookCreateService;
import az.binary.library_management_system.services.book.BookDeleteService;
import az.binary.library_management_system.services.book.BookReadService;
import az.binary.library_management_system.services.book.BookUpdateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {
    private final BookCreateService createService;
    private final BookReadService readService;
    private final BookUpdateService updateService;
    private final BookDeleteService deleteService;


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BookCreateResponse> create(@RequestBody @Valid BookCreateRequest createRequest){
        return ResponseEntity.ok(createService.create(createRequest));
    }

    @PostMapping("/read_all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<BookReadResponse>> readAll(){
        return ResponseEntity.ok(readService.getAll());
    }

    @PostMapping("/read_all_active")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<BookReadResponse>> readAllActive(){
        return ResponseEntity.ok(readService.getAllActive());
    }

    @PostMapping("/read_all_inactive")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<BookReadResponse>> readAllInactive(){
        return ResponseEntity.ok(readService.getAllInactive());
    }

    @PostMapping("/read_by_id")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BookReadResponse> readById(@RequestBody @Valid BookReadRequest readRequest){
        return ResponseEntity.ok(readService.getById(readRequest));
    }

    @PostMapping("/read_by_author")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<BookReadResponse>> readByAuthor(@RequestBody @Valid BookReadRequest readRequest){
        return ResponseEntity.ok(readService.getByAuthor(readRequest));
    }

    @PostMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> update(@RequestBody @Valid BookUpdateRequest updateRequest){
        updateService.update(updateRequest);
        return ResponseEntity.ok("Book is updated");
    }

    @PostMapping("/delete_all")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> deleteAll(){
        deleteService.deleteAll();
        return ResponseEntity.ok("All book is deleted");
    }

    @PostMapping("/delete_by_id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> deleteById(@RequestBody @Valid BookDeleteRequest deleteRequest){
        deleteService.deleteById(deleteRequest);
        return ResponseEntity.ok("Book is deleted");
    }

}
