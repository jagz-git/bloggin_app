package com.scalerLearning.blogging_app.articles;

import com.scalerLearning.blogging_app.articles.dto.CreateArticleRequest;
import com.scalerLearning.blogging_app.articles.dto.UpdateArticleRequest;
import com.scalerLearning.blogging_app.exception.ArticleNotFoundException;
import com.scalerLearning.blogging_app.exception.UserNotFoundException;
import com.scalerLearning.blogging_app.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jagadesh Narayanaswamy on 01/02/24.
 * Author comment: Service class
 */
@Service
public class ArticleService {
    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    UserRepository userRepository;

    public Iterable<ArticleEntity> getAllArticles() {
        return articleRepository.findAll();
    }

    public ArticleEntity getArticlesBySlug(String slug) {
        var article = articleRepository.findBySlug(slug);
        if (article == null) {
            throw new ArticleNotFoundException(slug);
        }
        return article;
    }

    public ArticleEntity createArticle(CreateArticleRequest article, Long authorId) {
        var author = userRepository.findById(authorId).orElseThrow(() -> new UserNotFoundException(authorId));
        ArticleEntity articleEntity = ArticleEntity.builder()
                .title(article.getTitle())
                .slug(article.getTitle().toLowerCase().replaceAll("\\s", "-"))
                .body(article.getBody())
                .subtitle(article.getSubtitle())
                .author(author)
                .build();
        return articleRepository.save(articleEntity);
    }

    public ArticleEntity updateArticle(Long articleId, UpdateArticleRequest request) {
        var article = articleRepository.findById(articleId).orElseThrow(() -> new ArticleNotFoundException(articleId));
        if (request.getTitle() != null) {
            article.setTitle(request.getTitle());
            article.setSlug(request.getTitle().toLowerCase().replaceAll("\\s", "-"));
        }

        if (request.getBody() != null) {
            article.setBody(request.getBody());
        }

        if (request.getSubtitle() != null) {
            article.setSubtitle(request.getSubtitle());
        }

        return articleRepository.save(article);
    }

}
