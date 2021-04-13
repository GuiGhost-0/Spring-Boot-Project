package com.guighost;

import com.guighost.entity.User;
import com.guighost.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class Springboot05MybatisApplicationTests {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private UserMapper mapper;

    @Test
    void contextLoads() throws SQLException {
//        System.out.println(dataSource.getConnection());
//        System.out.println(dataSource.getClass());
        List<User> users = mapper.getUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }

}
