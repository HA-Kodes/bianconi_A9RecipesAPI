package com.coderscampus.controller;

import com.coderscampus.model.Recipe;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecipeController {
    // Assume recipes is a List<Recipe> populated from the recipe.txt file
    private List<Recipe> recipes;

    @GetMapping("/all-recipes")
    public List<Recipe> getAllRecipes() {
        return recipes;
    }

    @GetMapping("/gluten-free")
    public List<Recipe> getGlutenFreeRecipes() {
        return recipes.stream().filter(Recipe::getGlutenFree).toList();
    }

    @GetMapping("/vegan")
    public List<Recipe> getVeganRecipes() {
        return recipes.stream().filter(Recipe::getVegan).toList();
    }

    @GetMapping("/vegan-and-gluten-free")
    public List<Recipe> getVeganAndGlutenFreeRecipes() {
        return recipes.stream().filter(r -> r.getVegan() && r.getGlutenFree()).toList();
    }

    @GetMapping("/vegetarian")
    public List<Recipe> getVegetarianRecipes() {
        return recipes.stream().filter(Recipe::getVegetarian).toList();
    }
}