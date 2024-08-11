package az.binary.library_management_system.dto.responses;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class UserCreateResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

}
