package az.binary.library_management_system.exceptions.user;

import az.binary.library_management_system.exceptions.GenericException;
import az.binary.library_management_system.exceptions.error.ErrorMessage;
import org.springframework.http.HttpStatus;

public class UserFoundException extends GenericException{

    public UserFoundException(){
        super(HttpStatus.FOUND, HttpStatus.FOUND.value(), ErrorMessage.USER_FOUND);
    }

}
