package az.binary.library_management_system.dto.responses.library;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LibraryUpdateResponse {

    private Long id;
    private String name;
    private String status;

}
