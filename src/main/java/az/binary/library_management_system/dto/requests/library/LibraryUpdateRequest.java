package az.binary.library_management_system.dto.requests.library;

import az.binary.library_management_system.enums.LibraryStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LibraryUpdateRequest {

    private Long id;

    @NotBlank(message = "name cannot be blank")
    private String name;

    @NotBlank(message = "fkBookId cannot be blank")
    private Long fkBookId;

    @NotBlank(message = "fkUserId cannot be blank")
    private Long fkUserId;

    @NotBlank(message = "status cannot be blank")
    private LibraryStatus status;

}
