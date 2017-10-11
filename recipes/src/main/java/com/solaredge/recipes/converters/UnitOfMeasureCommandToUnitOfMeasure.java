package com.solaredge.recipes.converters;

import com.solaredge.recipes.commands.UnitOfMeasureCommand;
import com.solaredge.recipes.domain.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand, UnitOfMeasure> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasure convert(UnitOfMeasureCommand source) {
        if (source == null) {
            return null;
        }
        return new UnitOfMeasure(source.getId(), source.getDescription());
    }
}
