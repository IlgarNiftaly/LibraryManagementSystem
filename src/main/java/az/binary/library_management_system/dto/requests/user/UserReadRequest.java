package az.binary.library_management_system.dto.requests.user;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserReadRequest {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;

}
