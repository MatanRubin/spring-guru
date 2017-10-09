package com.solaredge.recipes.services;

import com.solaredge.recipes.domain.Recipe;

public interface RecipeService {

    public Iterable<Recipe> getRecipes();
}
