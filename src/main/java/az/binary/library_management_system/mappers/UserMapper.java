package az.binary.library_management_system.mappers;

import az.binary.library_management_system.dto.requests.UserCreateRequest;
import az.binary.library_management_system.dto.requests.UserLogInRequest;
import az.binary.library_management_system.dto.responses.UserCreateResponse;
import az.binary.library_management_system.dto.responses.UserLogInResponse;
import az.binary.library_management_system.dto.responses.UserReadResponse;
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

