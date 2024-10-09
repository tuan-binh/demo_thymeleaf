package com.ra.demo_validation.model.entity;

import com.ra.demo_validation.validation.annotation.NameExist;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "categories")
public class Category
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name")
    private String categoryName;

    private Boolean status = true;

    public Category()
    {
    }

    public Category(Long id, String categoryName, Boolean status)
    {
        this.id = id;
        this.categoryName = categoryName;
        this.status = status;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getCategoryName()
    {
        return categoryName;
    }

    public void setCategoryName(String categoryName)
    {
        this.categoryName = categoryName;
    }

    public Boolean getStatus()
    {
        return status;
    }

    public void setStatus(Boolean status)
    {
        this.status = status;
    }
}
