package com.scalerLearning.blogging_app.articles;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jagadesh Narayanaswamy on 02/02/24.
 * Author comment: Controller class to have HTTP methods for accessing endpoints
 */

@RestController
@RequestMapping("/articles")
public class ArticleController {
    @GetMapping("")
    public String getArticles() {
        return "Articles";
    }
}
