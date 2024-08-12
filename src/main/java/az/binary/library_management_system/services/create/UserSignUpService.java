package az.binary.library_management_system.services.create;

import az.binary.library_management_system.dto.requests.UserCreateRequest;
import az.binary.library_management_system.dto.responses.UserCreateResponse;
import az.binary.library_management_system.entities.User;
import az.binary.library_management_system.exceptions.user.UserFoundException;
import az.binary.library_management_system.mappers.UserMapper;
import az.binary.library_management_system.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserSignUpService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional
    public UserCreateResponse create(UserCreateRequest createRequest){
        Optional.ofNullable(userRepository.findByEmail(createRequest.getEmail()))
               .ifPresent(user -> {throw new UserFoundException(); });

        User user = userMapper.mapRequestToEntity(createRequest);
        userRepository.save(user);
        log.info("hesab saved {}", user.getFirstName());
        return userMapper.mapCreateToResponse(user);
    }

}
