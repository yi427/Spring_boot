package org.example.bigevent.service;

import org.example.bigevent.pojo.Category;

import java.util.List;

public interface CategoryService {
    void addCategory(String categoryName, String categoryAlias);

    List<Category> findAllCategoryByUserId(Integer id);

    Category findDetailById(Integer id);

    void update(Category category);

    void deleteById(Integer id);
}
