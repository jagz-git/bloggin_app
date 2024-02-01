package com.scalerLearning.blogging_app.users;

import com.scalerLearning.blogging_app.users.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Jagadesh Narayanaswamy on 01/02/24.
 * Author comment: Users Repository
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
