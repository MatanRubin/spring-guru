package com.solaredge.recipes.converters;

import com.solaredge.recipes.commands.UnitOfMeasureCommand;
import com.solaredge.recipes.domain.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasureCommand convert(UnitOfMeasure unitOfMeasure) {
        if (unitOfMeasure == null) {
            return null;
        }
        return new UnitOfMeasureCommand(unitOfMeasure.getId(), unitOfMeasure.getDescription());
    }
}
