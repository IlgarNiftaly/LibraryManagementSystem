package az.binary.library_management_system.controllers;

import az.binary.library_management_system.dto.requests.library.LibraryCreateRequest;
import az.binary.library_management_system.dto.requests.library.LibraryDeleteRequest;
import az.binary.library_management_system.dto.requests.library.LibraryReadRequest;
import az.binary.library_management_system.dto.requests.library.LibraryUpdateRequest;
import az.binary.library_management_system.dto.requests.user.UserDeleteRequest;
import az.binary.library_management_system.dto.requests.user.UserUpdateRequest;
import az.binary.library_management_system.dto.responses.library.LibraryCreateResponse;
import az.binary.library_management_system.dto.responses.library.LibraryReadResponse;
import az.binary.library_management_system.services.library.LibraryCreateService;
import az.binary.library_management_system.services.library.LibraryDeleteService;
import az.binary.library_management_system.services.library.LibraryReadService;
import az.binary.library_management_system.services.library.LibraryUpdateService;
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
    private final LibraryUpdateService updateService;
    private final LibraryDeleteService deleteService;

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

    @PostMapping("/read_all_active")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<LibraryReadResponse>> readAllActive(){
        return ResponseEntity.ok(readService.getAllActive());
    }

    @PostMapping("/read_all_inactive")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<LibraryReadResponse>> readAllInactive(){
        return ResponseEntity.ok(readService.getAllInactive());
    }

    @PostMapping("/read_by_id")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<LibraryReadResponse> readById(@RequestBody @Valid LibraryReadRequest readRequest){
        return ResponseEntity.ok(readService.getById(readRequest));
    }

    @PostMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> update(@RequestBody @Valid LibraryUpdateRequest updateRequest){
        updateService.update(updateRequest);
        return ResponseEntity.ok("Library is updated");
    }

    @PostMapping("/delete_all")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> deleteAll(){
        deleteService.deleteAll();
        return ResponseEntity.ok("All library is deleted");
    }

    @PostMapping("/delete_by_id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> deleteById(@RequestBody @Valid LibraryDeleteRequest deleteRequest){
        deleteService.deleteById(deleteRequest);
        return ResponseEntity.ok("Library is deleted");
    }


}
