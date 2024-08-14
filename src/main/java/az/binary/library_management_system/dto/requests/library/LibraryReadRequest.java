package az.binary.library_management_system.dto.requests.library;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LibraryReadRequest {

    private Long id;
    private String name;
    private String status;
}
