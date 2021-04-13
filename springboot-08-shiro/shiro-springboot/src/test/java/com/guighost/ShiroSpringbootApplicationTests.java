package com.guighost;

import com.guighost.entity.User;
import com.guighost.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShiroSpringbootApplicationTests {
    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
        User guigui = userService.queryUserByName("guigui");
        System.out.println(guigui);
    }

}
