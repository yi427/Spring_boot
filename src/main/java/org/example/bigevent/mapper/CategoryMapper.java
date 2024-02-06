package org.example.bigevent.mapper;

import org.apache.ibatis.annotations.*;
import org.example.bigevent.pojo.Category;

import java.util.List;

@Mapper
public interface CategoryMapper {
    @Insert("insert into category(category_name, category_alias, create_user, create_time, update_time) " +
    " values (#{categoryName}, #{categoryAlias}, #{id}, now(), now())")
    void addCategory(String categoryName, String categoryAlias, Integer id);

    @Select("select * from category where create_user=#{id}")
    List<Category> findAllCategoryByUserId(Integer id);

    @Select("select * from category where id=#{id}")
    Category findDetailById(Integer id);

    @Update("update category set category_name=#{categoryName}, category_alias=#{categoryAlias}, update_time=now() where id=#{id}")
    void update(Category category);

    @Delete("delete from category where id=#{id}")
    void deleteById(Integer id);
}
