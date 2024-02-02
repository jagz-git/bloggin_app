package com.scalerLearning.blogging_app.exception;

/**
 * Created by Jagadesh Narayanaswamy on 02/02/24.
 * Author comment: Invalid Credentials exception class
 */
public class InvalidCredentialsException extends IllegalArgumentException {

    public InvalidCredentialsException() {
        super("Invalid username or password combination");
    }

}
