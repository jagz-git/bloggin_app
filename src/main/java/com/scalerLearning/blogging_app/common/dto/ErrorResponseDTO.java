package com.scalerLearning.blogging_app.common.dto;

import lombok.Builder;
import lombok.Data;

/**
 * Created by Jagadesh Narayanaswamy on 02/02/24.
 * Author comment: Error Response class
 */


@Data
@Builder
public class ErrorResponseDTO {

    private String message;
    private String details;

}
