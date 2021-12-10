package dtos;

import entities.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeDTO {
    private Integer id;
    private String title;
    private int readyInMinutes;
    private int servings;
    List<ExtendedIngredientDTO> extendedIngredients = new ArrayList<>();

    public RecipeDTO(Recipe recipe) {
        this.id = recipe.getId();
        this.readyInMinutes = recipe.getReadyInMinutes();
        this.servings = recipe.getServings();
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