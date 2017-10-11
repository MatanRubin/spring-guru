package com.solaredge.recipes.services;

import com.solaredge.recipes.domain.Recipe;

public interface RecipeService {

    Iterable<Recipe> getRecipes();

    Recipe getRecipeById(Long id);
}
