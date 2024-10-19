package baykov.daniel.logs.exception;

import baykov.daniel.logs.model.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchFileException.class)
    public ResponseEntity<ResponseMessage> handleNoSuchFileException(NoSuchFileException ex) {
        ResponseMessage error = ResponseMessage.error(
                "File or directory not found",
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<ResponseMessage> handleFileNotFoundException(FileNotFoundException ex) {
        ResponseMessage error = ResponseMessage.error(
                "File does not exist or is a directory",
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<ResponseMessage> handleIOException(IOException ex) {
        ResponseMessage error = ResponseMessage.error(
                "Error reading file or directory: ",
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value()
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ResponseMessage> handleIllegalArgumentException(IllegalArgumentException ex) {
        ResponseMessage error = ResponseMessage.error(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value()
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseMessage> handleException(Exception ex) {
        ResponseMessage error = ResponseMessage.error(
                ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value()
        );
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}