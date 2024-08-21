package az.binary.library_management_system.dto.requests.book;

import az.binary.library_management_system.enums.BookStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

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
    private LocalDate createDateTime;

    @NotBlank(message = "fkLibraryId cannot be blank")
    private Long fkLibraryId;

    @NotBlank(message = "fkUserId cannot be blank")
    private Long fkUserId;

    @NotBlank(message = "status cannot be blank")
    private BookStatus status;

}
