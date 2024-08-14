package az.binary.library_management_system.dto.requests.book;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookUpdateRequest {

    private Long id;

    @NotBlank(message = "name cannot be blank")
    private String name;

    @NotBlank(message = "author cannot be blank")
    private String author;

    @NotBlank(message = "createDateTime cannot be blank")
    private LocalDateTime createDateTime;

    @NotBlank(message = "fkLibraryId cannot be blank")
    private Long fkLibraryId;

    @NotBlank(message = "fkUserId cannot be blank")
    private Long fkUserId;

    @NotBlank(message = "status cannot be blank")
    private String status;

}
