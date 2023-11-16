package com.example.mybatisdemo.mapper;

import com.example.mybatisdemo.pojo.user;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from mybatis.user where id = #{id}")
    public user findById(Integer id);
}
