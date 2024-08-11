package az.binary.library_management_system.dto.requests;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateRequest {

    @NotBlank(message = "FirstName cannot be request")
    private String firstName;

    @NotBlank(message = "LastName cannot be request")
    private String lastName;

    @NotBlank(message = "Email cannot be request")
    private String email;

    @NotBlank(message = "Password cannot be request")
    private String password;

}
