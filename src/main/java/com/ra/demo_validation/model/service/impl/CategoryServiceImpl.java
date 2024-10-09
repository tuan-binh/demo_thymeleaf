package com.ra.demo_validation.model.service.impl;

import com.ra.demo_validation.model.dao.ICategoryDao;
import com.ra.demo_validation.model.entity.Category;
import com.ra.demo_validation.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
public class CategoryServiceImpl implements ICategoryService
{
    @Autowired
    private ICategoryDao categoryDao;

    @Override
    public List<Category> findAll()
    {
        return categoryDao.findAll();
    }

    @Override
    public boolean save(Category category)
    {
        return categoryDao.save(category);
    }
}
