package org.example.bigevent.controller;

import jakarta.validation.constraints.NotNull;
import org.example.bigevent.pojo.Category;
import org.example.bigevent.pojo.Result;
import org.example.bigevent.service.CategoryService;
import org.example.bigevent.utlities.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;
    @PostMapping
    public Result addCategory(@RequestBody Map<String, String> f) {
        final String categoryName = f.get("categoryName");
        final String categoryAlias = f.get("categoryAlias");
        System.out.println(categoryName);
        if (categoryName == null ||  categoryName.isEmpty()) return Result.error("categoryName don't null!");
        if (categoryAlias == null || categoryAlias.isEmpty()) return Result.error("categoryAlias don't null!");
        categoryService.addCategory(categoryName, categoryAlias);
        return Result.success();
    }

    @GetMapping
    public Result<List<Category>> listCategory() {
        Map<String, Object> f = ThreadLocalUtil.get();
        Integer id = (Integer) f.get("id");
        List<Category> l =  categoryService.findAllCategoryByUserId(id);
        return Result.success(l);
    }

    @GetMapping("detail")
    public Result<Category> detail(@RequestParam @NotNull Integer id) {
        return Result.success(categoryService.findDetailById(id));
    }

    @PutMapping
    public Result update(@RequestBody @Validated(Category.Update.class) Category category) {
        categoryService.update(category);
        return Result.success();
    }

    @DeleteMapping
    public Result delete(@RequestParam @NotNull Integer id) {
        System.out.println(id);
        categoryService.deleteById(id);
        return Result.success();
    }
}
