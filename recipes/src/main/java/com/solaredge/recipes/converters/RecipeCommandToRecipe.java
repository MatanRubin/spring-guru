package com.solaredge.recipes.converters;

import com.solaredge.recipes.commands.RecipeCommand;
import com.solaredge.recipes.domain.Recipe;
import lombok.Synchronized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {

    private final NotesCommandToNotes notesCommandToNotes;
    private final CategoryCommandToCategory categoryCommandToCategory;
    private final IngredientCommandToIngredient ingredientCommandToIngredient;

    @Autowired
    public RecipeCommandToRecipe(
            NotesCommandToNotes notesCommandToNotes,
            CategoryCommandToCategory categoryCommandToCategory,
            IngredientCommandToIngredient ingredientCommandToIngredient) {
        this.notesCommandToNotes = notesCommandToNotes;
        this.categoryCommandToCategory = categoryCommandToCategory;
        this.ingredientCommandToIngredient = ingredientCommandToIngredient;
    }

    @Synchronized
    @Nullable
    @Override
    public Recipe convert(RecipeCommand source) {
        if (source == null) {
            return null;
        }
        return new Recipe(
                source.getId(),
                source.getDescription(),
                source.getPrepTime(),
                source.getCookTime(),
                source.getServings(),
                source.getSource(),
                source.getUrl(),
                source.getDirections(),
                source.getIngredients().stream().map(ingredientCommandToIngredient::convert).collect(Collectors.toSet()),
                null,
                source.getDifficulty(),
                notesCommandToNotes.convert(source.getNotes()),
                source.getCategories().stream().map(categoryCommandToCategory::convert).collect(Collectors.toSet())
        );
    }
}
