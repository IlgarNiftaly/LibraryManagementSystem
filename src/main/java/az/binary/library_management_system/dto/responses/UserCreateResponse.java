package az.binary.library_management_system.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateResponse {

    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private String password;

}
