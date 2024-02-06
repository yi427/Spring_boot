package org.example.bigevent.service.impl;

import org.example.bigevent.mapper.CategoryMapper;
import org.example.bigevent.pojo.Category;
import org.example.bigevent.service.CategoryService;
import org.example.bigevent.utlities.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
    @Override
    public void addCategory(String categoryName, String categoryAlias) {
        final Map<String, Object> f = ThreadLocalUtil.get();
        Integer id = (Integer) f.get("id");
        categoryMapper.addCategory(categoryName, categoryAlias, id);
    }

    @Override
    public List<Category> findAllCategoryByUserId(Integer id) {
        return categoryMapper.findAllCategoryByUserId(id);
    }

    @Override
    public Category findDetailById(Integer id) {
        return categoryMapper.findDetailById(id);
    }

    @Override
    public void update(Category category) {
        categoryMapper.update(category);
    }

    @Override
    public void deleteById(Integer id) {
        categoryMapper.deleteById(id);
    }
}
