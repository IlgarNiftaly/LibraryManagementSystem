package az.binary.library_management_system.exceptions.book;

import az.binary.library_management_system.exceptions.GenericException;
import az.binary.library_management_system.exceptions.error.ErrorMessage;
import org.springframework.http.HttpStatus;

public class BookNotFoundException extends GenericException {
    public BookNotFoundException(){
        super(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(), ErrorMessage.BOOK_NOT_FOUND);
    }
}
