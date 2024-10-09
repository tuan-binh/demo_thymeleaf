package com.ra.demo_validation.model.dao;

import com.ra.demo_validation.model.entity.Category;

import java.util.List;

public interface ICategoryDao
{
    List<Category> findAll();

    boolean save(Category category);

    boolean existByCategoryName(String categoryName);
}
