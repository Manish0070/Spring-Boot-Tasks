package com.stackroute.trackservice.exception;

//TrackAlreadyExistException Extending Main Exception Class
public class TrackAlreadyExistException extends Exception {
    private String message;

    public TrackAlreadyExistException() {
    }

    //Constructor
    public TrackAlreadyExistException(String message) {
        super(message);
        this.message = message;
    }
}
