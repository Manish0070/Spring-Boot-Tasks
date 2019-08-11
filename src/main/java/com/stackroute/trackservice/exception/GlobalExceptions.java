package com.stackroute.trackservice.exception;
import com.stackroute.trackservice.exception.TrackAlreadyExistException;
import com.stackroute.trackservice.exception.TrackNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
//GLobalExceptions
public class GlobalExceptions {
    //Track Not Found Exception
    @ExceptionHandler(TrackNotFoundException.class)
    public ResponseEntity<?> noTrackFound(TrackNotFoundException e){
        return new ResponseEntity<String>("Track Not Found", HttpStatus.NOT_FOUND);
    }
    //Track Already Exists Exception
    @ExceptionHandler(TrackAlreadyExistException.class)
    public ResponseEntity<?> idAlreadyExists(TrackAlreadyExistException ex){
        return new ResponseEntity<String>("Track Already exists",HttpStatus.NOT_ACCEPTABLE);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?>internal(Exception e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}