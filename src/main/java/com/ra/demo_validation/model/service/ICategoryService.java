package com.ra.demo_validation.model.service;

import com.ra.demo_validation.model.entity.Category;

import java.util.List;

public interface ICategoryService
{

    List<Category> findAll();

    boolean save(Category category);

}
