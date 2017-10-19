package com.solaredge.spring5mvcrest.services;

import com.solaredge.spring5mvcrest.api.v1.model.CategoryDto;
import com.solaredge.spring5mvcrest.domain.Category;
import com.solaredge.spring5mvcrest.mapper.CategoryMapper;
import com.solaredge.spring5mvcrest.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper mapper;
    private final CategoryRepository repository;

    @Autowired
    public CategoryServiceImpl(CategoryMapper mapper, CategoryRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = repository.findAll();
        return categories.stream().map(mapper::categoryToCategoryDto).collect(Collectors.toList());
    }

    @Override
    public CategoryDto getCategoryByName(String name) {
        return mapper.categoryToCategoryDto(repository.findByName(name));
    }
}
