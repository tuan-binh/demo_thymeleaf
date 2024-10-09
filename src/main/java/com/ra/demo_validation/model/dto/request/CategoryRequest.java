package com.ra.demo_validation.model.dto.request;

import com.ra.demo_validation.validation.annotation.NameExist;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;


public class CategoryRequest
{
//    @NotBlank(message = "tên không được để trống")
    @NotEmpty(message = "tên không được để trống")
    @NameExist(message = "tên đã tồn tại")
    private String categoryName;

    public CategoryRequest()
    {
    }

    public CategoryRequest(String categoryName)
    {
        this.categoryName = categoryName;
    }

    public String getCategoryName()
    {
        return categoryName;
    }

    public void setCategoryName(String categoryName)
    {
        this.categoryName = categoryName;
    }
}
