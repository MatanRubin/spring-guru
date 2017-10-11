package com.solaredge.recipes.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NotesCommand {
    private Long id;
    private String recipeNotes;
}
