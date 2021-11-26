package entities;

import dtos.RecipeDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "recipes")
public class Recipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String title;
    private int readyInMinutes;
    private int servings;
    //private String image;
    //private String instructions;

    /*@OneToMany
    private List<Ingredients> ingredientsList;
*/
    public Recipe() {
    }

    public Recipe(Integer id, String title, int readyInMinutes, int servings) {
        this.id = id;
        this.title = title;
        this.readyInMinutes = readyInMinutes;
        this.servings = servings;
        //this.image = image;
        //this.instructions = instructions;
        //this.ingredientsList = new ArrayList<>();
    }

    public Recipe(RecipeDTO recipeDTO) {
        this.id = recipeDTO.getId();
        this.title = recipeDTO.getTitle();
        this.readyInMinutes = recipeDTO.getReadyInMinutes();
        this.servings = recipeDTO.getServings();
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

    /*public String getImage() {
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

    public List<Ingredients> getIngredientsList() {
        return ingredientsList;
    }

    public void setIngredientsList(List<Ingredients> ingredientsList) {
        this.ingredientsList = ingredientsList;
    }*/




}
