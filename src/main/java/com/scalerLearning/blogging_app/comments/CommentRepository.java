package com.scalerLearning.blogging_app.comments;

import com.scalerLearning.blogging_app.comments.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Jagadesh Narayanaswamy on 01/02/24.
 * Author comment: Comments Repository
 */
@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
}
