package org.example.bigevent.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.bigevent.utlities.JwtUtil;
import org.example.bigevent.utlities.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

@Component
@CrossOrigin(origins = "*")
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // get the token
        final String token = request.getHeader("Authorization");
        try {
            if (stringRedisTemplate.opsForValue().get(token) == null)
               throw new RuntimeException("Redis don't find the token");
            final Map<String, Object> f = JwtUtil.parseToken(token);
            ThreadLocalUtil.set(f);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            response.setStatus(401);
            return false;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        ThreadLocalUtil.remove();
    }
}
