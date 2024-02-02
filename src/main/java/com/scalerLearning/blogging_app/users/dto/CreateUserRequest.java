package com.scalerLearning.blogging_app.users.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.springframework.lang.NonNull;

/**
 * Created by Jagadesh Narayanaswamy on 02/02/24.
 * Author comment: Create User Request DTO
 */
@Data
@Setter(AccessLevel.NONE)
public class CreateUserRequest {

    @NonNull
    private String username;
    @NonNull
    private String password;
    @NonNull
    private String email;

}
