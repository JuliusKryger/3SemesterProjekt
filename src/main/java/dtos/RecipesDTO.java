package dtos;

import entities.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipesDTO {

    List<RecipeDTO> recipes = new ArrayList<>();

    public RecipesDTO(List<RecipeDTO> recipes) {
        this.recipes = recipes;
    }

   /* public RecipesDTO(List<Recipe> entity) {
        entity.forEach((recipe -> recipes.add(new RecipeDTO(recipe))));
    }

    */

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
