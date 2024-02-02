package com.scalerLearning.blogging_app.articles;

import com.scalerLearning.blogging_app.users.UserEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Jagadesh Narayanaswamy on 02/02/24.
 * Author comment: Controller class to have HTTP methods for accessing endpoints
 */

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @GetMapping("")
    public String getArticles() {
        return "Get all articles";
    }

    @GetMapping("/{id}")
    public String getArticleById(@PathVariable("id") String id) {
        return "Get article with id: " + id;
    }

    @PostMapping("")
    public String createArticle(@AuthenticationPrincipal UserEntity userEntity) {
        return "Create Article called by: " + userEntity.getUsername();
    }

}
