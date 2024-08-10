package az.binary.library_management_system.services.create;

import az.binary.library_management_system.dto.requests.UserCreateRequest;
import az.binary.library_management_system.dto.responses.UserCreateResponse;
import az.binary.library_management_system.entities.User;
import az.binary.library_management_system.mappers.UserMapper;
import az.binary.library_management_system.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserSignUpService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserCreateResponse create(UserCreateRequest createRequest){
        if(Objects.nonNull(userRepository.findByEmail(createRequest.getEmailAddress()))){
            log.info("email artiq movgutdur");
            throw new RuntimeException();
        }
        User user = userRepository.save(userMapper.requestToEntity(createRequest));

        return userMapper.createToResponse(user);
    }

}
