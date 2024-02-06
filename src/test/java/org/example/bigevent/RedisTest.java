package org.example.bigevent;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;
/*
public class RedisTest {

    StringRedisTemplate stringRedisTemplate;
    @Test
    void set() {
        var f = stringRedisTemplate.opsForValue();
        f.set("id", "2", 20, TimeUnit.SECONDS);
    }

    @Test
    void get() {
        var f = stringRedisTemplate.opsForValue();
        System.out.println(f.get("username"));
    }
}
*/