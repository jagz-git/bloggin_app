package com.scalerLearning.blogging_app.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jagadesh Narayanaswamy on 01/02/24.
 * Author comment: Service class
 */
@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;
}
