package az.binary.library_management_system.exceptions.library;

import az.binary.library_management_system.exceptions.GenericException;
import az.binary.library_management_system.exceptions.error.ErrorMessage;
import org.springframework.http.HttpStatus;

public class LibraryNotFoundException extends GenericException {
    public LibraryNotFoundException(){
        super(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(), ErrorMessage.LIBRARY_NOT_FOUND);
    }
}
