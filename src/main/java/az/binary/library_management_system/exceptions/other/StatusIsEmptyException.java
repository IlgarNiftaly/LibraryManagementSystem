package az.binary.library_management_system.exceptions.other;

import az.binary.library_management_system.exceptions.GenericException;
import az.binary.library_management_system.exceptions.error.ErrorMessage;
import org.springframework.http.HttpStatus;

public class StatusIsEmptyException extends GenericException {
    public StatusIsEmptyException(){
        super(HttpStatus.NO_CONTENT, HttpStatus.NO_CONTENT.value(), ErrorMessage.STATUS_IS_EMPTY);
    }
}
