package com.solaredge.spring5mvcrest.controllers;

import com.solaredge.spring5mvcrest.api.v1.model.CategoryDto;
import com.solaredge.spring5mvcrest.controllers.v1.CategoryController;
import com.solaredge.spring5mvcrest.services.CategoryService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CategoryControllerTest {

    @Mock
    CategoryService categoryService;

    @InjectMocks
    CategoryController categoryController;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(categoryController).build();
    }

    @Test
    public void getAllCategories() throws Exception {
        // given
        List<CategoryDto> categoryDtos = Arrays.asList(
                new CategoryDto(),
                new CategoryDto()
        );

        // when
        when(categoryService.getAllCategories()).thenReturn(categoryDtos);

        // then
        mockMvc.perform(get("/api/v1/categories/").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.categories", hasSize(2)));
    }

    @Test
    public void getCategoryByName() throws Exception {
        // given
        String name = "Food";
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(1L);
        categoryDto.setName(name);

        // when
        when(categoryService.getCategoryByName(anyString())).thenReturn(categoryDto);

        // then
        mockMvc.perform(get("/api/v1/categories/food").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo(name)));
    }

}