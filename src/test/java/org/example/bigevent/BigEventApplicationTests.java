package org.example.bigevent;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.example.bigevent.utlities.JwtUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/*
@SpringBootTest
class BigEventApplicationTests {

    @Test
    void contextLoads() {
        Map<String, String> f = new HashMap<>();
        // (String) Key - (String) Val
        //  old_pwd              123456
        //  new_pwd              234567
        //  re_pwd               234567
        f.put("old_pwd", "123456");
        f.put("new_pwd", "234567");
        f.put("re_pwd", "234567"); // vim
        System.out.println(f.get("old_pwd"));
        System.out.println(f.get("new_pwd"));
    }

    // 测试 jwt 令牌
    @Test
    void jwtTest() throws NoSuchAlgorithmException, InvalidKeyException {
        Map<String, Object> f = new HashMap<>();
        f.put("ID", 1);
        f.put("UserName", "涛蛋");
        // 链式调用
        String token = JWT.create() // Builder
                .withClaim("user", f) // Builder
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 12)) // Builder
                .sign(Algorithm.HMAC256("love"));
        System.out.println(token);
    //     String message = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyIjp7IlVzZXJOYW1lIjoi5rab6JuLIiwiSUQiOjF9fQ";
    //     String key = "love";
    //     Mac mac = Mac.getInstance("HmacSHA256");
    //     SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), "HmacSHA256");
    //     mac.init(secretKeySpec);
    //     byte[] signature = mac.doFinal(message.getBytes());

    // // 使用 Base64 编码签名
    //     String encodedSignature = Base64.getEncoder().encodeToString(signature);
    //     System.out.println(encodedSignature);
    }

    @Test
    void parseToken() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjbGFpbXMiOnsiaWQiOjgsInVzZXJOYW1lIjoiemhhbmdzYW4ifSwiZXhwIjoxNzA1NjY4MTc2fQ.mtBVb88EhiUeCNQE9DMs30yKuH3cO-oyUTU8RZCXsPE";
    }
}
*/