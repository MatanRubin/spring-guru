package com.solaredge.recipes.converters;

import com.solaredge.recipes.commands.NotesCommand;
import com.solaredge.recipes.domain.Notes;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesToNotesCommand implements Converter<Notes, NotesCommand> {

    @Synchronized
    @Nullable
    @Override
    public NotesCommand convert(Notes source) {
        if (source == null) {
            return null;
        }
        return new NotesCommand(source.getId(), source.getRecipeNotes());
    }
}
