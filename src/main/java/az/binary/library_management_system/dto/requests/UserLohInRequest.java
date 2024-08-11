package az.binary.library_management_system.dto.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserLohInRequest {

    @NotBlank
    private String email;

    @NotBlank
    private String password;

}
