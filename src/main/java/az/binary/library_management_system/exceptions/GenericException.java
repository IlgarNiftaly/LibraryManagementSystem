package az.binary.library_management_system.exceptions;

import lombok.*;
import org.springframework.http.HttpStatus;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GenericException extends RuntimeException{

    private HttpStatus httpStatus;
    private Integer code;
    private String message;

}
