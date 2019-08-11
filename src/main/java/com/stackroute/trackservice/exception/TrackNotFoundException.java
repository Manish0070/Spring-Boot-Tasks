package com.stackroute.trackservice.exception;
//TrackNotFoundException Extending Main Exception
public class TrackNotFoundException extends Exception {
    String message;
    public TrackNotFoundException() {
    }
//Constructor
    public TrackNotFoundException(String message) {
        super(message);
        this.message=message;
    }
}
