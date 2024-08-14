package az.binary.library_management_system.dto.requests.book;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookCreateRequest {

    private String name;
    private String author;
    private LocalDateTime createDateTime;
//    private Long fkLibraryId;
//    private Long fkUserId;
    private String status;


}
