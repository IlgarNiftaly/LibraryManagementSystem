package az.binary.library_management_system.dto.requests.book;

import az.binary.library_management_system.enums.BookStatus;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookReadRequest {

    private Long id;
    private String name;
    private String author;
    private LocalDate createDateTime;
    private Long fkLibraryId;
    private Long fkUserId;
    private BookStatus status;

}
