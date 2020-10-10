package com.macro.mall.tiny.service;

import com.macro.mall.tiny.mbg.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> listAllCategory();

    int createCategory(Category category);

    int updateCategory(Long id, Category category);

    int deleteCategory(Long id);

    List<Category> listCategory(int pageNum, int pageSize);

    Category getCategory(Long id);

    int deleteAll();
}
