package az.binary.library_management_system.exceptions.book;

import az.binary.library_management_system.exceptions.GenericException;
import az.binary.library_management_system.exceptions.error.ErrorMessage;
import org.springframework.http.HttpStatus;

public class BookAuthorNotFoundException extends GenericException {
    public BookAuthorNotFoundException(){
        super(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(), ErrorMessage.BOOK_AUTHOR_NOT_FOUND);
    }
}
