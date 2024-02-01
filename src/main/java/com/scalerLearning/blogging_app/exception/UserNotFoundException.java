package com.scalerLearning.blogging_app.exception;

/**
 * Created by Jagadesh Narayanaswamy on 01/02/24.
 * Author comment: User not found exception handling class
 */
public class UserNotFoundException extends IllegalArgumentException {

    public UserNotFoundException(String username) {
        super("User with username: " + username + " not found !!");
    }

    public UserNotFoundException(Long userid) {
        super("User with userid: " + userid + " not found !!");
    }

}
