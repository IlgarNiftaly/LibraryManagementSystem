package az.binary.library_management_system.exceptions.library;

import az.binary.library_management_system.exceptions.GenericException;
import az.binary.library_management_system.exceptions.error.ErrorMessage;
import org.springframework.http.HttpStatus;

public class LibraryFoundException extends GenericException {
    public LibraryFoundException(){
        super(HttpStatus.FOUND, HttpStatus.FOUND.value(), ErrorMessage.LIBRARY_FOUND);
    }
}
