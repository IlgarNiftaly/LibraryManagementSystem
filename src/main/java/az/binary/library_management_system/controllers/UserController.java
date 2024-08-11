package az.binary.library_management_system.controllers;

import az.binary.library_management_system.dto.requests.UserCreateRequest;
import az.binary.library_management_system.dto.requests.UserLohInRequest;
import az.binary.library_management_system.dto.responses.UserCreateResponse;
import az.binary.library_management_system.dto.responses.UserLogInResponse;
import az.binary.library_management_system.services.create.UserSignUpService;
import az.binary.library_management_system.services.login.UserLogInService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserSignUpService signUpService;
    private final UserLogInService logInService;

    @PostMapping("/sign_up")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserCreateResponse> create(@RequestBody @Valid UserCreateRequest createRequest){
        return ResponseEntity.ok(signUpService.create(createRequest));
    }

    @PostMapping("/log_in")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<UserLogInResponse> logIn(@RequestBody UserLohInRequest logInRequest){
        return ResponseEntity.ok(logInService.logIn(logInRequest));
    }

}
