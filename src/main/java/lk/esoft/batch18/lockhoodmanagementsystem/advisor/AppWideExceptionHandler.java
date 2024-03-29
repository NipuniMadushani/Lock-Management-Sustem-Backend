package lk.esoft.batch18.lockhoodmanagementsystem.advisor;
import lk.esoft.batch18.lockhoodmanagementsystem.exception.KeyAlreadyExistsException;
import lk.esoft.batch18.lockhoodmanagementsystem.exception.NotFoundException;
import lk.esoft.batch18.lockhoodmanagementsystem.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity handleNotFoundException(NotFoundException e){
        return new ResponseEntity(new StandardResponse(404,"Error",e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(KeyAlreadyExistsException.class)
    public ResponseEntity handleKeyAlreadyExistsException(KeyAlreadyExistsException e){
        return new ResponseEntity(new StandardResponse(404,"Error",e.getMessage()), HttpStatus.ALREADY_REPORTED);
    }
}
