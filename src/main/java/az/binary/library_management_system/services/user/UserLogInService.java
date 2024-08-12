package az.binary.library_management_system.services.user;


import az.binary.library_management_system.dto.requests.UserLogInRequest;
import az.binary.library_management_system.dto.responses.UserLogInResponse;
import az.binary.library_management_system.entities.User;
import az.binary.library_management_system.exceptions.other.InvalidPasswordException;
import az.binary.library_management_system.exceptions.user.UserNotFoundException;
import az.binary.library_management_system.mappers.UserMapper;
import az.binary.library_management_system.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserLogInService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserLogInResponse logIn(UserLogInRequest logInRequest){
        User user = Optional.ofNullable(userRepository.findByEmail(logInRequest.getEmail())).orElseThrow(UserNotFoundException::new);
        Optional.of(user.getPassword())
                .filter(password -> password.equals(logInRequest.getPassword()))
                .orElseThrow(InvalidPasswordException::new);
        return userMapper.mapLogInToResponse(user);
    }
}
