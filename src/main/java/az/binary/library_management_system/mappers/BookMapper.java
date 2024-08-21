package az.binary.library_management_system.mappers;

import az.binary.library_management_system.dto.requests.book.BookCreateRequest;
import az.binary.library_management_system.dto.responses.book.BookCreateResponse;
import az.binary.library_management_system.dto.responses.book.BookReadResponse;
import az.binary.library_management_system.entities.Book;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface BookMapper {
    Book mapRequestToEntity(BookCreateRequest createRequest);

    BookCreateResponse mapCrateToResponse(Book book);
    BookReadResponse mapReadToResponse(Book book);

}