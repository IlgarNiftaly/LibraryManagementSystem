package az.binary.library_management_system.dto.requests.user;

import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserLogInRequest {

    @NotBlank
    private String email;

    @NotBlank
    private String password;

}
