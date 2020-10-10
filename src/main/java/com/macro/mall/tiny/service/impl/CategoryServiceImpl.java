package com.macro.mall.tiny.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.tiny.mbg.mapper.CategoryMapper;
import com.macro.mall.tiny.mbg.model.Category;
import com.macro.mall.tiny.mbg.model.CategoryExample;
import com.macro.mall.tiny.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * CategoryService实现类
 * Created by macro on 2019/4/19.
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> listAllCategory() {
        return categoryMapper.selectByExample(new CategoryExample());
    }

    @Override
    public int createCategory(Category category) {
        return categoryMapper.insertSelective(category);
    }

    @Override
    public int updateCategory(Long id, Category category) {
        category.setId(Math.toIntExact(id));
        return categoryMapper.updateByPrimaryKeySelective(category);
    }

    @Override
    public int deleteCategory(Long id) {
        return categoryMapper.deleteByPrimaryKey(Math.toIntExact(id));
    }

    @Override
    public List<Category> listCategory(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return categoryMapper.selectByExample(new CategoryExample());
    }

    @Override
    public Category getCategory(Long id) {
        return categoryMapper.selectByPrimaryKey(Math.toIntExact(id));
    }

    @Override
    public int deleteAll() {
        return categoryMapper.deleteByExample(new CategoryExample());
    }
}
