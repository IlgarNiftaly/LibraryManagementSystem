package az.binary.library_management_system.services.library;

import az.binary.library_management_system.dto.requests.library.LibraryReadRequest;
import az.binary.library_management_system.dto.responses.library.LibraryReadResponse;
import az.binary.library_management_system.entities.Library;
import az.binary.library_management_system.exceptions.library.LibraryNotFoundException;
import az.binary.library_management_system.exceptions.other.StatusIsEmptyException;
import az.binary.library_management_system.mappers.LibraryMapper;
import az.binary.library_management_system.repositories.LibraryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class LibraryReadService {
    private final LibraryRepository libraryRepository;
    private final LibraryMapper libraryMapper;

    public List<LibraryReadResponse> getAll(){
        return libraryRepository.findAll().stream()
                .map(libraryMapper::mapReadToResponse)
                .toList();
    }

    public LibraryReadResponse getById(LibraryReadRequest readRequest){
        return libraryRepository.findById(readRequest.getId())
                .map(libraryMapper::mapReadToResponse)
                .orElseThrow(LibraryNotFoundException::new);
    }

    public List<LibraryReadResponse> getByStatus(LibraryReadRequest readRequest){
        List<Library> byStatus = libraryRepository.findByStatus(readRequest.getStatus());
        if(byStatus.isEmpty()){
            throw new StatusIsEmptyException();
        }
        return byStatus.stream()
                .map(libraryMapper::mapReadToResponse)
                .toList();
    }
}
