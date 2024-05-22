package com.project.api.exceptions;

public class UserAlreadyExistException extends Exception {
    public UserAlreadyExistException (String message) {
        super (message);
    }
}
