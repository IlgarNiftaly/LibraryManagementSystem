package az.binary.library_management_system.exceptions.book;

import az.binary.library_management_system.exceptions.GenericException;
import az.binary.library_management_system.exceptions.error.ErrorMessage;
import org.springframework.http.HttpStatus;

public class BookFoundException extends GenericException {
    public BookFoundException(){
        super(HttpStatus.FOUND, HttpStatus.FOUND.value(), ErrorMessage.BOOK_FOUND);
    }
}
