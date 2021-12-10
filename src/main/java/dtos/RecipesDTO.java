package dtos;

import entities.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipesDTO {

    List<RecipeDTO> recipes = new ArrayList<>();

    public RecipesDTO(List<RecipeDTO> recipes) {
        this.recipes = recipes;
    }

    public List<RecipeDTO> getRecipes() {
        return recipes;
    }

    @Override
    public String toString() {
        return "RecipesDTO{" +
                "recipes=" + recipes +
                '}';
    }
}
