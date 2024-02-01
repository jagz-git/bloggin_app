package com.scalerLearning.blogging_app.exception;

/**
 * Created by Jagadesh Narayanaswamy on 01/02/24.
 * Author comment: Article Not Found Exception
 */
public class ArticleNotFoundException extends IllegalArgumentException {
    public ArticleNotFoundException(String slug) {
        super("Article " + slug + " not found !!");
    }

    public ArticleNotFoundException(Long articleId) {
        super("Article with article id: " + articleId + " not found !!");
    }
}
