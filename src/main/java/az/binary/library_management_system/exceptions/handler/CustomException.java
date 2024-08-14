package az.binary.library_management_system.exceptions.handler;

import az.binary.library_management_system.exceptions.library.LibraryFoundException;
import az.binary.library_management_system.exceptions.library.LibraryNotFoundException;
import az.binary.library_management_system.exceptions.user.UserFoundException;
import az.binary.library_management_system.exceptions.other.InvalidPasswordException;
import az.binary.library_management_system.exceptions.user.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.*;


@RestControllerAdvice
@Slf4j
public class CustomException {

    @ExceptionHandler(UserFoundException.class)
    @ResponseStatus(FOUND)
    public ProblemDetail handlerUserFoundException(Exception ex){
        log.info("handlerUserFoundException {}", ex.getMessage());
        return ProblemDetail.forStatusAndDetail(FOUND, ex.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public ProblemDetail handlerUserNotFoundException(Exception ex){
        log.info("handlerUserNotFoundException {}", ex.getMessage());
        return ProblemDetail.forStatusAndDetail(NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(LibraryFoundException.class)
    @ResponseStatus(FOUND)
    public ProblemDetail handlerLibraryFoundException(Exception ex){
        log.info("handlerLibraryFoundException {}", ex.getMessage());
        return ProblemDetail.forStatusAndDetail(FOUND, ex.getMessage());
    }

    @ExceptionHandler(LibraryNotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public ProblemDetail handlerLibraryNotFoundException(Exception ex){
        log.info("handlerLibraryNotFoundException {}", ex.getMessage());
        return ProblemDetail.forStatusAndDetail(NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(InvalidPasswordException.class)
    @ResponseStatus(UNAUTHORIZED)
    public ProblemDetail handlerInvalidPasswordException(Exception ex){
        log.info("handlerInvalidPasswordException {}", ex.getMessage());
        return ProblemDetail.forStatusAndDetail(UNAUTHORIZED, ex.getMessage());
    }

}
