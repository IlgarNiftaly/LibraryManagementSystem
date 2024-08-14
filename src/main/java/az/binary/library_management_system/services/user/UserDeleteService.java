package az.binary.library_management_system.services.user;

import az.binary.library_management_system.dto.requests.user.UserDeleteRequest;
import az.binary.library_management_system.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDeleteService {
    private final UserRepository userRepository;

    public void deleteAll(){
        userRepository.deleteAll();
    }

    public void deleteById(UserDeleteRequest deleteRequest){
        userRepository.deleteById(deleteRequest.getId());
    }

}
