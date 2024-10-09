package com.ra.demo_validation.controller;

import com.ra.demo_validation.model.dto.request.CategoryRequest;
import com.ra.demo_validation.model.entity.Category;
import com.ra.demo_validation.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping
public class CategoryController
{
    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public String home(Model model)
    {
        model.addAttribute("categories", categoryService.findAll());
        return "categories";
    }

    @GetMapping("/add")
    public String viewAdd(Model model)
    {
        model.addAttribute("categoryRequest", new CategoryRequest());
        return "add";
    }

    @PostMapping("/add")
    public String handleAdd
            (
            @Valid @ModelAttribute CategoryRequest categoryRequest,
            BindingResult bindingResult,
            Model model
    )
    {
        if(bindingResult.hasErrors()) {
            model.addAttribute("categoryRequest",categoryRequest);
            return "add";
        }

        Category category = new Category();
        category.setCategoryName(categoryRequest.getCategoryName());

        categoryService.save(category);
        return "redirect:/";
    }

}
