package com.scalerLearning.blogging_app.users;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * Created by Jagadesh Narayanaswamy on 01/02/24.
 * Author comment: User Repository Test class
 */

@DataJpaTest
@ActiveProfiles("test")
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    @Order(1)
    void canCreateUsers() {
        var user = UserEntity.builder()
                .username("NewUser")
                .email("newuser@blog.com")
                .build();
        userRepository.save(user);
    }

    @Test
    @Order(2)
    void canFindUsers() {
        var user = UserEntity.builder()
                .username("TestUser")
                .email("testuser@blog.com")
                .build();
        userRepository.save(user);
        var users = userRepository.findAll();
        Assertions.assertEquals(1, users.size());
    }

}
