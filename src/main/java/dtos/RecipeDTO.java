package dtos;

import entities.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeDTO {
    private Integer id;
    private String title;
    private int readyInMinutes;
    private int servings;
    /*
    private String image;
    private String instructions;
    List<IngredientsDTO> ingredients;
     */
    List<ExtendedIngredientDTO> extendedIngredients = new ArrayList<>();

    public RecipeDTO(Recipe recipe) {
        this.id = recipe.getId();
        this.readyInMinutes = recipe.getReadyInMinutes();
        this.servings = recipe.getServings();
        /*
        this.image = recipe.getImage();
        this.instructions = recipe.getInstructions();
         */
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReadyInMinutes() {
        return readyInMinutes;
    }

    public void setReadyInMinutes(int readyInMinutes) {
        this.readyInMinutes = readyInMinutes;
    }


    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }
    /*

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public List<IngredientsDTO> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientsDTO> ingredients) {
        this.ingredients = ingredients;
    }
    */

    @Override
    public String toString() {
        return "RecipeDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", readyInMinutes=" + readyInMinutes +
                ", servings=" + servings +
                /*", image='" + image + '\'' +
                ", instructions='" + instructions + '\'' +
                ", ingredients=" + ingredients +
                 */
                '}';
    }
}