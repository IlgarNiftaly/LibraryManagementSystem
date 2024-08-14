package az.binary.library_management_system.mappers;

import az.binary.library_management_system.dto.requests.user.UserCreateRequest;
import az.binary.library_management_system.dto.requests.user.UserLogInRequest;
import az.binary.library_management_system.dto.responses.user.UserCreateResponse;
import az.binary.library_management_system.dto.responses.user.UserLogInResponse;
import az.binary.library_management_system.dto.responses.user.UserReadResponse;
import az.binary.library_management_system.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    User mapRequestToEntity(UserCreateRequest createRequest);
    User mapLogInRequestToEntity(UserLogInRequest logInRequest);

    UserCreateResponse mapCreateToResponse(User user);
    UserReadResponse mapReadToResponse(User user);

    UserLogInResponse mapLogInToResponse(User user);
}

