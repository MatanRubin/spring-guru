package com.solaredge.spring5mvcrest.services;

import com.solaredge.spring5mvcrest.api.v1.model.CategoryDto;
import com.solaredge.spring5mvcrest.domain.Category;
import com.solaredge.spring5mvcrest.mapper.CategoryMapper;
import com.solaredge.spring5mvcrest.repositories.CategoryRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class CategoryServiceTest {

    private static final String NAME = "Fruits";
    CategoryService categoryService;

    @Mock
    CategoryRepository categoryRepository;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        categoryService = new CategoryServiceImpl(CategoryMapper.INSTANCE, categoryRepository);
    }

    @Test
    public void getAllCategories() throws Exception {
        // given
        List<Category> categories = Arrays.asList(new Category(), new Category(), new Category());
        when(categoryRepository.findAll()).thenReturn(categories);

        // when
        List<CategoryDto> fetchedCategories = categoryService.getAllCategories();

        // then
        assertEquals(categories.size(), fetchedCategories.size());
    }

    @Test
    public void getCategoryByName() throws Exception {
        // given
        Category category = new Category(1L, NAME);
        when(categoryRepository.findByName(Mockito.anyString())).thenReturn(category);

        // when
        CategoryDto categoryByName = categoryService.getCategoryByName(NAME);

        // then
        assertEquals(category.getName(), categoryByName.getName());
    }

}