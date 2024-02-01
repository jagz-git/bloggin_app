package com.scalerLearning.blogging_app.users;

import com.scalerLearning.blogging_app.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jagadesh Narayanaswamy on 01/02/24.
 * Author comment: Service class
 */

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserEntity createUser(String username, String password, String email
    ) {
        var newUser = UserEntity.builder()
                .username(username)
//                .password(password) //TODO: encrypt password
                .email(email)
                .build();
        return userRepository.save(newUser);
    }

    public UserEntity getUser(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException(username));
    }

    public UserEntity getUser(Long userid) {
        return userRepository.findById(userid).orElseThrow(() -> new UserNotFoundException(userid));
    }

    public UserEntity loginUser(String username, String password) {
        var user = userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException(username));
//        TODO: check password
        return user;
    }

}

