package az.binary.library_management_system.services.library;

import az.binary.library_management_system.dto.requests.library.LibraryCreateRequest;
import az.binary.library_management_system.dto.responses.library.LibraryCreateResponse;
import az.binary.library_management_system.entities.Library;
import az.binary.library_management_system.exceptions.library.LibraryFoundException;
import az.binary.library_management_system.mappers.LibraryMapper;
import az.binary.library_management_system.repositories.LibraryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class LibraryCreateService {
    private final LibraryRepository libraryRepository;
    private final LibraryMapper libraryMapper;

    public LibraryCreateResponse create(LibraryCreateRequest createRequest){
        Optional.ofNullable(libraryRepository.findByName(createRequest.getName()))
                .ifPresent(library -> {throw new LibraryFoundException(); });
        Library library = libraryMapper.mapRequestToEntity(createRequest);
        libraryRepository.save(library);
        log.info("library save {}", library);
        return libraryMapper.mapCreateToResponse(library);
    }
}
