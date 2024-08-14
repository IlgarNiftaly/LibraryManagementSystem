package az.binary.library_management_system.dto.requests.library;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LibraryCreateRequest {

    private String name;
    private Long fkBookId;
    private Long fkUserId;
    private String status;

}
