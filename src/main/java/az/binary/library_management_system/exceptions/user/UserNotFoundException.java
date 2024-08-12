package az.binary.library_management_system.exceptions.user;

import az.binary.library_management_system.exceptions.GenericException;
import az.binary.library_management_system.exceptions.error.ErrorMessage;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends GenericException {
    public UserNotFoundException(){
        super(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(), ErrorMessage.USER_NOT_FOUND);
    }
}
