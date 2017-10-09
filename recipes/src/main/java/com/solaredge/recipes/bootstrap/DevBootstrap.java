package com.solaredge.recipes.bootstrap;

import com.solaredge.recipes.domain.Category;
import com.solaredge.recipes.domain.Difficulty;
import com.solaredge.recipes.domain.Ingredient;
import com.solaredge.recipes.domain.Notes;
import com.solaredge.recipes.domain.Recipe;
import com.solaredge.recipes.domain.UnitOfMeasure;
import com.solaredge.recipes.repositories.CategoryRepository;
import com.solaredge.recipes.repositories.RecipeRepository;
import com.solaredge.recipes.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private RecipeRepository recipeRepository;
    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public DevBootstrap(
            RecipeRepository recipeRepository,
            CategoryRepository categoryRepository,
            UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        log.info("Initializing DB data");

        // Units of Measure
        UnitOfMeasure unitUom = unitOfMeasureRepository.findByDescription("Unit").get();
        UnitOfMeasure tablespoonUom = unitOfMeasureRepository.findByDescription("Tablespoon").get();
        UnitOfMeasure teaspoonUom = unitOfMeasureRepository.findByDescription("Teaspoon").get();
        UnitOfMeasure dashUom = unitOfMeasureRepository.findByDescription("Dash").get();
        UnitOfMeasure cupUom = unitOfMeasureRepository.findByDescription("Cup").get();
        UnitOfMeasure poundUom = unitOfMeasureRepository.findByDescription("Pound").get();

        // Categories
        Category mexicanCategory = categoryRepository.findByDescription("Mexican").get();
        Category americanCategory = categoryRepository.findByDescription("American").get();

        // Guacamole Recipe
        Set<Ingredient> guacmoleIngredients = new HashSet<>(Arrays.asList(
                new Ingredient("ripe avocados", new BigDecimal(2), unitUom),
                new Ingredient("Kosher salt", new BigDecimal(0.5), teaspoonUom),
                new Ingredient("fresh lime juice or lemon juice", new BigDecimal(1), tablespoonUom),
                new Ingredient("minced red onion or thinly sliced green onion", new BigDecimal(2), tablespoonUom),
                new Ingredient("serrano chiles, stems and seeds removed, minced", new BigDecimal(2), unitUom),
                new Ingredient("cilantro (leaves and tender stems), finely chopped", new BigDecimal(2), tablespoonUom),
                new Ingredient("freshly grated black pepper", new BigDecimal(1), dashUom),
                new Ingredient("ripe tomato, seeds and pulp removed, chopped", new BigDecimal(0.5), unitUom)
                ));

        Recipe guacamoleRecipe = new Recipe(
                "Perfect Guacamole",
                10,
                10,
                4,
                "Simply Recipes",
                "http://www.simplyrecipes.com/recipes/perfect_guacamole/",
                "1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of " +
                        "the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and " +
                        "Peel an Avocado.) Place in a bowl.\n" +
                        "\n" +
                        "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The " +
                        "guacamole should be a little chunky.)" +
                        "\n" +
                        "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. " +
                        "The acid in the lime juice will provide some balance to the richness of the avocado and " +
                        "will help delay the avocados from turning brown.\n" +
                        "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually " +
                        "in their hotness. So, start with a half of one chili pepper and add to the guacamole to " +
                        "your desired degree of hotness.\n" +
                        "Remember that much of this is done to taste because of the variability in the fresh " +
                        "ingredients. Start with this recipe and adjust to your taste.\n" +
                        "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the " +
                        "guacamole cover it and to prevent air reaching it. (The oxygen in the air causes " +
                        "oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n" +
                        "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your " +
                        "guacamole, add it just before serving.\n" +
                        "Variations\n" +
                        "For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your " +
                        "mashed avocados.\n",
                guacmoleIngredients,
                null,
                Difficulty.EASY,
                new Notes(
                        "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks " +
                                "of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, " +
                                "mango, or strawberries.\n" +
                                "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack " +
                                "of availability of other ingredients stop you from making guacamole.\n" +
                                "To extend a limited supply of avocados, add either sour cream or cottage cheese to " +
                                "your guacamole dip. Purists may be horrified, but so what? It tastes great.\n" +
                                "\n"
                ),
                new HashSet<>(Arrays.asList(mexicanCategory, americanCategory)));

        // Chicken Recipe
        Recipe chickenRecipe = new Recipe(
                "Spicy Chicken Nuggets",
                35,
                30,
                6,
                "Simply Recipes",
                "http://www.simplyrecipes.com/recipes/spicy_chicken_nuggets_chicharrones_de_pollo/",
                "1 Make the marinade: Whisk together the lime juice, rum, soy sauce, and sugar in a bowl until sugar has dissolved.\n" +
                        "2 Marinate the chicken: Add the chicken to the marinade and let marinate for 30 minutes at room temperature (can marinate longer chilled, but allow to come to room temp for 30 minutes before cooking).\n" +
                        "3 Heat the oil for frying: Pour enough oil in a skillet so that it comes up the sides at least a half an inch. Heat oil on medium high until it is shimmering, and a little pinch of flour sizzles when you drop it in the pan.\n" +
                        "4 Dredge the chicken: While the oil is heating, whisk together the flour, paprika, and salt in a bowl. Remove the chicken pieces from the marinade and pat dry with paper towels. Dredge the chicken pieces in the flour mixture and move to a plate.\n" +
                        "5 Fry the chicken in batches (about 3), about 3 minutes on each side, until deep golden brown and the chicken is cooked through. (If the chicken is browning too quickly, reduce the heat a bit).\n",
                new HashSet<>(Arrays.asList(
                        new Ingredient("dark rum", new BigDecimal(0.25), cupUom),
                        new Ingredient("lime juice", new BigDecimal(0.25), cupUom),
                        new Ingredient("soy sauce", new BigDecimal(0.25), cupUom),
                        new Ingredient("sugar", new BigDecimal(1), tablespoonUom),
                        new Ingredient(
                                "boneless chicken thighs or breasts, cut into 1 1/2-inch pieces",
                                new BigDecimal(1.5),
                                poundUom),
                        new Ingredient("Vegetable oil ", new BigDecimal(3), tablespoonUom),
                        new Ingredient("flour", new BigDecimal(0.5), cupUom),
                        new Ingredient("salt", new BigDecimal(0.5), tablespoonUom),
                        new Ingredient("paprika (hot or sweet)", new BigDecimal(0.5), teaspoonUom))),
                null,
                Difficulty.MODERATE,
                new Notes("Read more: http://www.simplyrecipes.com/recipes/spicy_chicken_nuggets_chicharrones_de_pollo/#ixzz4uMD3QU13"),
                new HashSet<>(Collections.singletonList(mexicanCategory)));

        recipeRepository.saveAll(new HashSet<>(Arrays.asList(guacamoleRecipe, chickenRecipe)));
    }
}
