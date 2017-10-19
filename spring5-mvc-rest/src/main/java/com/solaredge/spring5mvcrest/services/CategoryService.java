package com.solaredge.spring5mvcrest.services;

import com.solaredge.spring5mvcrest.api.v1.model.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getAllCategories();
    CategoryDto getCategoryByName(String name);
}
