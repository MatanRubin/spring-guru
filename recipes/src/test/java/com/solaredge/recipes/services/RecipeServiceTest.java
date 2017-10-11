package com.solaredge.recipes.services;

import com.solaredge.recipes.domain.Recipe;
import com.solaredge.recipes.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class RecipeServiceTest {
    private RecipeService recipeService;

    @Mock
    private RecipeRepository recipeRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void getRecipesTest() throws Exception {
        // given
        Set<Recipe> recipes = new HashSet<>();
        Recipe recipe = new Recipe();
        recipes.add(recipe);
        when(recipeRepository.findAll()).thenReturn(recipes);

        // when
        Iterable<Recipe> fetchedRecipes = recipeService.getRecipes();

        // then
        assertEquals(1, fetchedRecipes.spliterator().getExactSizeIfKnown());
        Mockito.verify(recipeRepository, times(1)).findAll();
        Mockito.verify(recipeRepository, never()).findById(anyLong());
    }

    @Test
    public void getRecipeByIdTest() throws Exception {
        // given
        Recipe recipe = new Recipe();
        Long recipeId = 1L;
        recipe.setId(recipeId);
        when(recipeRepository.findById(anyLong())).thenReturn(Optional.of(recipe));

        // when
        Recipe recipeById = recipeService.getRecipeById(1L);

        // then
        assertEquals(recipeId, recipeById.getId());
        Mockito.verify(recipeRepository, times(1)).findById(anyLong());
        Mockito.verify(recipeRepository, never()).findAll();
    }

}