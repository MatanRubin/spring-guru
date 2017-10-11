package com.solaredge.recipes.converters;

import com.solaredge.recipes.commands.IngredientCommand;
import com.solaredge.recipes.domain.Ingredient;
import lombok.Synchronized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

    private final UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

    @Autowired
    public IngredientToIngredientCommand(UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand) {
        this.unitOfMeasureToUnitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand;
    }

    @Synchronized
    @Nullable
    @Override
    public IngredientCommand convert(Ingredient source) {
        if (source == null) {
            return null;
        }
        return new IngredientCommand(
                source.getId(),
                source.getDescription(),
                source.getAmount(),
                unitOfMeasureToUnitOfMeasureCommand.convert(source.getUnitOfMeasure())
        );
    }
}
