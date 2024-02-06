package org.example.bigevent.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.bigevent.mapper.ArticleMapper;
import org.example.bigevent.pojo.Article;
import org.example.bigevent.pojo.PageBean;
import org.example.bigevent.service.ArticleService;
import org.example.bigevent.utlities.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;

    @Override
    public void add(Article article) {
        Map<String, Object> f =  ThreadLocalUtil.get();
        final Integer id = (Integer) f.get("id");
        article.setCreateUser(id);
        articleMapper.add(article);
    }

    @Override
    public PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state) {
        PageHelper.startPage(pageNum, pageSize);
        Map<String, Object> f =  ThreadLocalUtil.get();
        List<Article> articles =  articleMapper.list((Integer) f.get("id") ,categoryId, state);
        Page<Article> pageArticles = (Page<Article>) articles;
        return new PageBean<>(pageArticles.getTotal(), pageArticles.getResult());
    }

    @Override
    public Article findDetailById(Integer id){
        return articleMapper.findDetailById(id);
    }

    @Override
    public void update(Article article) {
        articleMapper.update(article);
    }

    @Override
    public void delete(Integer id){
        articleMapper.delete(id);
    }

    @Override
    public List<Article> findByState(String state) {
        return articleMapper.findByState(state);
    }

    @Override
    public List<Article> all() {
        return articleMapper.all();
    }
}
