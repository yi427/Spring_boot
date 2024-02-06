package org.example.bigevent.service;

import org.example.bigevent.pojo.Article;
import org.example.bigevent.pojo.PageBean;

import java.util.List;

public interface ArticleService {
    void add(Article article);

    PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state);

    Article findDetailById(Integer id);

    void update(Article article);

    void delete(Integer id);

    List<Article> findByState(String state);

    List<Article> all();
}
