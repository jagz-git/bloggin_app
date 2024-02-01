package com.scalerLearning.blogging_app.articles;

import com.scalerLearning.blogging_app.articles.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Jagadesh Narayanaswamy on 01/02/24.
 * Author comment: Articles Repository
 */
@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {
}
