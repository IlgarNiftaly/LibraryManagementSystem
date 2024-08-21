package az.binary.library_management_system.dto.responses.user;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserLogInResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Long fkBookId;
    private Long fkLibraryId;

}
