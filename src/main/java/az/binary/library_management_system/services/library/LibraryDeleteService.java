package az.binary.library_management_system.services.library;

import az.binary.library_management_system.dto.requests.library.LibraryDeleteRequest;
import az.binary.library_management_system.repositories.LibraryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LibraryDeleteService {
    private final LibraryRepository libraryRepository;

    public void deleteAll(){
        libraryRepository.deleteAll();
    }

    public void deleteById(LibraryDeleteRequest deleteRequest){
        libraryRepository.deleteById(deleteRequest.getId());
    }
}
