package com.cydeo.service.impl;

import com.cydeo.enums.QuantityType;
import com.cydeo.enums.RecipeType;
import com.cydeo.model.Ingredient;
import com.cydeo.model.Recipe;
import com.cydeo.repository.RecipeRepository;
import com.cydeo.service.RecipeService;
import com.cydeo.service.ShareService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Component
public class RecipeServiceImpl implements RecipeService {

    private final Faker faker;
    private final RecipeRepository recipeRepository;
    private final ShareService shareService;

    public RecipeServiceImpl(Faker faker, RecipeRepository recipeRepository, @Qualifier("IG") ShareService shareService) {
        // not own this class and i need bean ggo config and create bean method
        this.faker = faker;
        this.recipeRepository = recipeRepository;
        this.shareService = shareService;
    }

    @Override
    public boolean prepareRecipe() {
        //create a recipe object
        Recipe recipe = new Recipe();

        //set fields
        recipe.setRecipeId(UUID.randomUUID());
        recipe.setName(faker.food().dish());
        recipe.setDuration(generatedRandomValue());
        recipe.setPreparation(faker.lorem().paragraph(5));
        recipe.setRecipeType(RecipeType.BREAKFAST);
        recipe.setIngredients(prepareIngredients());

        //save the recipe
        recipeRepository.save(recipe);

        //share recipe
        shareService.shareService(recipe);

        //return true
        return true;
    }

    private List<Ingredient> prepareIngredients() {

        //create a list

        List<Ingredient> ingredientList = new ArrayList<>();
        //fill list with random ingredients
        for(int i =0; i<generatedRandomValue(); i++){
            Ingredient ingredient = new Ingredient();

            ingredient.setName(faker.food().ingredient());
            ingredient.setQuantity(generatedRandomValue());
            ingredient.setQuantityType(QuantityType.TBSP);

            ingredientList.add(ingredient);
        }
        //return list

        return ingredientList;

    }

    private int generatedRandomValue() {
        return new Random().nextInt(20)+1;
    }
}
