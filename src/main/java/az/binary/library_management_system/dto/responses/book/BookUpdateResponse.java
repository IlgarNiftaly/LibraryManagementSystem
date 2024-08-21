package az.binary.library_management_system.dto.responses.book;

import az.binary.library_management_system.enums.BookStatus;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookUpdateResponse {

    private Long id;
    private String name;
    private String author;
    private LocalDate createDateTime;
    private Long fkLibraryId;
    private Long fkUserId;
    private BookStatus status;

}
