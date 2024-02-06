package org.example.bigevent.mapper;

import org.apache.ibatis.annotations.*;
import org.example.bigevent.pojo.Article;

import java.util.List;

@Mapper
public interface ArticleMapper {
    @Insert("insert into article(title, content, cover_img, state, category_id, create_user, create_time, update_time) " +
            "values (#{title}, #{content}, #{coverImg}, #{state}, #{categoryId}, #{createUser}, now(), now())")
    void add(Article article);

    List<Article> list(Integer id, Integer categoryId, String state);


    @Select("select * from article where id=#{id}")
    Article findDetailById(Integer id);

    @Update("update article set title=#{title}, content=#{content}," +
            " cover_img=#{coverImg}, state=#{state}, category_id=#{categoryId}," +
            " update_time=#{updateTime} where id=#{id}")
    void update(Article article);

    @Delete("delete from article where id=#{id}")
    void delete(Integer id);

    @Select("select * from article where state=#{state}")
    List<Article> findByState(String state);

    @Select("select * from article")
    List<Article> all();
}
