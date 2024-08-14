package az.binary.library_management_system.controllers;

import az.binary.library_management_system.dto.requests.library.LibraryCreateRequest;
import az.binary.library_management_system.dto.requests.library.LibraryReadRequest;
import az.binary.library_management_system.dto.responses.library.LibraryCreateResponse;
import az.binary.library_management_system.dto.responses.library.LibraryReadResponse;
import az.binary.library_management_system.services.library.LibraryCreateService;
import az.binary.library_management_system.services.library.LibraryReadService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/library")
public class LibraryController {
    private final LibraryCreateService createService;
    private final LibraryReadService readService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<LibraryCreateResponse> create(@RequestBody @Valid LibraryCreateRequest createRequest){
        return ResponseEntity.ok(createService.create(createRequest));
    }

    @PostMapping("/read_all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<LibraryReadResponse>> readAll(){
        return ResponseEntity.ok(readService.getAll());
    }

    @PostMapping("/read_by_id")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<LibraryReadResponse> readById(@RequestBody @Valid LibraryReadRequest readRequest){
        return ResponseEntity.ok(readService.getById(readRequest));
    }

    @PostMapping("/read_by_status")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<LibraryReadResponse>> readByStatus(@RequestBody @Valid LibraryReadRequest readRequest){
        return ResponseEntity.ok(readService.getByStatus(readRequest));
    }






}
