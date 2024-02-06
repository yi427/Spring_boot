package org.example.bigevent.service.impl;

import jakarta.validation.constraints.NotNull;
import org.example.bigevent.mapper.UserMapper;
import org.example.bigevent.pojo.User;
import org.example.bigevent.service.UserService;
import org.example.bigevent.utlities.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User findByUserName(String userName) {
        return userMapper.findByUserName(userName);
    }

    @Override
    public void register(String userName, String passWord) {
        var passWordEncoder = new BCryptPasswordEncoder();
        userMapper.add(userName, passWordEncoder.encode(passWord));
    }

    @Override
    public void updateUserInfo(User user) {
        user.setUpdateTime(LocalDateTime.now());
        userMapper.updateUserInfo(user);
    }

    @Override
    public void updateAvatar(String avatarUrl) {
        Map<String, Object> f = ThreadLocalUtil.get();
        userMapper.updateAvatar(avatarUrl, (Integer) f.get("id"));
    }

    @Override
    public void updatePwd(String password, @NotNull Integer id) {
        userMapper.updatePwd(password, id);
    }
}
