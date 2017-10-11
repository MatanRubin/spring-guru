package com.solaredge.recipes.controllers;

import com.solaredge.recipes.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipeController {

    private RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/show/{recipeId}")
    public String showById(@PathVariable String recipeId, Model model) {
        model.addAttribute("recipe", recipeService.getRecipeById(new Long(recipeId)));
        return "recipe/show";
    }
}
