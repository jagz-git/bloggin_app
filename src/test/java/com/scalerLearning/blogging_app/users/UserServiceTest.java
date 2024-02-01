package com.scalerLearning.blogging_app.users;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * Created by Jagadesh Narayanaswamy on 01/02/24.
 * Author comment:
 */

@SpringBootTest
@ActiveProfiles("test")
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    void canCreateUsers() {
        var user = userService.createUser("John", "***", "john@blog.com");
        Assertions.assertNotNull(user);
        Assertions.assertEquals("John", user.getUsername());
    }
}
