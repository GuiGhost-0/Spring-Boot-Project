package com.guighost;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.guighost.pojo.User;
import com.guighost.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;


@SpringBootTest
class SpringbootRedisApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void testRedisUtil(){
        redisUtil.set("heiheihei","GuiGhost");
        System.out.println(redisUtil.get("username"));
    }


    @Test
    void contextLoads() {
        /**
         * redisTemplate    操作不同的数据类型，api和我们的指令是一样的
         * opsForValue 操作字符串    类似String
         * opsForList   操作List    类似List
         * opsForSet
         * opsForHash
         * opsForZSet
         * opsForGeo
         * opsForHyperLogLog
         */
        // 除了基本的操作，我们常用的方法都可以直接通过redisTemplate操作，如事务和基本的crud
        //获取redis的连接对象
//        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
//        connection.flushDb();
//        connection.flushAll();

        redisTemplate.opsForValue().set("key","guigui");
        System.out.println(redisTemplate.opsForValue().get("key"));
    }

    @Test
    void test() throws JsonProcessingException {
        //真实开发一般使用Json来传递对象
        User guigui = new User("guigui", 3);
//        String jsonUser = new ObjectMapper().writeValueAsString(guigui);
        redisTemplate.opsForValue().set("user",guigui);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }

}
