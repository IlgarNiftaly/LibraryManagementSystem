package az.binary.library_management_system.mappers;

import az.binary.library_management_system.dto.requests.library.LibraryCreateRequest;
import az.binary.library_management_system.dto.responses.library.LibraryCreateResponse;
import az.binary.library_management_system.dto.responses.library.LibraryReadResponse;
import az.binary.library_management_system.entities.Library;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface LibraryMapper {
    Library mapRequestToEntity(LibraryCreateRequest createRequest);

    LibraryCreateResponse mapCreateToResponse(Library library);
    LibraryReadResponse mapReadToResponse(Library library);

}
