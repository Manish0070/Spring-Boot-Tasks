package com.stackroute.trackservice.exception;
import com.stackroute.trackservice.exception.TrackAlreadyExistException;
import com.stackroute.trackservice.exception.TrackNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalExceptions {
    @ExceptionHandler(TrackNotFoundException.class)
    public ResponseEntity<?> noTrackFound(TrackNotFoundException e){
        return new ResponseEntity<String>("Track Not Found", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(TrackAlreadyExistException.class)
    public ResponseEntity<?> idAlreadyExists(TrackAlreadyExistException ex){
        return new ResponseEntity<String>("Track Already exists",HttpStatus.NOT_ACCEPTABLE);
    }
}