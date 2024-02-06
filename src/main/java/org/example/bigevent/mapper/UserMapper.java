package org.example.bigevent.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.bigevent.pojo.Password;
import org.example.bigevent.pojo.User;

@Mapper
public interface UserMapper {

    @Select("select * from user where username=#{userName}")
    User findByUserName(String userName);
    @Insert("insert into user(username, password, create_time, update_time) " +
            " values (#{userName}, #{passWord}, now(), now())")
    void add(String userName, String passWord);

    @Update("update user set nickname=#{nickname}, email=#{email}, update_time=#{updateTime} where id=#{id}")
    void updateUserInfo(User user);

    @Update("update user set user_pic=#{avatarUrl}, update_time=now() where id=#{id}")
    void updateAvatar(String avatarUrl, Integer id);

    @Update("update user set password=#{password}, update_time=now() where id=#{id}")
    void updatePwd(String password, Integer id);
}
