package az.binary.library_management_system.controllers;

import az.binary.library_management_system.dto.requests.user.*;
import az.binary.library_management_system.dto.responses.user.UserCreateResponse;
import az.binary.library_management_system.dto.responses.user.UserLogInResponse;
import az.binary.library_management_system.dto.responses.user.UserReadResponse;
import az.binary.library_management_system.services.user.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserCreateService createService;
    private final UserLogInService logInService;
    private final UserReadService readService;
    private final UserUpdateService updateService;
    private final UserDeleteService deleteService;


    @PostMapping("/sign_up")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserCreateResponse> create(@RequestBody @Valid UserCreateRequest createRequest){
        return ResponseEntity.ok(createService.create(createRequest));
    }

    @PostMapping("/log_in")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<UserLogInResponse> logIn(@RequestBody UserLogInRequest logInRequest){
        return ResponseEntity.ok(logInService.logIn(logInRequest));
    }

    @PostMapping("/read_all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<UserReadResponse>> readAll(){
        return ResponseEntity.ok(readService.readAll());
    }

    @PostMapping("/read_by_id")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserReadResponse> readById(@RequestBody @Valid UserReadRequest readRequest){
        return ResponseEntity.ok(readService.readById(readRequest));
    }

    @PostMapping("/read_by_email")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserReadResponse> readByEmail(@RequestBody @Valid UserReadRequest readRequest){
        return ResponseEntity.ok(readService.readByEmail(readRequest));
    }

    @PostMapping("/read_by_other")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<UserReadResponse>> readByOther(@RequestBody @Valid UserReadRequest readRequest){
        return ResponseEntity.ok(readService.readByOther(readRequest));
    }

    @PostMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> update(@RequestBody @Valid UserUpdateRequest updateRequest){
        updateService.update(updateRequest);
        return ResponseEntity.ok("User is updated");
    }

    @PostMapping("/delete_all")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> deleteAll(){
        deleteService.deleteAll();
        return ResponseEntity.ok("All user is deleted");
    }

    @PostMapping("/delete_by_id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> deleteById(@RequestBody @Valid UserDeleteRequest deleteRequest){
        deleteService.deleteById(deleteRequest);
        return ResponseEntity.ok("User is deleted");
    }

}
