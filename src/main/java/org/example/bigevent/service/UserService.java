package org.example.bigevent.service;

import jakarta.validation.constraints.NotNull;
import org.example.bigevent.pojo.User;

public interface UserService {
    User findByUserName(String userName);

    void register(String userName, String passWard);

    void updateUserInfo(User user);

    void updateAvatar(String avatarUrl);

    void updatePwd(String password, @NotNull Integer id);
}
