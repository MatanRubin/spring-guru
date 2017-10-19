package com.solaredge.spring5mvcrest.mapper;

import com.solaredge.spring5mvcrest.api.v1.model.CategoryDto;
import com.solaredge.spring5mvcrest.domain.Category;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryMapperTest {
    private static final Long ID = 3L;
    private static final String NAME = "Fruits";

    private static final CategoryMapper mapper = CategoryMapper.INSTANCE;

    @Test
    public void categoryToCategoryDto() throws Exception {
        Category category = new Category(ID, NAME);

        CategoryDto dto = mapper.categoryToCategoryDto(category);

        assertEquals(category.getId(), dto.getId());
        assertEquals(category.getName(), dto.getName());
    }

}