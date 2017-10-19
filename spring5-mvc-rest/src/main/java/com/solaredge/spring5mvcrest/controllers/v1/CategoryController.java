package com.solaredge.spring5mvcrest.controllers.v1;

import com.solaredge.spring5mvcrest.api.v1.model.CategoryDto;
import com.solaredge.spring5mvcrest.api.v1.model.CategoryListDto;
import com.solaredge.spring5mvcrest.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/categories/")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<CategoryListDto> getAllCategories() {
        return new ResponseEntity<CategoryListDto>(
                new CategoryListDto(categoryService.getAllCategories()),
                HttpStatus.OK);
    }

    @GetMapping("{name}")
    public ResponseEntity<CategoryDto> getCategoryByName(@PathVariable String name) {
        return new ResponseEntity<CategoryDto>(
                categoryService.getCategoryByName(name),
                HttpStatus.OK
        );
    }
}
