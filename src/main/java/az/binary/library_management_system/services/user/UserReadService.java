package az.binary.library_management_system.services.user;

import az.binary.library_management_system.dto.requests.UserReadRequest;
import az.binary.library_management_system.dto.responses.UserReadResponse;
import az.binary.library_management_system.entities.User;
import az.binary.library_management_system.exceptions.user.UserNotFoundException;
import az.binary.library_management_system.mappers.UserMapper;
import az.binary.library_management_system.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserReadService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserReadResponse> readAll(){
        return userRepository.findAll().stream()
                .map(userMapper::mapReadToResponse)
                .toList();
    }

    public UserReadResponse readById(UserReadRequest readRequest){
        User user = userRepository.findById(readRequest.getId()).orElseThrow(UserNotFoundException::new);
        return userMapper.mapReadToResponse(user);
    }

    public UserReadResponse readByEmail(UserReadRequest readRequest){
        User user = Optional.ofNullable(userRepository.findByEmail(readRequest.getEmail())).orElseThrow(UserNotFoundException::new);

        return userMapper.mapReadToResponse(user);
    }

    public List<UserReadResponse> readByOther(UserReadRequest readRequest){
        List<User> userByFirstNameAndLastName = userRepository.findUserByFirstNameAndLastName(readRequest.getFirstName(), readRequest.getLastName());
        if(!userByFirstNameAndLastName.isEmpty()){
            return userByFirstNameAndLastName.stream()
                    .map(userMapper::mapReadToResponse)
                    .toList();
        }
        List<User> userByFirstNameOrLastName = userRepository.findUserByFirstNameOrLastName(readRequest.getFirstName(), readRequest.getLastName());
        if(!userByFirstNameOrLastName.isEmpty()){
            return userByFirstNameOrLastName.stream()
                    .map(userMapper::mapReadToResponse)
                    .toList();
        }else{
            throw new UserNotFoundException();
        }
        //TODO: userByFirstNameOrLastName dogru islemir
    }

}
