package az.binary.library_management_system.controllers;

import az.binary.library_management_system.dto.requests.UserCreateRequest;
import az.binary.library_management_system.dto.responses.UserCreateResponse;
import az.binary.library_management_system.services.create.UserSignUpService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {
    private final UserSignUpService signUpService;

    @PostMapping("/Sign_Up")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserCreateResponse> create(@Valid @RequestBody UserCreateRequest createRequest){
        return ResponseEntity.ok(signUpService.create(createRequest));
    }


}
