package com.scalerLearning.blogging_app.users.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.springframework.lang.NonNull;

/**
 * Created by Jagadesh Narayanaswamy on 02/02/24.
 * Author comment: Login User Request DTO
 */
@Data
@Setter(AccessLevel.NONE)
public class LoginUserRequest {

    @NonNull
    private String username;
    @NonNull
    private String password;

}
