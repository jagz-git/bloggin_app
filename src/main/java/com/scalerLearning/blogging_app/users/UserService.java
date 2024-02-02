package com.scalerLearning.blogging_app.users;

import com.scalerLearning.blogging_app.exception.InvalidCredentialsException;
import com.scalerLearning.blogging_app.exception.UserNotFoundException;
import com.scalerLearning.blogging_app.security.JWTService;
import com.scalerLearning.blogging_app.users.dto.CreateUserRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by Jagadesh Narayanaswamy on 01/02/24.
 * Author comment: Service class
 */


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    PasswordEncoder passwordEncoder;


    public UserEntity createUser(String username, String password, String email
    ) {
        var newUser = UserEntity.builder()
                .username(username)
//                .password(password) //TODO: encrypt password
                .email(email)
                .build();
        return userRepository.save(newUser);
    }

    //    with DTO
    public UserEntity createUserWithDTO(CreateUserRequest createUserRequest) {
        UserEntity newUser = modelMapper.map(createUserRequest, UserEntity.class);
        newUser.setPassword(passwordEncoder.encode(createUserRequest.getPassword()));

        /*var newUser = UserEntity.builder()
                .username(createUserRequest.getUsername())
//                .password(password) //TODO: encrypt password
                .email(createUserRequest.getEmail())
                .build();*/
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
        var passwordMatch = passwordEncoder.matches(password, user.getPassword());
        if (!passwordMatch) {
            throw new InvalidCredentialsException();
        }
        return user;
    }

}
