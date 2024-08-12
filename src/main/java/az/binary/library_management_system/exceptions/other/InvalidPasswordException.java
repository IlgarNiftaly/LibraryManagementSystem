package az.binary.library_management_system.exceptions.other;

import az.binary.library_management_system.exceptions.GenericException;
import az.binary.library_management_system.exceptions.error.ErrorMessage;
import org.springframework.http.HttpStatus;

public class InvalidPasswordException extends GenericException {

    public InvalidPasswordException(){
        super(HttpStatus.UNAUTHORIZED, HttpStatus.UNAUTHORIZED.value(), ErrorMessage.INVALID_PASSWORD_EXCEPTION);
    }

}
