package com.macro.mall.tiny.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.tiny.mbg.mapper.CategoryMapper;
import com.macro.mall.tiny.mbg.model.Category;
import com.macro.mall.tiny.mbg.model.CategoryExample;
import com.macro.mall.tiny.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * CategoryService实现类
 * Created by macro on 2019/4/19.
 */
@Service
@CacheConfig(cacheNames="category")
public class CategoryServiceImpl implements CategoryService {
    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> listAllCategory() {
        return categoryMapper.selectByExample(new CategoryExample());
    }

    @Override
    @CacheEvict(allEntries=true)
    public int createCategory(Category category) {
        Category category1= new Category();
        BeanUtils.copyProperties(category,category1);
        int count=categoryMapper.insertSelective(category1);
        return count;

    }

    @Override
    @CacheEvict(allEntries=true)
    public int updateCategory(Long id, Category category) {
        category.setId(Math.toIntExact(id));
        return categoryMapper.updateByPrimaryKeySelective(category);
    }

    @Override
    @CacheEvict(allEntries=true)
    public int deleteCategory(Long id) {
        return categoryMapper.deleteByPrimaryKey(Math.toIntExact(id));
    }

    @Override
    @Cacheable(key="'category '+ #p0 + '-' + #p1")
    public List<Category> listCategory(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return categoryMapper.selectByExample(new CategoryExample());
    }

    @Override
    @Cacheable(key="'category '+ #p0")
    public Category getCategory(Long id) {
        return categoryMapper.selectByPrimaryKey(Math.toIntExact(id));
    }

    @Override
    @CacheEvict(allEntries=true)
    public int deleteAll() {
        return categoryMapper.deleteByExample(new CategoryExample());
    }
}
