package az.binary.library_management_system.dto.responses;

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

}
