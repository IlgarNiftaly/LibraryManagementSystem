package az.binary.library_management_system.controllers;

import az.binary.library_management_system.dto.requests.UserCreateRequest;
import az.binary.library_management_system.dto.requests.UserLogInRequest;
import az.binary.library_management_system.dto.requests.UserReadRequest;
import az.binary.library_management_system.dto.responses.UserCreateResponse;
import az.binary.library_management_system.dto.responses.UserLogInResponse;
import az.binary.library_management_system.dto.responses.UserReadResponse;
import az.binary.library_management_system.services.user.UserReadService;
import az.binary.library_management_system.services.user.UserSignUpService;
import az.binary.library_management_system.services.user.UserLogInService;
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
    private final UserSignUpService signUpService;
    private final UserLogInService logInService;
    private final UserReadService readService;

    @PostMapping("/sign_up")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserCreateResponse> create(@RequestBody @Valid UserCreateRequest createRequest){
        return ResponseEntity.ok(signUpService.create(createRequest));
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


}
