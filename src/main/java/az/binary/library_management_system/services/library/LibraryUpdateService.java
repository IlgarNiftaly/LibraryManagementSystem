package az.binary.library_management_system.services.library;

import az.binary.library_management_system.dto.requests.library.LibraryUpdateRequest;
import az.binary.library_management_system.entities.Library;
import az.binary.library_management_system.exceptions.library.LibraryNotFoundException;
import az.binary.library_management_system.repositories.LibraryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class LibraryUpdateService {
    private final LibraryRepository libraryRepository;

    public void update(LibraryUpdateRequest updateRequest){
        Library library = libraryRepository.findById(updateRequest.getId())
                .orElseThrow(LibraryNotFoundException::new);

        Optional.ofNullable(updateRequest.getName()).ifPresent(library::setName);
        Optional.ofNullable(updateRequest.getStatus()).ifPresent(library::setStatus);

        libraryRepository.save(library);
        log.info("library is updated {}", library.getName());
    }

}
