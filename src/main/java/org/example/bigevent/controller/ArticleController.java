package org.example.bigevent.controller;

import jakarta.validation.constraints.NotNull;
import org.apache.ibatis.annotations.Delete;
import org.example.bigevent.pojo.Article;
import org.example.bigevent.pojo.PageBean;
import org.example.bigevent.pojo.Result;
import org.example.bigevent.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("article")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @PostMapping
    public Result add(@RequestBody @Validated Article article) {
        System.out.println(article.getState());
        articleService.add(article);
        return Result.success();
    }

    @GetMapping
    public Result<PageBean<Article>> list(
            Integer pageNum, Integer pageSize,
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) String state) {
        return Result.success(articleService.list(pageNum, pageSize, categoryId, state));
    }

    @GetMapping("search")
    public Result<List<Article>> search() {
        return Result.success(articleService.all());
    }

    @GetMapping("detail")
    public Result<Article> detail(@RequestParam @NotNull Integer id){
        return Result.success(articleService.findDetailById(id));
    }

    @PutMapping
    public Result update(@RequestBody @Validated Article article) {
        articleService.update(article);
        return Result.success();
    }

    @DeleteMapping
    public Result delete(@RequestParam @NotNull Integer id){
        articleService.delete(id);
        return Result.success();
    }
}
