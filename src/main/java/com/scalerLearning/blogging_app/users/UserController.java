package com.scalerLearning.blogging_app.users;

import com.scalerLearning.blogging_app.common.dto.ErrorResponseDTO;
import com.scalerLearning.blogging_app.exception.InvalidCredentialsException;
import com.scalerLearning.blogging_app.exception.UserNotFoundException;
import com.scalerLearning.blogging_app.security.JWTService;
import com.scalerLearning.blogging_app.users.dto.CreateUserRequest;
import com.scalerLearning.blogging_app.users.dto.LoginUserRequest;
import com.scalerLearning.blogging_app.users.dto.UserResponse;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

/**
 * Created by Jagadesh Narayanaswamy on 02/02/24.
 * Author comment: Controller class to have HTTP methods for accessing endpoints
 */

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    private final ModelMapper modelMapper;

    private final JWTService jwtService;

    public UserController(UserService userService, ModelMapper modelMapper, JWTService jwtService) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.jwtService = jwtService;
    }

    @PostMapping("")
    ResponseEntity<UserResponse> signUpUser(@RequestBody CreateUserRequest createUserRequest) {
        UserEntity savedUser = userService.createUserWithDTO(createUserRequest);
        URI savedUserURI = URI.create("/users/" + savedUser.getId());
        var savedUserResponse = modelMapper.map(savedUser, UserResponse.class);
        savedUserResponse.setToken(jwtService.createJWT(savedUser.getId()));
        return ResponseEntity.created(savedUserURI).body(savedUserResponse);
    }

    @PostMapping("/login")
    ResponseEntity<UserResponse> login(@RequestBody LoginUserRequest loginUserRequest) {
        UserEntity savedUser = userService.loginUser(loginUserRequest.getUsername(), loginUserRequest.getPassword());
        UserResponse savedUserResponse = modelMapper.map(savedUser, UserResponse.class);
        savedUserResponse.setToken(jwtService.createJWT(savedUser.getId()));
        return ResponseEntity.ok(savedUserResponse);
    }

    /*@ExceptionHandler(Exception.class)
    ResponseEntity<String> handleUserNotFoundException(UserNotFoundException userNotFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userNotFoundException.getMessage());
    }*/

    @ExceptionHandler({
            UserNotFoundException.class,
            InvalidCredentialsException.class,
            IllegalArgumentException.class
    })
    ResponseEntity<ErrorResponseDTO> handleUserFoundException(Exception exception) {
        String message;
        String details;
        HttpStatus status;

        if (exception instanceof UserNotFoundException) {
            message = exception.getMessage();
            details = "User details were not found in DB!!";
            status = HttpStatus.NOT_FOUND;
        } else if (exception instanceof InvalidCredentialsException) {
            message = exception.getMessage();
            details = "Enter correct credentials";
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        } else {
            message = "Some error occurred";
            details = "Check stack trace for complete details";
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        ErrorResponseDTO errorResponseDTO = ErrorResponseDTO
                .builder()
                .message(message)
                .details(details)
                .build();
        return ResponseEntity.status(status).body(errorResponseDTO);

        /*
        // One more way of error handling
        if (exception instanceof UserNotFoundException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    ErrorResponseDTO.builder().message(exception.getMessage()).build()
            );
        }
        ErrorResponseDTO internalServerError = ErrorResponseDTO.builder()
                .message("Some error occurred")
                .details("Check stack trace for full details")
                .build();
        return ResponseEntity.internalServerError().body(internalServerError);*/
    }

}
