package com.scalerLearning.blogging_app.users.dto;

import lombok.Data;

/**
 * Created by Jagadesh Narayanaswamy on 02/02/24.
 * Author comment: User response DTO
 */

@Data
public class UserResponse {
    private Long id;
    private String username;
    private String email;
    private String bio;
    private String image;
}
