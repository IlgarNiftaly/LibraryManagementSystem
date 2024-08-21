package az.binary.library_management_system.dto.requests.library;

import az.binary.library_management_system.enums.LibraryStatus;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LibraryReadRequest {

    private Long id;
    private String name;
    private LibraryStatus status;
}
