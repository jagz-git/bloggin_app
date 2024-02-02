package com.scalerLearning.blogging_app.comments;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jagadesh Narayanaswamy on 02/02/24.
 * Author comment: Controller class to have HTTP methods for accessing endpoints
 */

@RestController
@RequestMapping("/articles/{article-slug}/comments")
public class CommentController {
    @GetMapping("")
    public String getComments() {
        return "Comments";
    }
}
