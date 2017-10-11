package com.solaredge.recipes.converters;

import com.solaredge.recipes.commands.NotesCommand;
import com.solaredge.recipes.commands.RecipeCommand;
import com.solaredge.recipes.domain.Notes;
import com.solaredge.recipes.domain.Recipe;
import lombok.Synchronized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {

    private final NotesToNotesCommand notesToNotesCommand;
    private final CategoryToCategoryCommand categoryToCategoryCommand;
    private final IngredientToIngredientCommand ingredientToIngredientCommand;

    @Autowired
    public RecipeToRecipeCommand(
            NotesToNotesCommand notesToNotesCommand,
            CategoryToCategoryCommand categoryToCategoryCommand,
            IngredientToIngredientCommand ingredientToIngredientCommand) {
        this.notesToNotesCommand = notesToNotesCommand;
        this.categoryToCategoryCommand = categoryToCategoryCommand;
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
    }

    @Synchronized
    @Nullable
    @Override
    public RecipeCommand convert(Recipe source) {
        if (source == null) {
            return null;
        }
        return new RecipeCommand(
                source.getId(),
                source.getDescription(),
                source.getPrepTime(),
                source.getCookTime(),
                source.getServings(),
                source.getSource(),
                source.getUrl(),
                source.getDirections(),
                source.getIngredients().stream().map(ingredientToIngredientCommand::convert).collect(Collectors.toSet()),
                null,
                source.getDifficulty(),
                notesToNotesCommand.convert(source.getNotes()),
                source.getCategories().stream().map(categoryToCategoryCommand::convert).collect(Collectors.toSet())
        );
    }
}
