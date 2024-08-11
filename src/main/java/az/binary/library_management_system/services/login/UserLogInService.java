package az.binary.library_management_system.services.login;


import az.binary.library_management_system.dto.requests.UserLohInRequest;
import az.binary.library_management_system.dto.responses.UserLogInResponse;
import az.binary.library_management_system.entities.User;
import az.binary.library_management_system.mappers.UserMapper;
import az.binary.library_management_system.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserLogInService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserLogInResponse logIn(UserLohInRequest logInRequest){
        User user = userRepository.findByEmail(logInRequest.getEmail());
        if(Objects.isNull(user)){
            System.out.println("email sistemde gorunmedi");
            throw new RuntimeException();
        }
        if(!user.getPassword().equals(logInRequest.getPassword())){
            System.out.println("password is incorrect");
            throw new RuntimeException();
        }
        return userMapper.mapLogInToResponse(user);
    }
}
