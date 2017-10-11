package com.solaredge.recipes.converters;

import com.solaredge.recipes.commands.CategoryCommand;
import com.solaredge.recipes.domain.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryCommandToCategoryTest {

    private CategoryCommandToCategory categoryCommandToCategory;

    @Before
    public void setUp() throws Exception {
        categoryCommandToCategory = new CategoryCommandToCategory();
    }

    @Test
    public void convertTest() throws Exception {
        // given
        final Long id = 1L;
        final String description = "this is a description";

        CategoryCommand categoryCommand = new CategoryCommand(id, description);

        // when
        Category category = categoryCommandToCategory.convert(categoryCommand);

        // then
        assertEquals(id, category.getId());
        assertEquals(description, category.getDescription());
    }

}