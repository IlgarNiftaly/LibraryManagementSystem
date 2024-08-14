package az.binary.library_management_system.services.user;


import az.binary.library_management_system.dto.requests.user.UserUpdateRequest;
import az.binary.library_management_system.entities.User;
import az.binary.library_management_system.exceptions.user.UserNotFoundException;
import az.binary.library_management_system.mappers.UserMapper;
import az.binary.library_management_system.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserUpdateService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public void update(UserUpdateRequest updateRequest){
        User user = userRepository.findById(updateRequest.getId())
                .orElseThrow(UserNotFoundException::new);

        Optional.ofNullable(updateRequest.getFirstName()).ifPresent(user::setFirstName);
        Optional.ofNullable(updateRequest.getLastName()).ifPresent(user::setLastName);
        Optional.ofNullable(updateRequest.getEmail()).ifPresent(user::setEmail);
        Optional.ofNullable(updateRequest.getPassword()).ifPresent(user::setPassword);

        userRepository.save(user);
        log.info("user is updated {}", user.getFirstName());
    }
}
