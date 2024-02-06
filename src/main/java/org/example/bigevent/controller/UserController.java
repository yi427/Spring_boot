package org.example.bigevent.controller;

import jakarta.validation.constraints.Pattern;
import org.example.bigevent.pojo.Password;
import org.example.bigevent.pojo.Result;
import org.example.bigevent.pojo.User;
import org.example.bigevent.service.UserService;
import org.example.bigevent.utlities.JwtUtil;
import org.example.bigevent.utlities.ThreadLocalUtil;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
@Validated
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @PostMapping("register")
    public Result register(@Pattern(regexp = "^\\S{5,16}$", message = "用户名长度需要5-16个字符") String userName,
                           @Pattern(regexp = "^\\S{5,16}$", message = "密码长度需要5-16个字符") String passWord) {
        var user = userService.findByUserName(userName);
        if (user == null) {
            userService.register(userName, passWord);
            return Result.success();
        }
        return Result.error("用户名称已被占用");
    }
    @PostMapping("login")
    public Result login(@Pattern(regexp = "^\\S{5,16}$", message = "用户不存在") String userName,
                        @Pattern(regexp = "^\\S{5,16}$", message = "密码错误") String passWord) {
        // 获得 userName 对应的 用户
        var user = userService.findByUserName(userName);
        if (user == null) return Result.error("用户不存在");
        // 声明了一个 可以用来 匹配 明文跟密文 的变量
        var passWordEncoder = new BCryptPasswordEncoder();
        // 判断 用户输入的密码 是否 跟 数据库中的 加密数据 匹配
        if (!passWordEncoder.matches(passWord, user.getPassword()))
            return Result.error("密码不匹配");
        // 目的 获得 用户的 token  并且 返回
        Map<String, Object> f = new HashMap<>();
        f.put("id", user.getId());
        f.put("userName", user.getUsername());
        var token = JwtUtil.genToken(f);
        var op = stringRedisTemplate.opsForValue();
        op.set(token, token, 12, TimeUnit.HOURS);
        return Result.success(token);
    }

    @GetMapping("userInfo")
    public Result userInfo() {
        // 根据 token 得到 用户的 ID JWT
        Map<String, Object> map = ThreadLocalUtil.get();
        String userName = (String) map.get("userName");// AIT + Enter
        var user = userService.findByUserName(userName);
        return Result.success(user);
    }

    @PutMapping("update")
    public Result update(@RequestBody @Validated User user) {
        userService.updateUserInfo(user);
        return Result.success();
    }

    @PatchMapping("updateAvatar")
    public Result updateAvatar(@RequestParam @URL String avatarUrl) {
        userService.updateAvatar(avatarUrl);
        return Result.success();
    }

    @PatchMapping("updatePwd")
    public Result updatePassword(@RequestBody @Validated Password password, @RequestHeader("Authorization") String token) { // @RequestBody Map<String, String> password
        Map<String, Object> f = ThreadLocalUtil.get(); // 用户信息
        var user = userService.findByUserName((String) f.get("userName"));
        var passWordEncoder = new BCryptPasswordEncoder();
        if (!passWordEncoder.matches(password.getOld_pwd(), user.getPassword()))
            return Result.error("原密码错误");
        if (!password.getNew_pwd().equals(password.getRe_pwd()))
            return Result.error("两次密码不一致");
        if (passWordEncoder.matches(password.getNew_pwd(), user.getPassword()))
            return Result.error("旧密码与原密码相同");
        userService.updatePwd(passWordEncoder.encode(password.getNew_pwd()), user.getId());
        stringRedisTemplate.opsForValue().getOperations().delete(token);
        return Result.success();
    }

}
